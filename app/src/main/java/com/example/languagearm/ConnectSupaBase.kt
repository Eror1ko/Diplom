package com.example.languagearm

import android.content.Context
import android.graphics.drawable.Drawable
import com.example.languagearm.Fragments.FirstFragment
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.runBlocking
import org.json.JSONArray

class ConnectSupaBase {






    fun insertUser(Имя : String )
    {
//        runBlocking {
//            signIn()
//            uuid = SbObject.client().auth.retrieveUserForCurrentSession(updateSession = true).id;
//            val user = DataClass.User(uuid, name, birthday, TempData.selectedGender);
//            SbObject.client().postgrest["Users"].insert(user)
//        }
    }

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

                    val tempItem = DataClass.City(
                        id,
                        name,
                        description,
                        picture
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


}