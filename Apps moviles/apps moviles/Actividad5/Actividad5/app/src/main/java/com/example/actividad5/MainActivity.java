
/*
* Miguel Alejandro Ruvalcaba Flores
* Irving jair muñiz saavedra
* Julio cesar zamora garcia
*
* esta applicación hace la cotización para calcular el precio total de todos los accesorios que puedes incluir a tu vehiculo
* */
package com.example.actividad5;
//se mandan a llamar las librerias

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
// se declara un array para que se puedan sumar los valores al final
    ArrayList<Integer> selection = new ArrayList<>();
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = (TextView)findViewById(R.id.total); //se instancia un objeto
        total.setEnabled(false);

    }

    //método para ver que casillas están activas y cuales no.

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.spoiler:
                if(checked) {
                    selection.add(5000);
                }else{
                    selection.add(-5000);
                }
                break;
            case R.id.mascara:
                if(checked) {
                    selection.add(4000);
                }else{
                    selection.add(-4000);
                }
                break;
            case R.id.controles:
                if(checked) {
                    selection.add(10000);
                }else{
                    selection.add(-10000);
                }
                break;

            case R.id.rin:
                if(checked) {
                    selection.add(15000);
                }else{
                    selection.add(-15000);
                }
                break;
        }
    }

    //método para calcular el precio total del vehiculo.
    public void finalSelection(View view) {
        int Costo_total = 200000 ;
        for (int Selections: selection){
            Costo_total = Costo_total + Selections;
        }
        total.setText("$ " + Costo_total);
        total.setEnabled(true);
    }
}
