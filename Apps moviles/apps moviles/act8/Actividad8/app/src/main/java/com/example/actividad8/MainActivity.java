package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Se crean los objetos
    ListView lvcontactos;
    ArrayList<Contacto>contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvcontactos=(ListView)findViewById(R.id.listview);// se manda a llamar el objeto contactos
        contactos=new ArrayList<>(); //Creo un array list para introducir valores a un objeto contacto
        /*
        Se introducen los valores al array
        * */
        contactos.add(new Contacto("Miguel", "Ruvalcaba","3320948001"));
        contactos.add(new Contacto("Valeria", "Gutierrez","3316280626"));
        contactos.add(new Contacto("Miguel Angel", "Ruvalcaba","3320948001"));
        contactos.add(new Contacto("Gabriela", "Flores","3320948001"));
        contactos.add(new Contacto("Casa", "","3320948001"));

        ArrayList<String> nombreContactos=new ArrayList<>(); // se crea un arreglo para introducir datos a objeto contacto

        for (Contacto contacto: contactos){
            nombreContactos.add(contacto.getNombre()+contacto.getApellido());
        }
        lvcontactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContactos));

        lvcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(MainActivity.this,DetalleContacto.class); //Se hace el cambio de activity
                //Se envian los datos a la siguiente activity
                intent.putExtra("Nombre",contactos.get(i).getNombre());
                intent.putExtra("Apellido",contactos.get(i).getApellido());
                intent.putExtra("Telefono",contactos.get(i).getTelefono());
                startActivity(intent);
            }
        });
    }
}
