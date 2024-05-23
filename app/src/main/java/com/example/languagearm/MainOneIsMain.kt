package com.example.languagearm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.languagearm.Fragments.FirstFragment
import com.example.languagearm.Fragments.FourthFragment
import com.example.languagearm.Fragments.SecondFragment
import com.example.languagearm.Fragments.SixthFragment

class MainOneIsMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_one_is_main_activity)
        supportFragmentManager.beginTransaction().replace(
            R.id.mainFrame,
            FirstFragment()
        ).commit();
        WorkWithMenuBtn()
    }

    private fun WorkWithMenuBtn()
    {
        val fragment1 : ImageButton = findViewById( R.id.btn1)
        val fragment2 : ImageButton=  findViewById (R.id.btn2)
        val fragment3 : ImageButton = findViewById (R.id.btn3)
        val fragment4 : ImageButton = findViewById (R.id.btn4)



        fragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.mainFrame,
                FirstFragment()
            ).commit();
        }



        fragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.mainFrame,
                SecondFragment()
            ).commit();
        }



        fragment3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.mainFrame,
               FourthFragment()
            ).commit();
        }



        fragment4.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(
                R.id.mainFrame,
                SixthFragment()
            ).commit();
        }
    }
}