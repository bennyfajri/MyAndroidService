package com.drsync.myandroidservice

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drsync.myandroidservice.backgroundservice.BackgroundService
import com.drsync.myandroidservice.databinding.ActivityMainBinding
import com.drsync.myandroidservice.foregroundservice.ForegroundService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bgServiceIntent = Intent(this, BackgroundService::class.java)
        val foregroundServiceIntent = Intent(this, ForegroundService::class.java)
        binding.apply {
            btnStartBackgroundService.setOnClickListener {
                startService(bgServiceIntent)
            }
            btnStopBackgroundService.setOnClickListener {
                stopService(bgServiceIntent)
            }
            btnStartForegroundService.setOnClickListener {
                if(Build.VERSION.SDK_INT >= 26) {
                    startForegroundService(foregroundServiceIntent)
                } else {
                    startService(foregroundServiceIntent)
                }
            }
            btnStopForegroundService.setOnClickListener {
                stopService(foregroundServiceIntent)
            }
        }

    }
}