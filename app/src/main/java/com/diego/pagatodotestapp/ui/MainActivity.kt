package com.diego.pagatodotestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.diego.pagatodotestapp.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sha256hex: String = org.apache.commons.codec.digest.DigestUtils.sha256Hex("56Forj2018.")
        Log.d("Encrypt", sha256hex)
    }
}