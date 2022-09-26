package com.example.drinkwaterapp.sync

import android.app.IntentService
import android.content.Intent

class IncrementReminderIntentService: IntentService("DrinkWaterReminderIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.action
        IncrementReminderTask.executeTaskIncrement(this, action)
    }

}