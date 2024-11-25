package com.example.juchi

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLManager(context: Context): SQLiteOpenHelper(context, "usuarios.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE alumnos(nombre VARCHAR(50)PRIMARY KEY, apellido VARCHAR(50), " +
                "edad VARCHAR(50),correoelectronico VARCHAR(50), contraseña VARCHAR(50), numtelefono VARCHAR(50)," +
                "matricula VARCHAR(50))")
        db!!.execSQL("CREATE TABLE chofer(nombre VARCHAR(50)PRIMARY KEY, apellidochofer VARCHAR(50), " +
                "edadchofer VARCHAR(50),correoelectronicochofer VARCHAR(50), contraseña VARCHAR(50), numtelefonochofer VARCHAR(50)," +
                "folio VARCHAR(50))")
        db!!.execSQL("CREATE TABLE reportes(transporte VARCHAR(50)PRIMARY KEY, tiemporetraso VARCHAR(50), " +
                "motivo VARCHAR(50),retraso VARCHAR(1), cancelación VARCHAR(1))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    fun addalumno(context: Context, datos:alumnosClass):Boolean{
        var response = true
        var contentValues=ContentValues()
        contentValues.put("nombre",datos.nombre)
        contentValues.put("apellido",datos.apellido)
        contentValues.put("edad",datos.edad)
        contentValues.put("correoelectronico",datos.correoelectronico)
        contentValues.put("contraseña",datos.contrasena)
        contentValues.put("numtelefono",datos.numtelefono)
        contentValues.put("matricula",datos.matricula)

        var db=SQLManager(context)
        var manager=db.writableDatabase
        try {
            manager.insert("alumnos",null,contentValues)
        }
        catch (e: Exception){
            print(e.message)
            response= false
        }
        finally {
            db.close()
        }
        return response
    }
    fun addchofer(context: Context, datos: choferClass):Boolean{
        var response = true
        var contentValues=ContentValues()
        contentValues.put("nombre",datos.nombrechofer)
        contentValues.put("apellidochofer",datos.apellidochofer)
        contentValues.put("edadchofer",datos.edadchofer)
        contentValues.put("correoelectronicochofer",datos.correoelectronicochofer)
        contentValues.put("contraseña",datos.contrasenachofer)
        contentValues.put("numtelefonochofer",datos.numtelefonochofer)
        contentValues.put("folio",datos.folio)

        var db=SQLManager(context)
        var manager=db.writableDatabase
        try {
            manager.insert("chofer",null,contentValues)
        }
        catch (e: Exception){
            print(e.message)
            response= false
        }
        finally {
            db.close()
        }
        return response
    }
    fun addreportes(context: Context, datosreportes: reportesClass):Boolean{
        var response = true
        var contentValues=ContentValues()
        contentValues.put("transporte",datosreportes.transporte)
        contentValues.put("tiemporetraso",datosreportes.tiemporetraso)
        contentValues.put("motivo",datosreportes.motivo)
        contentValues.put("retraso",datosreportes.retraso)
        contentValues.put("cancelación",datosreportes.cancelación)

        var db=SQLManager(context)
        var manager=db.writableDatabase
        try {
            manager.insert("reportes",null,contentValues)
        }
        catch (e: Exception){
            print(e.message)
            response= false
        }
        finally {
            db.close()
        }
        return response
    }
}