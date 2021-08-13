package com.example.test

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat.startActivity

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

}