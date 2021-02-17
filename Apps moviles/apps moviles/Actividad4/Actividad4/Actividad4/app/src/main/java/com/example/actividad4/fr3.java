package com.example.actividad4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fr3 extends Fragment {
    private static final String ARG_PARAM1 = "param1"; // se colocan parametos
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fr3() {
    }

    public static fr3 newInstance(String param1, String param2) {
        fr3 fragment = new fr3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override //metodo para decirle al botón que debe de hacer
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view3 = inflater.inflate(R.layout.fragment_fr3,container,false);
        Button btnlink3 = (Button) view3.findViewById(R.id.Urlbutton3);
        btnlink3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                String url3 = "https://www.amazon.com.mx/Laurie-Flash-Relatos-Stephen-King-ebook/dp/B07GVT1JN9/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=Laurie&qid=1568001540&s=gateway&sr=8-1";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url3)));

            }
        });
        return view3;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
