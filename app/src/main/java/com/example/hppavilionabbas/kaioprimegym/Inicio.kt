package com.example.hppavilionabbas.kaioprimegym

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var Conexion : Any = ConexionSQLiteHelper(this, "bdkaio", null , 1);
    }
}
