package com.example.recipes_app.presentation.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.recipes_app.R

fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun View.chooseRandomBackgroundColor(context: Context){
    val colorList = listOf(
        context.getColor(R.color.pastel_blue),
        context.getColor(R.color.copper),
        context.getColor(R.color.lemon_meringue),
        context.getColor(R.color.laurel_green),
        context.getColor(R.color.pastel_pink)
    )
    this.setBackgroundColor(colorList.random())
}