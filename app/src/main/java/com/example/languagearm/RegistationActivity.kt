package com.example.languagearm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONException
import java.lang.Exception

class RegistationActivity : AppCompatActivity() {

    fun String.TrueOrFalseMail() : Boolean
    {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registation_activity)



        val btn : Button = findViewById(R.id.regBtn)
        val txtbutton : TextView = findViewById(R.id.txtBtn1)
        val name : EditText = findViewById(R.id.nameId)
        val mail : EditText = findViewById(R.id.mailId)
        val pass : EditText = findViewById(R.id.passId)
        data class UserData( val Login : String = "")



        //Обработчик на регистрацию пользователя
        btn.setOnClickListener {
        val  name00 = name.text.toString()
        val  mail00 = mail.text.toString()
        val  pass00 = pass.text.toString()

            ConnectSupaBase().SignUp(mail.text.toString(),pass.text.toString())
        }

        txtbutton.setOnClickListener {

            val Intenttt1 = Intent(this, authorization::class.java )
            startActivity(Intenttt1)

//            Toast.makeText(this,"Адрес изменен",Toast.LENGTH_SHORT).show()
        //            val ttt = Intent(this, authorization::class.java)
//            startActivity(ttt)
        }

    }
}