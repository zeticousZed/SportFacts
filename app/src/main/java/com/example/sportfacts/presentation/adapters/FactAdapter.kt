package com.example.sportfacts.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportfacts.data.model.FactModel
import com.example.sportfacts.databinding.ItemSportsFactBinding

class FactAdapter(private val sportsFacts: List<FactModel>) :
    RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    class FactViewHolder(binding: ItemSportsFactBinding) : RecyclerView.ViewHolder(binding.root) {
        val factTextView: TextView = binding.tvItemFact
        val factImageView: ImageView = binding.ivItemFact

        fun bindData(imageDrawable: Int, text: String) {
            factTextView.text = text
            factImageView.setImageResource(imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val binding = ItemSportsFactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val facts = sportsFacts[position]
        holder.bindData(facts.pictureBackground,facts.fact)
    }

    override fun getItemCount(): Int {
        return sportsFacts.size
    }
}