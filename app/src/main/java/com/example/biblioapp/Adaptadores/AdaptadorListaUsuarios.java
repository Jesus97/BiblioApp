package com.example.biblioapp.Adaptadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.biblioapp.Pojo.Usuario;
import com.example.biblioapp.R;

import java.util.List;

public class AdaptadorListaUsuarios extends BaseAdapter {

    private Context context;
    private List<Usuario> usuario;
    public AdaptadorListaUsuarios(Context context, List<Usuario> usuario) {
        this.context = context;
        this.usuario = usuario;
    }


    @Override
    public int getCount() {
        return usuario.size();
    }

    @Override
    public Object getItem(int position) {
        return usuario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.celdas_usuarios, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Usuario usuario = (Usuario) getItem(position);
        viewHolder.celdaNombre.setText(usuario.getNombre());
        viewHolder.celdaApellido.setText(usuario.getApellidos());

        return view;

    }
    public static class ViewHolder{

        TextView celdaNombre, celdaApellido;

        public ViewHolder(View v){
            celdaNombre=v.findViewById(R.id.nombre);
            celdaApellido=v.findViewById(R.id.apellidos);
        }

    }
}
