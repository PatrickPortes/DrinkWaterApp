package com.example.drinkwaterapp.drinkwater

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.drinkwaterapp.R
import com.example.drinkwaterapp.sync.IncrementReminderIntentService
import com.example.drinkwaterapp.sync.IncrementReminderTask
import com.example.drinkwaterapp.sync.DecrementReminderTask
import com.example.drinkwaterapp.sync.DecrementReminderIntentService
import com.example.drinkwaterapp.utils.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateWaterCount()

        buttonsListeners()

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)

    }

    fun buttonsListeners(){
        imageViewCopo.setOnClickListener(){
            incrementWaterHandler()
        }
        imageViewAumentar.setOnClickListener(){
            incrementWaterHandler()
        }
        imageViewDiminuir.setOnClickListener(){
            decrementWaterHandler()
        }
        imageViewReset.setOnClickListener(){
            resetWaterCount()
        }
    }

    fun updateWaterCount(){
        val count = PreferencesUtils.getWaterCount(this)
        textViewContagem.text = "$count"
    }

    fun incrementWaterHandler(){
        val intent = Intent(this, IncrementReminderIntentService::class.java)
        intent.action = IncrementReminderTask.ACTION_INCREMENT_WATER_COUNT
        startService(intent)
    }

    fun decrementWaterHandler(){
        val intent = Intent(this, DecrementReminderIntentService::class.java)
        intent.action = DecrementReminderTask.ACTION_DECREMENT_WATER_COUNT
        startService(intent)
    }

    fun resetWaterCount(){
        PreferencesUtils.resetWaterCount(this)
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