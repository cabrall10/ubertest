package com.jefferson.uberaplication.model;

import com.google.firebase.database.DatabaseReference;
import com.jefferson.uberaplication.config.ConfiguracaoFireBase;

public class Requisicao {

    private String id;
    private String status;
    private Usuario passageiro;
    private Usuario motorista;
    private Destino destino;



    public Requisicao() {
    }

    public void salvar(){
        DatabaseReference firebaseRef = ConfiguracaoFireBase.getFirebaseDataBase();
        DatabaseReference requisicoes = firebaseRef.child("requisicoes");

        String idRequisicao = requisicoes.push().getKey();
        setId(idRequisicao);

        requisicoes.child( getId()).setValue(this);
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }


    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPassageiro(Usuario passageiro) {
        this.passageiro = passageiro;
    }

    public void setMotorista(Usuario motorista) {
        this.motorista = motorista;
    }

    public Usuario getPassageiro() {
        return passageiro;
    }

    public Usuario getMotorista() {
        return motorista;
    }

    public static String getStatusAguardadndo() {
        return STATUS_AGUARDADNDO;
    }

    public static String getStatusACaminho() {
        return STATUS_A_CAMINHO;
    }

    public static String getStatusViagem() {
        return STATUS_VIAGEM;
    }

    public static String getStatusFinalizada() {
        return STATUS_FINALIZADA;
    }


    public static final String STATUS_AGUARDADNDO = "aguardando";
    public static final String STATUS_A_CAMINHO = "acaminho";
    public static final String STATUS_VIAGEM = "viagem";
    public static final String STATUS_FINALIZADA = "finalizada";
}
