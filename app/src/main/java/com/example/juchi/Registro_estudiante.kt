package com.example.juchi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registro_estudiante : AppCompatActivity() {
    lateinit var nombre: EditText
    lateinit var apellido: EditText
    lateinit var edad: EditText
    lateinit var correoelectronico: EditText
    lateinit var contrasena: EditText
    lateinit var numtelefono: EditText
    lateinit var matricula: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_estudiante)
        nombre= findViewById(R.id.NombreE)
        apellido = findViewById(R.id.ApellidoE)
        edad = findViewById(R.id.EdadE)
        correoelectronico = findViewById(R.id.CoreoE)
        contrasena = findViewById(R.id.ContrasenaE)
        numtelefono = findViewById(R.id.NumE)
        matricula = findViewById(R.id.MatriculaE)

        val atras: Button = findViewById(R.id.btnatras) as Button
        val registro: Button = findViewById(R.id.btnregistrarse) as Button
        atras.setOnClickListener {
            val intent = Intent(this@Registro_estudiante, FrmAcceso::class.java)
            startActivity(intent)
        }
        registro.setOnClickListener {
            if (testData()) {
                var datos = alumnosClass(nombre.text.toString(), apellido.text.toString(), edad.text.toString(), correoelectronico.text.toString(),
                    contrasena.text.toString(), numtelefono.text.toString(), matricula.text.toString())
                var SQLManager = SQLManager(this)
                var response = SQLManager.addalumno(this, datos)
                if (response){
                    Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Los datos no se pudieron guardar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Todos los datos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun testData(): Boolean {
        var response = true
        if (nombre.text.isEmpty()||apellido.text.isEmpty()||edad.text.isEmpty()||correoelectronico.text.isEmpty()
            ||contrasena.text.isEmpty()||numtelefono.text.isEmpty()||matricula.text.isEmpty()){
            response=false
        }
        return response
    }
}