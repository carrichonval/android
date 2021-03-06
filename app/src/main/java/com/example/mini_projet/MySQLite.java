package com.example.mini_projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static MySQLite sInstance;


    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        Log.d("VERIF","ON CREATE");
        db.execSQL(VilleDAO.CREATE_TABLE_VILLE); // création table "ville"
        db.execSQL(StationDAO.CREATE_TABLE_STATION); // création table "station"
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
        Log.d("VERIF","ON UPGRADE");
        onCreate(db);
    }

} // class MySQLite