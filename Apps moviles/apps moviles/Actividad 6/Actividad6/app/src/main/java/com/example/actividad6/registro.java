package com.example.actividad6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        spinner1=(Spinner)findViewById(R.id.spinner);

        // se usa un arreglo para mostrar datos en el spinner y un array adapter para introducir los datos al spinner
        String[]spinner={"Pediatra","Urologo","Ginecologo","oncologo","Psicologo","Oculista","otorinolaringologo"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinner);

        //se muestra la información en el spinner
        spinner1.setAdapter(adapter);
    }

    //se coloca un botón que realice un toast para indicarle al usuario que se guardó su información
    public void registro(View view){
        Toast.makeText(this, "Se ha generado un nuevo registro", Toast.LENGTH_SHORT).show();
    }


}
