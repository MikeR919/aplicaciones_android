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

//variables iniciales.
    private TextView tv1;
    private ListView lv1;
    private String nombres[]={"lucero","Rocio","Gloria","Enrique","Andres","Fatima","vladimir"};
    private String especialidad[]={"Pediatra","Urologo","Ginecologo","oncologo","Psicologo","Oculista","otorinolaringologo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //se crean objetos para trabajar.

        tv1=(TextView)findViewById(R.id.tv2);
        lv1=(ListView)findViewById(R.id.lv1);

// se usa un array adapter para introducir los datos en eu una lista.
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
    }

}
