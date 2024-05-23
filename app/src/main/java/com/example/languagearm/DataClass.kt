package com.example.languagearm

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.VibrationEffect.Composition
import io.github.jan.supabase.gotrue.admin.AdminUserBuilder
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toDatePeriod
import java.util.Date

class DataClass {

    data class City(
        val id: Int = 0,
        val название: String = "",
        val описание: String = "",
        val фото: Drawable? )


    data class Hs
        (
        val id : Int = 0,
        val фото: Drawable?,
        val название: String = "",
        val описание: String = ""
                )


    @kotlinx.serialization.Serializable
    data class User(
        val id:String = "",
        var имя :String ="",
        var email: String = ""
    )


    data class Diction(
        val id: Int = 0,
        val слово : String = "",
        val произношение : String = "",
        val перевод : String = "",
        val id_situation : Int = 0

    )
    data class Situations(
        val id : Int = 0,
        val название : String = ""
    )










}
