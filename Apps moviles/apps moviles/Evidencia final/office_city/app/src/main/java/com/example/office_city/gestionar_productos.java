package com.example.office_city;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;

public class gestionar_productos extends AppCompatActivity {
    databasehelper mydb;
    EditText id,nombre,cantidad;
    Button insertar,ver,modificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_productos);
        mydb=new databasehelper(this);
        id=(EditText)findViewById(R.id.codigo);
        nombre=(EditText)findViewById(R.id.nombre);
        cantidad=(EditText)findViewById(R.id.cantidad);
        insertar=(Button)findViewById(R.id.insertar);
        ver=(Button)findViewById(R.id.ver);
        modificar=(Button)findViewById(R.id.modificar);
        insert();
        viewAll();
        modificar();

    }

    public void insert(){
        insertar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isInserted= mydb.insertdata(id.getText().toString(),nombre.getText().toString(),cantidad.getText().toString());
                       if(isInserted==true){
                           Toast.makeText(gestionar_productos.this,"Registro insertado",Toast.LENGTH_SHORT).show();

                       }
                       else{
                           Toast.makeText(gestionar_productos.this,"No se insertó el registro",Toast.LENGTH_SHORT).show();
                       }
                    }
                }
        );

    }

    public void viewAll(){
        ver.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Cursor res=mydb.getAllData();
                       if (res.getCount()==0){
                           //show message;
                           showmessage("error","no se encontró data");
                           return;
                       }
                       StringBuffer buffer=new StringBuffer();
                       while (res.moveToNext()){
                           buffer.append("id: "+ res.getString(0)+"\n");
                           buffer.append("Nombre: "+ res.getString(1)+"\n");
                           buffer.append("Cantiad: "+ res.getString(2)+"\n\n");
                       }

                       //show all data
                        showmessage("Datos",buffer.toString());
                    }
                }
        );
    }

    public void modificar(){
        modificar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isupdate=mydb.actualizar(id.getText().toString(),nombre.getText().toString(),cantidad.getText().toString());
                        if (isupdate==true){
                            Toast.makeText(gestionar_productos.this,"Se ha actualizado correctamente",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(gestionar_productos.this,"No se actualizó el correo",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public  void showmessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
