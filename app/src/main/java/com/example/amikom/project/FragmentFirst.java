package com.example.amikom.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFirst extends Fragment {
    //deklarasi tombol berfragment
    private Button buttonSatu;




    //  titlebar/actionbar
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_fragment_first, container, false);
        ((WithFragment) getActivity()).getSupportActionBar().setTitle("Fragment");
        ((WithFragment) getActivity()).getSupportActionBar().setSubtitle("First Fragment");
        ((WithFragment) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        buttonSatu = (Button) view.findViewById(R.id.button1);



        return view;


    }

    //end of  titlebar/actionbar


    //proses fragment
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        buttonSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            //Second Fragment
            public void onClick(View view) {
                FragmentSecond fragmentSecond = new FragmentSecond();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, fragmentSecond)
                        //ganti fragment
                        .addToBackStack(null)
                        //simpan fragment
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        //transisi fragment
                        .commit();

            }
        });

    }


}