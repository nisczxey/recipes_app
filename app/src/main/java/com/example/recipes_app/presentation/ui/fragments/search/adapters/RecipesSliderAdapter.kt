package com.example.recipes_app.presentation.ui.fragments.search.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recipes_app.R
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.ui.fragments.search.adapters.diffUtil.RecipesItemDiffCallback
import com.example.recipes_app.presentation.utils.chooseRandomBackgroundColor
import com.example.recipes_app.presentation.utils.loadImage

class RecipesSliderAdapter(
    private val context: Context
) : ListAdapter<RecipeUIO, RecipesSliderAdapter.RecipesViewHolder>(
    RecipesItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater
            .from(context).inflate(R.layout.item_slider_recipes, parent, false)
        return RecipesViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.name.text = getItem(position).name
        getItem(position).imgUrl.let { holder.img.loadImage(it.toString()) }
        holder.cardViewContainer.chooseRandomBackgroundColor(context)
    }

    inner class RecipesViewHolder(private val itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.item_tv_recipe_name)
        val img: ImageView = itemView.findViewById(R.id.item_img_recipe)
        val cardViewContainer: LinearLayout = itemView.findViewById(R.id.cardview_container)
    }

}