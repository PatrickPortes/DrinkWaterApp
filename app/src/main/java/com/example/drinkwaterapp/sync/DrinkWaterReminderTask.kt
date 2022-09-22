package com.example.drinkwaterapp.sync

import android.content.Context
import com.example.drinkwaterapp.utils.PreferencesUtils

class DrinkWaterReminderTask {

    companion object{
        const val ACTION_INCREMENT_WATER_COUNT = "action-increment-water-count"

        private fun incrementWaterCount(context: Context){
            PreferencesUtils.incrementWaterCount(context)
        }

        fun executeTask(context: Context, action: String?){
            if (ACTION_INCREMENT_WATER_COUNT == action){
                incrementWaterCount(context)
            }
        }
    }

}