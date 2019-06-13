package com.example.biblioapp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.biblioapp.Modelos.VistaAlquiler;
import com.example.biblioapp.R;

import java.util.List;

public class AdaptadorListaAlquileres extends BaseAdapter {

    private Context context;
    private List<VistaAlquiler> alquiler;
    public AdaptadorListaAlquileres(Context context, List<VistaAlquiler> alquiler) {
        this.context = context;
        this.alquiler = alquiler;
    }

    @Override
    public int getCount() {
        return alquiler.size();
    }

    @Override
    public Object getItem(int position) {
        return alquiler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.celdas_alquiler, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        VistaAlquiler vistaAlquiler = (VistaAlquiler) getItem(position);
        viewHolder.celdaUsuario.setText("USUARIO:"+" "+vistaAlquiler.getNombre()+" "+vistaAlquiler.getApellidos());
        viewHolder.celdaLibro.setText("LIBRO:"+" "+vistaAlquiler.getTitulo());

        return view;

    }
    public static class ViewHolder{

        TextView celdaUsuario,celdaLibro;

        public ViewHolder(View v){
            celdaUsuario=v.findViewById(R.id.dni);
            celdaLibro=v.findViewById(R.id.isbn);
        }

    }
}

