package com.example.drinkwaterapp.sync

import android.content.Context
import com.example.drinkwaterapp.utils.PreferencesUtils

class DecrementReminderTask {

    companion object{
        const val ACTION_DECREMENT_WATER_COUNT = "action-decrement-water-count"

        private fun decrementWaterCount(context: Context){
            PreferencesUtils.decrementWaterCount(context)
        }

        fun executeTaskDecrement(context: Context, action: String?){
            if (ACTION_DECREMENT_WATER_COUNT == action){
                decrementWaterCount(context)
            }
        }
    }

}