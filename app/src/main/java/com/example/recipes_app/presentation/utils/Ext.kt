package com.example.recipes_app.presentation.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.recipes_app.R

fun Fragment.showToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun View.chooseRandomBackgroundColor(context: Context) {
    val colorList = listOf(
        context.getColor(R.color.pastel_blue),
        context.getColor(R.color.copper),
        context.getColor(R.color.lemon_meringue),
        context.getColor(R.color.laurel_green),
        context.getColor(R.color.pastel_pink)
    )
    this.setBackgroundColor(colorList.random())
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.inVisible() {
    this.visibility = View.GONE
}

fun Float.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()