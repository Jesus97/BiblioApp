package com.example.biblioapp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.biblioapp.Modelos.Libro;
import com.example.biblioapp.R;

import java.util.List;

public class AdaptadorListaLibros extends BaseAdapter {

    private Context context;
    private List<Libro> libro;
    public AdaptadorListaLibros(Context context, List<Libro> libro) {
        this.context = context;
        this.libro = libro;
    }

    @Override
    public int getCount() {
        return libro.size();
    }

    @Override
    public Object getItem(int position) {
        return libro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.celdas_libros, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Libro libro = (Libro) getItem(position);
        viewHolder.celdaTitulo.setText("Titulo:"+" "+libro.getTitulo());
        viewHolder.celdaAutor.setText("Autor:"+" "+libro.getAutor());
        viewHolder.celdaEditorial.setText("Editorial:"+" "+libro.getEditorial());

        return view;

    }
    public static class ViewHolder{

        TextView celdaTitulo, celdaAutor, celdaEditorial;

        public ViewHolder(View v){
            celdaTitulo=v.findViewById(R.id.titulo);
            celdaAutor=v.findViewById(R.id.autor);
            celdaEditorial=v.findViewById(R.id.editorial);
        }

    }
}
