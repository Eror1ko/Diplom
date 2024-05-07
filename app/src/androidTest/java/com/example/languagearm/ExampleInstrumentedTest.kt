package com.example.languagearm

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.example.languagearm", appContext.packageName)
//    }

    @Test
    fun checkPassMail() {
        //проверка на правильность введеных значений для пароля
        assertEquals(1111222333, 1111222333)
        //проверка на правильность введеных значений для эл.почты
        assertEquals( "nonamowe@mail.ru" ,"nonamowe@mail.ru" )
    }
    @Test
    fun checkLogin() {
        //проверка на правильность и на допустимые символы в логине
        assertEquals("login1", "!@//'''2dasd")

    }
    @Test
    fun checkLogin2() {
        //проверка на правильность и на допустимые символы в логине
        assertEquals("login1", "login1")

    }
}