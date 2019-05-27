package com.example.biblioapp.Fragmentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biblioapp.AñadirAlquiler;
import com.example.biblioapp.AñadirLibro;
import com.example.biblioapp.MainActivity;
import com.example.biblioapp.R;


public class FragmentoListaAlquiler extends Fragment {

    public FragmentoListaAlquiler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_alquiler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {

            FloatingActionButton fab = mainActivity.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    AñadirAlquiler dialog = new AñadirAlquiler();
                    dialog.show(fragmentManager,"dialog_fragment");
                }
            });

    }
}
}
