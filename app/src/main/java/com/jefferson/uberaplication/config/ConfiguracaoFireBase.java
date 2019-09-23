package com.jefferson.uberaplication.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFireBase {

    private static DatabaseReference database;
    private static FirebaseAuth auth;

    //retorna instancia do FirebaseDataBase
    public static DatabaseReference getFirebaseDataBase(){

        if( database == null ){
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }

    //retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticacao(){

        if( auth == null ){
            auth = FirebaseAuth.getInstance();
        }

        return auth;
    }

}
