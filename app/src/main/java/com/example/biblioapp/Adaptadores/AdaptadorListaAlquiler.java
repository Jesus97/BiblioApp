package com.example.biblioapp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.biblioapp.Pojo.Alquiler;
import com.example.biblioapp.R;

import java.util.List;

public class AdaptadorListaAlquiler extends BaseAdapter {

    private Context context;
    private List<Alquiler> alquiler;
    public AdaptadorListaAlquiler(Context context, List<Alquiler> alquiler) {
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
        Alquiler alquiler = (Alquiler) getItem(position);
        viewHolder.celdaDni.setText(alquiler.getDni());
        viewHolder.celdaIsbn.setText(alquiler.getIsbn());

        return view;

    }
    public static class ViewHolder{

        TextView celdaDni,celdaIsbn;

        public ViewHolder(View v){
            celdaDni=v.findViewById(R.id.dni);
            celdaIsbn=v.findViewById(R.id.isbn);
        }

    }
}
