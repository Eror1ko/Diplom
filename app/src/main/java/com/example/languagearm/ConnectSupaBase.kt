package com.example.languagearm

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.StrictMode
import com.example.languagearm.Fragments.FirstFragment
import com.example.languagearm.Fragments.SecondFragment
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import java.net.URL

class ConnectSupaBase {







    fun SignUp(Email1 : String, Pass : String)
    {
        runBlocking {
            SB.supaBase.auth.signUpWith(Email)
            {
                email = Email1
                password = Pass
            }
        }
    }

    fun SignIn(emailo : String, passo : String)
    {
        runBlocking {
            SB.supaBase.auth.signInWith(Email)
            {
                email = emailo
                password = passo
            }
        }
    }


    suspend fun CityRecycler() {
        if(DataTime.infoData.isEmpty())
        {
//            val image: Drawable? = ctx.getDrawable(R.drawable.flag);

            val city = SB.client().postgrest["city"].select()
            val arrayObject = JSONArray(city.data)
            if (arrayObject.length() != DataTime.infoData.size) {
                DataTime.infoData.clear();
                for (i in 0 until arrayObject.length()) { //step 1

                    val itemObj = arrayObject.getJSONObject(i)
                    val id = itemObj.getInt("id")
                    val name = itemObj.getString("название")
                    val description = itemObj.getString("описание");
                    val picture = itemObj.getString("фото")
                    val image = ImageDown(picture)

                    val tempItem = DataClass.City(
                        id,
                        name,
                        description,
                        image
                    )
                    DataTime.infoData.add(tempItem)




//                    try {
//
//                        FirstFragment().customAdapter.notifyDataSetChanged()
//                    }
//                    catch (ex : Exception)
//                    {
//
//                    }

                }
            }
        }

    }
    suspend fun HistoryRecycler() {
        if(DataTime.historyData.isEmpty())
        {
//            val image: Drawable? = ctx.getDrawable(R.drawable.flag);

            val city = SB.client().postgrest["history"].select()
            val arrayObject = JSONArray(city.data)
            if (arrayObject.length() != DataTime.historyData.size) {
                DataTime.historyData.clear();
                for (i in 0 until arrayObject.length()) { //step 1

                    val itemObj = arrayObject.getJSONObject(i)
                    val id = itemObj.getInt("id")
                    val name = itemObj.getString("название")
                    val description = itemObj.getString("описание");
                    val picture = itemObj.getString("фото")
                    val image = ImageDown(picture)

                    val tempItem = DataClass.Hs(
                        id,
                        image,
                        name,
                        description
                    )
                    DataTime.historyData.add(tempItem)




//                    try {
//
//                        FirstFragment().customAdapter.notifyDataSetChanged()
//                    }
//                    catch (ex : Exception)
//                    {
//
//                    }

                }
            }
        }

    }

    suspend fun SituationsRecycler() {
        if(DataTime.situations.isEmpty())
        {
            val city = SB.client().postgrest["situation_dictionary"].select()
            val arrayObject = JSONArray(city.data)
            if (arrayObject.length() != DataTime.situations.size) {
                DataTime.situations.clear();
                for (i in 0 until arrayObject.length()) { //step 1

                    val itemObj = arrayObject.getJSONObject(i)
                    val id = itemObj.getInt("id")
                    val name = itemObj.getString("название")


                    val tempItem = DataClass.Situations(
                        id,
                        name
                    )
                    DataTime.situations.add(tempItem)




                    try {

                        SecondFragment.sitadapter.notifyDataSetChanged()
                    }
                    catch (ex : Exception)
                    {

                    }

                }
            }
        }
    }

   suspend  fun DictionaryRecycler() {
        if(DataTime.dictionary.isEmpty())
        {
//            val image: Drawable? = ctx.getDrawable(R.drawable.flag);


                val city = SB.client().postgrest["dictionary"].select()
                val arrayObject = JSONArray(city.data)
                if (arrayObject.length() != DataTime.dictionary.size) {
                    DataTime.dictionary.clear();
                    for (i in 0 until arrayObject.length()) { //step 1

                        val itemObj = arrayObject.getJSONObject(i)
                        val id = itemObj.getInt("id")
                        val text = itemObj.getString("слово")
                        val accent = itemObj.getString("произношение")
                        val translate = itemObj.getString("перевод")
                        val id_sit = itemObj.getInt("id_situation")


                        val tempItem = DataClass.Diction(

                            id,
                            text,
                            accent,
                            translate,
                            id_sit
                        )
                        DataTime.dictionary.add(tempItem)

                        try {

                           // SecondFragment.dictionAd.notifyDataSetChanged()
                            DataTime().sortDict1()
                        }
                        catch (ex : Exception)
                        {

                        }
                    }




                }
        }
    }



    fun ImageDown(url: String): Drawable? {
        val download = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(download)

        try {
            val imageUrl = URL(url)
            val input = imageUrl.openStream()
            val bitmap = BitmapDrawable.createFromStream(input, "image")
            return bitmap
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    fun InsertName() {
//        SignIn(Pass, DataTime.user.email)
        runBlocking {
            val uuid = SB.client().auth.retrieveUserForCurrentSession(updateSession = true).id
            val user = DataClass.User(uuid, DataTime.user.имя);
            SB.client().postgrest["users"].insert(user)

        }

    }


    fun SelectUser()
    {
        runBlocking {
            val user = SB.client().postgrest["users"].select()

            val itemObj = JSONArray(user.data).getJSONObject(0)

            val id = itemObj.getString("id")
            val name = itemObj.getString("имя")
            val email = SB.client().auth.retrieveUserForCurrentSession(updateSession = true).email.toString()

            val tempItem = DataClass.User(
                id,
                name,
                email
            )
            DataTime.user = tempItem;
        }
    }


}