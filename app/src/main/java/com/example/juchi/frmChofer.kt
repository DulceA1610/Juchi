package com.example.juchi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class frmChofer : AppCompatActivity() {
    lateinit var transporte: EditText
    lateinit var tmpretraso: EditText
    lateinit var motivo: EditText
    lateinit var retraso: RadioButton
    lateinit var cancelacion: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frm_chofer)
        var enviar: Button=findViewById(R.id.btnenviar)
        var regresar: Button=findViewById(R.id.btnregresar)

        transporte = findViewById(R.id.transporte)
        tmpretraso = findViewById(R.id.tmpretraso)
        motivo = findViewById(R.id.motivo)
        retraso = findViewById(R.id.retraso)
        cancelacion = findViewById(R.id.cancelacon)
        enviar.setOnClickListener {
            if (testreportes()) {
                var retrasO:String
                if (retraso.isChecked){
                    retrasO="S"
                }else{
                    retrasO="N"
                }
                var cancelacioN:String
                if (cancelacion.isChecked){
                    cancelacioN="S"
                }else{
                    cancelacioN="N"
                }
                var datos = reportesClass(transporte.text.toString(), tmpretraso.text.toString(), motivo.text.toString(),
                    retrasO, cancelacioN)
                var SQLManager = SQLManager(this)
                var response = SQLManager.addreportes(this, datos)
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
        regresar.setOnClickListener {
            val intent = Intent(this@frmChofer, FrmAcceso::class.java)
            startActivity(intent)
        }
    }
    fun testreportes(): Boolean {
        var response = true
        if (transporte.text.isEmpty()||tmpretraso.text.isEmpty()||motivo.text.isEmpty()){
            response=false
        }
        return response
    }
}