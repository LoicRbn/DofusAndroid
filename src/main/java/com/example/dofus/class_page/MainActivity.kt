package com.example.dofus.class_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dofus.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.submit)
        val intent : Intent = Intent(this, MonsterActivity::class.java)
        button.setOnClickListener { startActivity(intent) }

        val button_name = findViewById<Button>(R.id.byname)
        val intent_name : Intent = Intent(this, monster_by_name::class.java)
        button_name.setOnClickListener { startActivity(intent_name) }


        val button_pv = findViewById<Button>(R.id.bypv)
        val intent_pv : Intent = Intent(this, monster_by_pv::class.java)
        button_pv.setOnClickListener { startActivity(intent_pv) }

        val button_pa = findViewById<Button>(R.id.bypa)
        val intent_pa : Intent = Intent(this, monster_by_pa::class.java)
        button_pa.setOnClickListener { startActivity(intent_pa) }

        val button_pm = findViewById<Button>(R.id.bypm)
        val intent_pm : Intent = Intent(this, monster_by_pm::class.java)
        button_pm.setOnClickListener { startActivity(intent_pm) }
    }
}