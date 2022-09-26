package com.example.drinkwaterapp.sync

import android.app.IntentService
import android.content.Intent

class DecrementReminderIntentService: IntentService("TesteService") {


    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.action
        DecrementReminderTask.executeTaskDecrement(this, action)
    }


}