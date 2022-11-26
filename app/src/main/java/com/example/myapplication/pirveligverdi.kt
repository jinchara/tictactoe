package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class pirveligverdi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pirveligverdi)
        supportActionBar?.hide()
        val user1 = findViewById<EditText>(R.id.saxeli1)
        val user2 = findViewById<EditText>(R.id.saxeli2)
        val playgame = findViewById<Button>(R.id.playgame)

        playgame.setOnClickListener {
            val resultuser1 = user1.text.toString()
            val resultuser2 = user2.text.toString()

            if (resultuser1 == "" || resultuser2 == ""){
                Toast.makeText(this , "Enter players name" , Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java).also {
                    it.putExtra("first player" , resultuser1)
                    it.putExtra("second player" , resultuser2)
                }
                startActivity(intent)
            }
        }

    }






}





