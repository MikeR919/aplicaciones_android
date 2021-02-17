package com.example.actividad4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class fr1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Button btnlink;


    private OnFragmentInteractionListener mListener;


    public static fr1 newInstance(String param1, String param2) {
        fr1 fragment = new fr1();
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

        View view = inflater.inflate(R.layout.fragment_fr1,container,false);
        Button btnlink = (Button) view.findViewById(R.id.Urlbutton);
        btnlink.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.amazon.com.mx/Harry-Potter-D%C3%B6dsrelikerna-Potter-serien-Swedish-ebook/dp/B0192CTOX0/ref=sr_1_2?adgrpid=63295254128&gclid=CjwKCAjwzdLrBRBiEiwAEHrAYqWuqAJeQbbi5KvEVVLyEpIgKcOm3C2eOeWbvnWmkg6FO35B9AYZixoCndsQAvD_BwE&hvadid=303038422516&hvdev=c&hvlocphy=20708&hvnetw=g&hvpos=1t1&hvqmt=b&hvrand=6785983874997065806&hvtargid=kwd-390877839257&hydadcr=26974_10223713&keywords=libros+ebok&qid=1567961348&s=gateway&sr=8-2";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

            }
        });
        return view;

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
