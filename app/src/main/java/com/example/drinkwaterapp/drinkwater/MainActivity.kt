package com.example.drinkwaterapp.drinkwater

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.drinkwaterapp.R
import com.example.drinkwaterapp.sync.DrinkWaterReminderIntentService
import com.example.drinkwaterapp.sync.DrinkWaterReminderTask
import com.example.drinkwaterapp.utils.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateWaterCount()

        imageViewCopo.setOnClickListener(){
            incrementWaterHandler()
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)

    }

    fun updateWaterCount(){
        val count = PreferencesUtils.getWaterCount(this)
        textViewContagem.text = "$count"
    }

    fun incrementWaterHandler(){
        val intent = Intent(this, DrinkWaterReminderIntentService::class.java)
        intent.action = DrinkWaterReminderTask.ACTION_INCREMENT_WATER_COUNT
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

        if(PreferencesUtils.KEY_WATER_COUNT == key){
            updateWaterCount()
        }

    }


}