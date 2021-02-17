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

public class fr2 extends Fragment {

    //se inicializan valores
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    Button btnlink2;

    private OnFragmentInteractionListener mListener;


    public static fr2 newInstance(String param1, String param2) {
        fr2 fragment = new fr2();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_fr2,container,false);
        Button btnlink2 = (Button) view2.findViewById(R.id.Urlbutton2);
        btnlink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                String url2 = "https://www.amazon.com.mx/Ladr%C3%B3n-Almas-Cr%C3%B3nicas-del-Horizonte-ebook/dp/B078KNLBP5/ref=sr_1_1?__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=ladron+de+almas&qid=1568001475&s=gateway&sr=8-1";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url2)));

            }
        });
        return view2;
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
