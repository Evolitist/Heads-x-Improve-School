package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.parcel.Parcelize
import java.util.*

class Activity5 : AppCompatActivity() {
    lateinit var message : data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        val butGoTo3 = findViewById<Button>(R.id.button3)
        val txtView = findViewById<TextView>(R.id.textView)
        val saveBut = findViewById<Button>(R.id.saveButton)
        val edTxt = findViewById<EditText>(R.id.editText)
        butGoTo3.setOnClickListener {
            val edTxt1 = findViewById<EditText>(R.id.editTextTextPersonName)
            val mess = edTxt1.text.toString()
            val intent = Intent()
            intent.putExtra("MESSAGE", mess)
            setResult(RESULT_OK, intent)
            finish()
        }
        if (savedInstanceState != null){
            message = savedInstanceState.getParcelable("DATA")!!
            txtView.text = message.name
        }

        saveBut.setOnClickListener {
            message = data(edTxt.text.toString())
            txtView.text = message.name
            edTxt.text.clear()
        }
    }

    @Parcelize
    class data(var name: String) : Parcelable {
    }

    override fun onSaveInstanceState(outState: Bundle)  {
        super.onSaveInstanceState(outState)
        outState.putParcelable("DATA",message)
    }

}

