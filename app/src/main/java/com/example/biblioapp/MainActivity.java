package com.example.biblioapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.biblioapp.Fragmentos.FragmentoListaAlquiler;
import com.example.biblioapp.Fragmentos.FragmentoListaLibros;
import com.example.biblioapp.Fragmentos.FragmentoListaUsuarios;
import com.example.biblioapp.Servidor.BibliotecaService;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity{

    String resultado;
    DrawerLayout drawerLayout;
    NavigationView navView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_contenido,new FragmentoListaAlquiler()).commit();

        drawerLayout=findViewById(R.id.drawer_layout);
        navView=findViewById(R.id.navview);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_lateral_1:
                                fragment = new FragmentoListaAlquiler();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_lateral_2:
                                fragment = new FragmentoListaUsuarios();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_lateral_3:
                                fragment = new FragmentoListaLibros();
                                fragmentTransaction = true;
                                break;
                        }

                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.layout_contenido, fragment).commit();

                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ESCANER","Contenido del scan");

        IntentResult escanerDNI = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        resultado = escanerDNI.getContents().toString();
        Log.e("ESCANERDNI",""+escanerDNI.getContents());
        Log.e("ESCANERDNI",""+escanerDNI.toString());

        super.onActivityResult(requestCode, resultCode, data);
    }

}
