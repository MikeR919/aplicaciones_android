/*Miguel Alejandro Ruvalcaba Flores
* 2730919
* Actividad 3
* utilizar gestos para cambiar color del background
* */

package com.example.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
    implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    private GestureDetector mDetector;
    private LinearLayout mlinear;
    private TextView mtexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlinear =(LinearLayout) findViewById(R.id.fondopantalla);
        mtexto=(TextView)findViewById(R.id.texto);
        this.mDetector= new GestureDetector(this,this);
        mDetector.setOnDoubleTapListener(this);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.colorPrimary));
        mtexto.setText("single tap");
        //metodo para cuando tocas una vez la pantalla
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.dos));
        mtexto.setText("double tap");
        //metodo para cuando tocas dos veces la pantalla
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.cinco));
        mtexto.setText("ShowPress");
        //metodo para cuando tocas brevemente la pantalla

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.siete));
        mtexto.setText("scroll");
        //metodo para cuando bajas o subes la pantalla
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.ocho));
        mtexto.setText("longpress");
        //metodo para cuando dejas presionada la pantalla
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        mlinear.setBackgroundColor(ContextCompat.getColor( this,R.color.colorAccent));
        mtexto.setText("onling");
        //metodo para cuando desplazas brevemente  la pantalla
        return false;
    }
}
