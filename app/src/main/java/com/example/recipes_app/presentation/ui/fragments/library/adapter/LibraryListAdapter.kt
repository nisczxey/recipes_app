package com.example.recipes_app.presentation.ui.fragments.library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes_app.databinding.ItemLibraryListBinding
import com.example.recipes_app.presentation.model.RecipeUIO

class LibraryListAdapter :
    ListAdapter<RecipeUIO, LibraryListAdapter.LibraryListViewHolder>(LibraryItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryListViewHolder {
        val viewBinding = ItemLibraryListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LibraryListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: LibraryListViewHolder, position: Int) {
        val recipe = currentList[position]
        holder.bind(recipe)
    }

    inner class LibraryListViewHolder(private val itemBinding: ItemLibraryListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(recipe: RecipeUIO) {
            itemBinding.tvRecipeName.text = recipe.name
        }
    }

}