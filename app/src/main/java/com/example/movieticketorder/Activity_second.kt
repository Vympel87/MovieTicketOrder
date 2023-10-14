package com.example.movieticketorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieticketorder.databinding.ActivitySecondBinding

class Activity_second : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        with(binding) {
            user.text = name
        }
    }
}