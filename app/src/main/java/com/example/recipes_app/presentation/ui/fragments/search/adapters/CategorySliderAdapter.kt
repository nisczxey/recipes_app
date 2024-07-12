package com.example.recipes_app.presentation.ui.fragments.search.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes_app.R
import com.example.recipes_app.presentation.model.CategoryUIO
import com.example.recipes_app.presentation.ui.fragments.search.adapters.diffUtil.CategoryItemDiffCallback
import com.example.recipes_app.presentation.utils.loadImage

class CategorySliderAdapter(
    private val context: Context,
    private val onCategoryClick: (String) -> Unit
) : ListAdapter<CategoryUIO, CategorySliderAdapter.ViewHolder>(CategoryItemDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context).inflate(R.layout.item_meal_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = getItem(position).name
        holder.categoryImg.loadImage(getItem(position).imgUrl)

        holder.itemView.setOnClickListener{
           onCategoryClick(getItem(position).name)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.tv_item_category)
        val categoryImg: ImageView = itemView.findViewById(R.id.img_item_category)
    }


}