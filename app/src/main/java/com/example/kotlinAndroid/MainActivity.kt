package com.example.kotlinAndroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onCreateAge(view: View) {
     var yearsofBreat:Int=editText.text.toString().toInt();
        val carentYear=Calendar.getInstance().get(Calendar.YEAR);
        val myage=carentYear-yearsofBreat;
        tvShow.text="ddd"+myage
    }
}
