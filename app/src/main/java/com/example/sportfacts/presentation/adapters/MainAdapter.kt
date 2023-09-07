package com.example.sportfacts.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sportfacts.R
import com.example.sportfacts.data.model.TypesSportModel
import com.example.sportfacts.databinding.MainCategorySportBinding
import com.example.sportfacts.presentation.adapters.helpers.PositionBranchConstant
import com.example.sportfacts.presentation.fragments.FactListFragment

class MainAdapter(private val sportsTypes: Array<TypesSportModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(binding:MainCategorySportBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.tvCategorySport
        val mainImageView: ImageView = binding.ivCategorySport

        fun bindData(imageDrawable: Int, text: String) {
            titleTextView.text = text
            mainImageView.setImageResource(imageDrawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainCategorySportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val type = sportsTypes[position]
        holder.bindData(type.typesSportPicture,type.typesSportTitle)
        holder.itemView.setOnClickListener {
            navigateToNextFragment(holder,position)
        }
    }

    override fun getItemCount(): Int {
        return sportsTypes.size
    }

    private fun navigateToNextFragment(holder:ViewHolder,position: Int){
        val context = holder.itemView.context
        if (context is AppCompatActivity) {
            val fragmentManager = context.supportFragmentManager.beginTransaction()
            val navigateFragment = FactListFragment()
            val getPositionForAdapter = PositionBranchConstant.mapPositionToCategory(position)
            val bundle = Bundle()
            bundle.putSerializable("category", getPositionForAdapter)
            navigateFragment.arguments = bundle
            fragmentManager.replace(R.id.fragmentContainerView, navigateFragment)
            fragmentManager.addToBackStack(null)
            fragmentManager.commit()
        }
    }
}