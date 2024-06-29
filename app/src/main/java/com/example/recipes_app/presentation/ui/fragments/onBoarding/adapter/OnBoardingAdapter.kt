package com.example.recipes_app.presentation.ui.fragments.onBoarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recipes_app.databinding.ItemOnBoardingBinding
import com.example.recipes_app.presentation.model.OnBoarding
import com.example.recipes_app.presentation.utils.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit)
    : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding(
            "https://i.pinimg.com/564x/f3/b8/77/f3b877c9784fdaefa4ff22bf06958348.jpg",
            "title 1",
            "desc 1"
        ),
        OnBoarding(
            "https://i.pinimg.com/564x/8f/2e/1f/8f2e1f05972fa37ab9657e89cbd5a7ec.jpg",
            "title 2",
            "desc 2"
        ),
        OnBoarding(
            "https://i.pinimg.com/564x/ee/4a/f0/ee4af034b392877cf96b8e180ea724d1.jpg",
            "title 3",
            "desc 3"
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
            binding.boardingImage.loadImage(onBoarding.image)
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