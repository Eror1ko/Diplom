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
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch
import org.json.JSONException
import java.lang.Exception

class authorization : AppCompatActivity()
{

    public var datebase = createSupabaseClient(
        supabaseUrl = "https://capkoptvklizkewzohvm.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNhcGtvcHR2a2xpemtld3pvaHZtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg3ODUzNDUsImV4cCI6MjAyNDM2MTM0NX0.qi330ccqUCMr17_dzLnRRH5cz2PT9rV1RB9QJhbOsx4"
    ) {

        install(GoTrue)
        install(Postgrest)
    }

    //функция на проверку корректной электронной почты пользователя
    fun String.TrueOrFalseMail() : Boolean
    {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization_activity)

        val btn1 : Button = findViewById(R.id.btnAutoriz)
        val mail1 : EditText = findViewById(R.id.mailAutoriz)
        val pass1 : EditText = findViewById(R.id.PassAutoriz)
        // переход на следующее окно
        val nextPage = Intent(this, MainOneIsMain::class.java)
        // обработчик кнопки для авторизации
    btn1.setOnClickListener {
        val mail0 = mail1.text.toString()
        val pass0 = pass1.text.toString()
            //обработчка на ошибки
        try {
            //проверка на пустные значения
            if(mail0 == null || pass0 == null )
            {
                Toast.makeText(applicationContext, "Ошибка! Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            }
                // проверка на корретную почту
            else if(mail0.toBoolean() == mail0.TrueOrFalseMail() )
            {
                Toast.makeText(applicationContext, "Некорректная электронная почта!", Toast.LENGTH_SHORT).show()
            }
            else
                //Корутина
                lifecycleScope.launch {
                    //обработка на ошибки
                    try {
                        //Подключение объекта для запоминания сеанса пользователя
                        datebase.gotrue.loginWith(Email)
                        {
                        email = mail1.text.toString()
                        password = pass1.text.toString()
                        }
                        //Уведомление о успешной авторизации
                        Toast.makeText(applicationContext, "Вы авторизовались!", Toast.LENGTH_SHORT).show()
                        startActivity(nextPage)
                    }
                    //ошибка на авторизацию пользователя
                    catch (ex : Exception)
                    {
                        Toast.makeText(applicationContext, "Ошибка в авторизации", Toast.LENGTH_SHORT).show()
                    }
                }
        }catch (ex : JSONException)
        {
            Log.e("ERROR", ex.message.toString())
        }
    }
    }
}