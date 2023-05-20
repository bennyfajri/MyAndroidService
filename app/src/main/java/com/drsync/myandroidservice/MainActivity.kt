package com.drsync.myandroidservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drsync.myandroidservice.backgroundservice.BackgroundService
import com.drsync.myandroidservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bgServiceIntent = Intent(this, BackgroundService::class.java)
        binding.apply {
            btnStartBackgroundService.setOnClickListener {
                startService(bgServiceIntent)
            }
            btnStopBackgroundService.setOnClickListener {
                stopService(bgServiceIntent)
            }
        }
        
    }
}