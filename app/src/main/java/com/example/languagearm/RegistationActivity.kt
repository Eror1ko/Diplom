package com.example.languagearm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
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
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import org.json.JSONException
import java.lang.Exception

class RegistationActivity : AppCompatActivity() {


    public var datebase = createSupabaseClient(
        supabaseUrl = "https://capkoptvklizkewzohvm.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNhcGtvcHR2a2xpemtld3pvaHZtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg3ODUzNDUsImV4cCI6MjAyNDM2MTM0NX0.qi330ccqUCMr17_dzLnRRH5cz2PT9rV1RB9QJhbOsx4"
    ) {
        install(GoTrue)
        install(Postgrest)
}

    fun String.TrueOrFalseMail() : Boolean
    {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }


    val btn : Button = findViewById(R.id.regBtn)
    val name : EditText = findViewById(R.id.nameId)
    val mail : EditText = findViewById(R.id.mailId)
    val pass : EditText = findViewById(R.id.passId)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registation_activity)

        data class UserData( val Login : String = "")


        //Обработчик на регистрацию пользователя
        btn.setOnClickListener {
        val  name00 = name.text.toString()
        val  mail00 = mail.text.toString()
        val  pass00 = pass.text.toString()

            try {
                //Проверка на пустые поля
                if (name00 == null || mail00 == null || pass00 == null )
                {
                    Toast.makeText(applicationContext, "Ошибка! Не все поля заполнены!", Toast.LENGTH_SHORT).show()
                }
                //Проверка на корректный ввод электронной почты
                else if(mail00.toBoolean() == mail00.TrueOrFalseMail())
                {
                    Toast.makeText(applicationContext, "Некорректная электронная почта!", Toast.LENGTH_SHORT).show()
                }
                else
                try {
                    val User = UserData(Login = mail.text.toString())
                    //Корутина
                    lifecycleScope.launch {
                        val user1 = datebase.gotrue.signUpWith(Email) {
                            email = mail.text.toString()
                            password = pass.text.toString()
                        }
                    }
                    //Занесение введённых данных в таблицу "Пользователи"
                    lifecycleScope.launch {
                        datebase.postgrest["Пользователь"].insert(User)
                    }
                    //Переход на окно авторизации для последующего входа в аккаунт
                    val Intentik = Intent(this, authorization::class.java)
                    startActivity(Intentik)
                //Ошибка при регистрации
                } catch (ex : Exception)
                {
                    Toast.makeText(applicationContext, "Ошибка в регистрации", Toast.LENGTH_SHORT).show()
                }
            }catch (ex : JSONException)
            {
                Log.e("ERROR", ex.message.toString())
            }
        }
    }
}