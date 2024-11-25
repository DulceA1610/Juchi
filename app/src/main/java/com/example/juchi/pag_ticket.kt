package com.example.juchi

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream

class pag_ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pag_ticket)
        val lugardestino = intent.getStringExtra("Destino")
        val numtransporte = intent.getIntExtra("notransporte", 0)
        val salidatransporte = intent.getStringExtra("salida")
        val llegadatransporte = intent.getStringExtra("llegada")
        val preciotransporte = intent.getIntExtra("precio", 0)

        var salir: Button = findViewById(R.id.btnsalir)
        var destino: TextView = findViewById(R.id.destino)
        var imprimir: Button = findViewById(R.id.btnImprimir)
        var precio: TextView = findViewById(R.id.precio)
        var num: TextView = findViewById(R.id.no_transporte)
        var salida: TextView = findViewById(R.id.salida)
        var llegada: TextView = findViewById(R.id.llegada)

        destino.text = lugardestino.toString()
        precio.text = "$" + preciotransporte.toString() + ".00 mx(pesos mexicanos)"
        num.text = "0" + numtransporte.toString()
        salida.text = salidatransporte.toString()
        llegada.text = llegadatransporte.toString()

        imprimir.setOnClickListener {
            // Crear un documento PDF
            val document = Document()

            // Definir la ruta y nombre del archivo PDF
            val fileName = "ticket.pdf"
            val filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + fileName
            // Crear el archivo PDF
            val pdfWriter = PdfWriter.getInstance(document, FileOutputStream(filePath))
            // Abrir el documento para escritura
            document.open()
            // Agregar contenido al PDF
            document.add(Paragraph("Destino: $lugardestino"))
            document.add(Paragraph("Número de transporte: $numtransporte"))
            document.add(Paragraph("Salida: $salidatransporte"))
            document.add(Paragraph("Llegada: $llegadatransporte"))
            document.add(Paragraph("Precio: $$preciotransporte.00 mx (pesos mexicanos)"))
            // Cerrar el documento
            document.close()
            // Descargar automáticamente
            pdfWriter.close()

            // Notificar al usuario que se ha descargado el archivo
            showToast("Ticket descargado como $fileName en la carpeta Descargas")
        }
        salir.setOnClickListener {
            finish()
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
