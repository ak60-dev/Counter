package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val counterTextView : TextView = findViewById(R.id.textView)
        val counter : Button = findViewById(R.id.counter)
        val reset : Button = findViewById(R.id.reset)

        // Display the initial count
        counterTextView.text = count.toString()

        // Increment the count when the "Increase" button is clicked
        counter.setOnClickListener{
            count++
            counterTextView.text = count.toString() // ubdate textview
        }

        reset.setOnClickListener{
            count=0
            counterTextView.text = count.toString()
        }
    }
}