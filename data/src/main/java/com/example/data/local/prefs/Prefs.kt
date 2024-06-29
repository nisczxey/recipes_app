package com.example.data.local.prefs

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)


    fun isOnBoardingShowed(): Boolean {
        return pref.getBoolean(BOARD_KEY, false)
    }

    fun onBoardingShowed() {
        pref.edit().putBoolean(BOARD_KEY, true).apply()
    }

    companion object {
        const val PREF_KEY = "pref.key"
        const val BOARD_KEY = "board.key"
    }
}
