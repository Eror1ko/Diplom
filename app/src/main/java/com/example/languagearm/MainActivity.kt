package com.example.languagearm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       TimerKo();

    }
    fun TimerKo()
    {
        val timer = object : CountDownTimer(2000,1000)
        {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent( this@MainActivity,RegistationActivity::class.java)
                startActivity(intent)

            }
        }
        timer.start()
    }
}