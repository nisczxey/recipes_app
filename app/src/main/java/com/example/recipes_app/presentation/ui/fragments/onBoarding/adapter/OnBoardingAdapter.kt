package com.example.recipes_app.presentation.ui.fragments.onBoarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recipes_app.R
import com.example.recipes_app.databinding.ItemOnBoardingBinding
import com.example.recipes_app.presentation.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit)
    : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = listOf(
        OnBoarding(
            R.raw.welcome_lottie,
            "Welcome"
        ),
        OnBoarding(
            R.raw.lottie_second,
            "Recipes",
            "Here you can find interesting recipes"
        ),
        OnBoarding(
            R.raw.lottie_have_fun,
            "Have fun!"
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.boardingImage.setAnimation(onBoarding.image)
            binding.boardingTvTitle.text = onBoarding.title
            binding.boardingTvDesc.text = onBoarding.text

            if (absoluteAdapterPosition == data.lastIndex) {
                binding.btnStart.visibility = View.VISIBLE
                binding.btnSkip.visibility = View.GONE
            }

            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.btnSkip.setOnClickListener {
                onClick()
            }
        }
    }
}