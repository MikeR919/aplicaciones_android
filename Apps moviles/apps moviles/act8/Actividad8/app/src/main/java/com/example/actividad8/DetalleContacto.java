package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre, tvApellido, tvTelefono;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        /*
        * Recibe los parametros de la actividad pasada*/
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("Nombre");
        String appelido = bundle.getString("Apellido");
        final String cel = bundle.getString("Telefono");

        /*Se asignan los parametros a la activity para mostrarse en pantalla
        * */
        tvNombre = (TextView) findViewById(R.id.nombre);
        tvApellido = (TextView) findViewById(R.id.Apellido);
        tvTelefono = (TextView) findViewById(R.id.celular);
        button = findViewById(R.id.llamar);

        tvNombre.setText(nombre);
        tvApellido.setText(appelido);
        tvTelefono.setText(cel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + cel.toString())); //Se realiza la llamada
                //Se verifica el permiso del dispositivo para realizar la llamada
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    Toast.makeText(DetalleContacto.this,"Falta permiso de llamada",Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });


    }
}
