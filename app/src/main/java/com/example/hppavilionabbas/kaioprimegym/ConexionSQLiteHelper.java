package com.example.hppavilionabbas.kaioprimegym;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hppavilionabbas.kaioprimegym.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper
{



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            db.execSQL("DROP TABLE IF EXISTS 'usuario' ");
            onCreate(db);
    }
}
