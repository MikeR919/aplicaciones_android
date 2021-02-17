package com.example.actividad11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLDataException;

public class MainActivity extends AppCompatActivity {

    private EditText et_numero,et_nombre,et_direccion,et_telefono,et_correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_numero=(EditText)findViewById(R.id.numero);
        et_nombre=(EditText)findViewById(R.id.nombre);
        et_direccion=(EditText)findViewById(R.id.direccion);
        et_telefono=(EditText)findViewById(R.id.telefono);
        et_correo=(EditText)findViewById(R.id.correo);
    }

    public void registrar(View view){
        AdminSqLiteOpenHelper admin=new AdminSqLiteOpenHelper(this,"usuario",null, 1);
        SQLiteDatabase database=admin.getWritableDatabase();

        String numero=et_numero.getText().toString();
        String nombre=et_nombre.getText().toString();
        String direccion=et_direccion.getText().toString();
        String telefono=et_telefono.getText().toString();
        String correo=et_correo.getText().toString();

        if (!numero.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && ! telefono.isEmpty() && !correo.isEmpty()){
            ContentValues registro=new ContentValues();
            registro.put("numero",numero);
            registro.put("nombre",nombre);
            registro.put("direccion",direccion);
            registro.put("telefono",telefono);
            registro.put("correo",correo);

            database.insert("usuarios",null,registro);
            database.close();
            et_numero.setText("");
            et_nombre.setText("");
            et_direccion.setText("");
            et_telefono.setText("");
            et_correo.setText("");


        }else{
            Toast.makeText(this,"Completa los campos", Toast.LENGTH_LONG).show();
        }

    }

    //Metodo consulta por numero de usuario
    public void buscarNumero (View view){
        AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this,"usuario",null, 1);
        SQLiteDatabase database=admin.getWritableDatabase();

        String numero=et_numero.getText().toString();

        if(!numero.isEmpty()){
            Cursor fila = database.rawQuery("select * from usuarios where numero = " + numero,null);
            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString(0));
                et_direccion.setText(fila.getString(1));
                et_telefono.setText(fila.getString(2));
                et_correo.setText(fila.getString(3));
                database.close();
            }else{
                Toast.makeText(this, "No existe este numero de usuario", Toast.LENGTH_SHORT).show();
                database.close();
            }

        } else {
            Toast.makeText(this,"Introduce el numero de usuario",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo consulta por nombre de usuario
    public void buscarNombre (View view){
        AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this,"usuario",null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String nombre=et_nombre.getText().toString();

        if(!nombre.isEmpty()){
            Cursor fila = database.rawQuery("select * from usuarios where nombre = " + nombre,null);
            if(fila.moveToFirst()){
                et_numero.setText(fila.getString(0));
                et_direccion.setText(fila.getString(1));
                et_telefono.setText(fila.getString(2));
                et_correo.setText(fila.getString(3));
                database.close();
            }else{
                Toast.makeText(this, "No existe este nombre de usuario", Toast.LENGTH_SHORT).show();
                database.close();
            }

        } else {
            Toast.makeText(this,"Introduce el nombre de usuario",Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View view){
        AdminSqLiteOpenHelper admin=new AdminSqLiteOpenHelper(this,"usuario",null, 1);
        SQLiteDatabase database= admin.getWritableDatabase();
        String numero=et_numero.getText().toString();
        if (!numero.isEmpty()){
            int id= database.delete("usuario","numero="+ numero,null);
            database.close();
            et_numero.setText("");
            et_nombre.setText("");
            et_direccion.setText("");
            et_telefono.setText("");
            et_correo.setText("");

            if (id==1){
                Toast.makeText(this,"Articulo eliminado", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"no existe el articulo", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"introduce el numero", Toast.LENGTH_LONG).show();
        }
    }
}
