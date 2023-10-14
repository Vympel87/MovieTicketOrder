package com.example.movieticketorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.movieticketorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1500)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnIn.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@MainActivity, Activity_second::class.java)
                intentToSecondActivity.putExtra(EXTRA_NAME, inpUsername.text.toString())
                startActivity(intentToSecondActivity)
            }
            Log.d(TAG, "onCreate: dipanggil")
        }
    }
}