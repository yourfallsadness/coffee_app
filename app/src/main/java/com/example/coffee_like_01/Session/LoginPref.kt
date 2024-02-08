package com.example.coffee_like_01.Session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.coffee_like_01.AuthActivity
import com.example.coffee_like_01.ItemsActivity

class LoginPref {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var context: Context
    var PRIVATEMODE : Int = 0

    constructor(context: Context){
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATEMODE)
        editor = pref.edit()
    }

    companion object{
        val PREF_NAME = "Login_Preference"
        val IS_AUTH = "isAuth"
        val KEY_LOGIN = "user_login"
        val KEY_PASSWORD = "user_password"
        val KEY_EMAIL = "user_email"
    }

    fun createLoginSession(user_login: String, user_password: String, user_email: String){
        editor.putBoolean(IS_AUTH, true)
        editor.putString(KEY_LOGIN, user_login)
        editor.putString(KEY_PASSWORD, user_password)
        editor.putString(KEY_EMAIL, user_email)
        editor.commit()
    }

    fun checkLogin(){
        if (!this.isAuth()){
            var i : Intent = Intent(context, ItemsActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    fun getUserDetails(): HashMap<String, String>{
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_LOGIN, pref.getString(KEY_LOGIN, null)!!)
        (user as HashMap).put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null)!!)
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL, null)!!)
        return user
    }

    fun LogoutUser(){
        editor.clear()
        editor.commit()
        var i : Intent = Intent(context, ItemsActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(i)
    }

    fun isAuth(): Boolean{
        return pref.getBoolean(IS_AUTH, false)
    }
}