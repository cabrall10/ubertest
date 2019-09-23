package com.jefferson.uberaplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.jefferson.uberaplication.R;
import com.jefferson.uberaplication.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText campoNome, campoEmail, campoSenha;
    private Switch switchTipoUsuario;

    private FirebaseAuth autentificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editCadastroNome);
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        switchTipoUsuario = findViewById(R.id.switchTipoUsuario);

    }

    public void validarCadastroUsuario(){
        String textoNome = campoNome.getText().toString();
        String textoEmail = campoEmail.getText().toString();
        String textoSenha = campoSenha.getText().toString();

        if( !textoNome.isEmpty()){
            if( !textoEmail.isEmpty()){
                if( !textoSenha.isEmpty()){

                    Usuario usuario = new Usuario();
                    usuario.setNome( textoNome );
                    usuario.setEmail( textoEmail );
                    usuario.setSenha( textoSenha );
                    usuario.setTipo( verificaTipoUsuario() );

                    cadastrarUsuario( usuario );

            }else{
                Toast.makeText(CadastroActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
            }

            }else{
                Toast.makeText(CadastroActivity.this, "Preencha o e-mail!", Toast.LENGTH_SHORT).show();
            }

            }else{
                Toast.makeText(CadastroActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
            }
    }

    public void cadastrarUsuario( Usuario usuario ){

    }

    public String verificaTipoUsuario(){
        return switchTipoUsuario.isChecked() ? "M" : "P" ;
    }

}
