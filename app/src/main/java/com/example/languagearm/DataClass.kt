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
        val фото: String = "", )


    @kotlinx.serialization.Serializable
    data class User(
        val id:String = "",
        var name:String ="",
        var birthday:String = "01.01.2000",
        var gender:Int = 1,
        var email: String = ""
    )










}
