package com.example.dofus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.submit)
        val intent : Intent = Intent(this, Type_monster_page::class.java)
        button.setOnClickListener { startActivity(intent) }
    }
}