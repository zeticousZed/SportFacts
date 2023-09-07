package com.example.sportfacts.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportfacts.data.collection.CollectionTitle
import com.example.sportfacts.databinding.FragmentSportListBinding
import com.example.sportfacts.presentation.adapters.MainAdapter

class SportListFragment : Fragment() {
    private lateinit var binding: FragmentSportListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.rvMain
        val adapter = MainAdapter(CollectionTitle.listTitle)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }
}