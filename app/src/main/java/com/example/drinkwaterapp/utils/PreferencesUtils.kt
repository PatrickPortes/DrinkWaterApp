package com.example.drinkwaterapp.utils

import android.content.Context
import android.preference.PreferenceManager

class PreferencesUtils {

    companion object {
        const val KEY_WATER_COUNT = "water-count"
        private const val DEFAULT_COUNT = 0

        @Synchronized
        private fun setWaterCount(context: Context, glassesOfWater: Int){

            val prefs= PreferenceManager.getDefaultSharedPreferences(context)
            val editor = prefs.edit()
            editor.putInt(KEY_WATER_COUNT, glassesOfWater)
            editor.apply()
        }

        @Synchronized
        fun getWaterCount(context: Context) =
            PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(KEY_WATER_COUNT, DEFAULT_COUNT)

        @Synchronized
        fun incrementWaterCount(context: Context){
            var waterCount: Int = getWaterCount(context)
            setWaterCount(context, ++waterCount)
        }

        @Synchronized
        fun decrementWaterCount(context: Context){
            var waterCount: Int = getWaterCount(context)
            setWaterCount(context, --waterCount)
            if ( waterCount < 0){
                setWaterCount(context, 0)
            }
        }

        @Synchronized
        fun resetWaterCount(context: Context){
            setWaterCount(context, glassesOfWater = 0)
        }

    }
}