package com.example.sportfacts.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportfacts.data.collection.CollectionFacts
import com.example.sportfacts.data.constant.CategorySport
import com.example.sportfacts.data.model.FactModel
import com.example.sportfacts.databinding.FragmentFactListBinding
import com.example.sportfacts.presentation.adapters.FactAdapter

class FactListFragment : Fragment() {
    private lateinit var binding:FragmentFactListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }
    fun defineSportCategory(category:CategorySport) : List<FactModel>{
        when(category){
            CategorySport.BASEBALL -> {return CollectionFacts.BaseballFacts.listFact}
            CategorySport.FOOTBALL -> {return CollectionFacts.FootballFacts.listFact}
            CategorySport.BASKETBALL -> {return CollectionFacts.BasketBallFacts.listFact}
            CategorySport.CHESS -> {return CollectionFacts.ChessFacts.listFact}
        }
    }
    fun getData(){
        val category = arguments?.get("category") as? CategorySport
        if (category != null) {
            val recyclerView = binding.rvFact
            val adapter = FactAdapter(defineSportCategory(category))
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        }
    }
}