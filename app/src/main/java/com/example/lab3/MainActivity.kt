package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonMakePhoto = findViewById<Button>(R.id.btn_make_photo)

        buttonMakePhoto.setOnClickListener(){
            val username = findViewById<EditText>(R.id.username_edit_text).text.toString()

            if(username.isEmpty()) {
                Toast.makeText(applicationContext, "Имя не введено =(", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var myShowImageIntent = Intent(this, ShowImageActivity::class.java)
            myShowImageIntent.putExtra("username_edit_text", username)

            startActivity(myShowImageIntent)
            //Toast.makeText(applicationContext, "Всё ок", Toast.LENGTH_SHORT).show()

        }
    }

}
