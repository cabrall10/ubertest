package com.jefferson.uberaplication.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.jefferson.uberaplication.config.ConfiguracaoFireBase;

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String latitude;
    private String longitude;

    public Usuario() {
    }

    public void salvar(){
        DatabaseReference firebaseRef = ConfiguracaoFireBase.getFirebaseDataBase();
        DatabaseReference usuarios = firebaseRef.child( "usuarios" ).child( getId() );

        usuarios.setValue( this );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
