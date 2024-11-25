package com.example.juchi
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Accesochofer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesochofer)

        val continuar: Button = findViewById(R.id.continuar) as Button

        continuar.setOnClickListener {
            val intent = Intent(this@Accesochofer, frmChofer::class.java)
            startActivity(intent)
        }
    }
}