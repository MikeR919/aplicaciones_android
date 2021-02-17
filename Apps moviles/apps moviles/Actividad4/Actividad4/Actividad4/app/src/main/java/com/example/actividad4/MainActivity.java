package com.example.actividad4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,fr1.OnFragmentInteractionListener, fr2.OnFragmentInteractionListener, fr3.OnFragmentInteractionListener {
    Button btnfr1,btnfr2,btnfr3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fr1 fragmento1=new fr1();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmento1);
        btnfr1=(Button)findViewById(R.id.btnFrag1);
        btnfr2=(Button)findViewById(R.id.btnFrag2);
        btnfr3=(Button)findViewById(R.id.btnFrag3);

        btnfr3.setOnClickListener(this);
        btnfr2.setOnClickListener(this);
        btnfr1.setOnClickListener(this);

    }

    /*se crea un switch case para que tome un caso para cada botón.*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFrag1:
                fr1 fragmento1=new fr1();
                FragmentTransaction transition =getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.contenedor,fragmento1);
                transition.commit();
                break;
            case R.id.btnFrag2:
                fr2 fragmento2=new fr2();
                FragmentTransaction transition2 =getSupportFragmentManager().beginTransaction();
                transition2.replace(R.id.contenedor,fragmento2);
                transition2.commit();
                break;
            case R.id.btnFrag3:
                fr3 fragmento3=new fr3();
                FragmentTransaction transition3 =getSupportFragmentManager().beginTransaction();
                transition3.replace(R.id.contenedor,fragmento3);
                transition3.commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
