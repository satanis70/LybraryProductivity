package com.example.test

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher

object ToastObj {
    var openText: String? = null
    fun getInfo(string: String){
        openText = string
    }
    fun toast() : String? {
        return openText
    }
    fun pickImage(registerfor: ActivityResultLauncher<String>) {
        registerfor.launch("image/*")
    }
    fun newActivity(activity: Activity, text: String){
        val intent = Intent(activity, MainActivityModule::class.java)
        intent.putExtra("text", text)
        activity.startActivity(intent)
    }
}