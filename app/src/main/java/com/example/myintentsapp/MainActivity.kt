package com.example.myintentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)

        val btnMoveActivity = findViewById<Button>(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener {
            onClick()
        }

        val btnOpenImage = findViewById<Button>(R.id.btnOpenImage)
        btnOpenImage.setOnClickListener {
            openGallery()
        }
    }

    private fun onClick() {
        val intent = Intent(applicationContext, MoveActivity::class.java)
        startActivity(intent)
    }

    // Fungsi untuk membuka galeri dan memilih gambar
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*" // Mengatur MIME type untuk memilih gambar
        startActivityForResult(intent, 100) // Memulai activity untuk memilih gambar
    }

    // Menangani hasil dari pemilihan gambar
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            imageView.setImageURI(selectedImageUri) // Menampilkan gambar di ImageView
        }
    }
}