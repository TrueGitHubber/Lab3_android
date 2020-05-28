package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ShowImageActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    var ALREADY_TOOK_PHOTO = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)

        if(!ALREADY_TOOK_PHOTO) {
            var cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            ALREADY_TOOK_PHOTO = true
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE){
            val imageView = findViewById<ImageView>(R.id.imageView)
            val usernameUnderPhotoTextView = findViewById<TextView>(R.id.username_under_photo)

            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)

            usernameUnderPhotoTextView.text = intent.getStringExtra("username_edit_text")
        }
        //      super.onActivityResult(requestCode, resultCode, data)
    }
}
