package com.example.actividad6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;
    private String nombres[]={"lucero","Rocio","Gloria","Enrique","Andres","Fatima","vladimir"}; // arreglo para personas
    private String especialidad[]={"Pediatra","Urologo","Ginecologo","oncologo","Psicologo","Oculista","otorinolaringologo"}; // arreglo para especialidad
    //los datos que se mostraran en la tabla y en el spiner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.tv2);
        lv1=(ListView)findViewById(R.id.lv1);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv1.setText("EL usuario: "+ lv1.getItemAtPosition(i)+" Tiene consulta con el: "+ especialidad[i]);
            }
        });

    }

    //método para cambiar de activity
    public void siguiente(View view){
        Intent siguiente=new Intent(this,registro.class);
        startActivity(siguiente);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // codigo que hace la trancición de la activity
    }

}
