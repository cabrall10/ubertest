package com.jefferson.uberaplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jefferson.uberaplication.R;
import com.jefferson.uberaplication.model.Requisicao;
import com.jefferson.uberaplication.model.Usuario;

import org.w3c.dom.Text;

import java.util.List;

public class RequisicoesAdapter extends RecyclerView.Adapter<RequisicoesAdapter.MyViewHolder> {

    private List<Requisicao> requisicaos;
    private Context context;
    private Usuario motorista;

    public RequisicoesAdapter(List<Requisicao> requisicaos, Context context, Usuario motorista) {
        this.requisicaos = requisicaos;
        this.context = context;
        this.motorista = motorista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_requisicoes, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Requisicao requisicao = requisicaos.get(position);
        Usuario passageiro = requisicao.getPassageiro();
        holder.nome.setText(passageiro.getNome());
        holder.distancia.setText("1km - aproximadamente");
    }

    @Override
    public int getItemCount() {
        return requisicaos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome, distancia;

        public MyViewHolder(View itemView){
            super(itemView);

            nome = itemView.findViewById(R.id.textRequisicaoNome);
            distancia = itemView.findViewById(R.id.textRequisicaoDistancia);
        }
    }

}
