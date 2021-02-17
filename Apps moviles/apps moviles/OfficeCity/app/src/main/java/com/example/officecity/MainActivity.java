package com.example.officecity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //método para cambiar de activity
    public void RegistrarProducto(View view){
        Intent siguiente=new Intent(this,RegistrarProducto.class);
        startActivity(siguiente);
    }

    //método para cambiar de activity
    public void Ventas(View view){
        Intent siguiente=new Intent(this,Ventas.class);
        startActivity(siguiente);
    }
    public void Ventas_dia(View view){
        Intent siguiente=new Intent(this,VentasDia.class);
        startActivity(siguiente);
    }
}
