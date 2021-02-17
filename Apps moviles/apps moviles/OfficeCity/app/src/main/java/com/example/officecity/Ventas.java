package com.example.officecity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Ventas extends AppCompatActivity {


    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        spinner1=(Spinner)findViewById(R.id.spinner1);

        // se usa un arreglo para mostrar datos en el spinner y un array adapter para introducir los datos al spinner
        String[]spinner={"Lapiz","pluma","Cartulina","hoja de papel"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinner);

        //se muestra la información en el spinner
        spinner1.setAdapter(adapter);
    }
}
