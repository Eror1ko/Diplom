package com.example.languagearm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch
import org.json.JSONException
import java.lang.Exception

class authorization : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_activity)

        val btn1 : Button = findViewById(R.id.btnAutoriz)
        val mail1 : EditText = findViewById(R.id.mailAutoriz)
        val pass1 : EditText = findViewById(R.id.PassAutoriz)


        btn1.setOnClickListener {

            if (mail1.text.isNotEmpty() && pass1.text.isNotEmpty())
            {
                ConnectSupaBase().SignIn(mail1.text.toString(), pass1.text.toString())

                ConnectSupaBase().SelectUser()
                Toast.makeText(this,"Вы авторизовались!",Toast.LENGTH_SHORT).show()
                val Intenttt = Intent(this, MainOneIsMain::class.java )
                startActivity(Intenttt)
            }else
            {
                Toast.makeText(this,"Для авторизации введите корректные данные от аккаунта!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }
