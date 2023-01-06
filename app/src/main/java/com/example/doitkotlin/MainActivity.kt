package com.example.doitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doitkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.toast.setOnClickListener {

//            Toast.makeText(this, "토스트 출력!", Toast.LENGTH_SHORT).show()
        }
    }

}

