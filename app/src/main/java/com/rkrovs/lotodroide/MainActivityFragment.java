package com.rkrovs.lotodroide;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView prim = (ImageView)view.findViewById(R.id.primi);
        ImageView euro = (ImageView)view.findViewById(R.id.euro);
        ImageView bono = (ImageView)view.findViewById(R.id.bono);
        ImageView gordo = (ImageView)view.findViewById(R.id.gordo);

        Glide.with(getActivity()).load(R.drawable.primi).into(prim);
        Glide.with(getActivity()).load(R.drawable.euromill).into(euro);
        Glide.with(getActivity()).load(R.drawable.bono).into(bono);
        Glide.with(getActivity()).load(R.drawable.gordo).into(gordo);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumbers();
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        generateNumbers();
    }

    public void generateNumbers()
    {
        TextView tprim = (TextView)getActivity().findViewById(R.id.tprimi);
        TextView teuro = (TextView)getActivity().findViewById(R.id.teuro);
        TextView teuro2 = (TextView)getActivity().findViewById(R.id.teuro2);
        TextView tbono = (TextView)getActivity().findViewById(R.id.tbono);
        TextView tgordo = (TextView)getActivity().findViewById(R.id.tgordo);


        tprim.setText(fillSorteo(1, 49, 6));
        teuro.setText(fillSorteo(1, 50, 5));
        teuro2.setText(fillSorteo(1, 11, 2));
        tbono.setText(fillSorteo(1, 49, 6));
        tgordo.setText(fillSorteo(1, 54, 5));
    }


    public String fillSorteo(int a, int b, int max)
    {
        Random r = new Random();

        Vector<Integer> v = new Vector<>(max);

        for(int i=0;i<max;i++){
            int t = r.nextInt(b - a + 1) + 1;
            while (v.contains(t)){
                t = r.nextInt(b - a + 1) + 1;
            }
            v.add(t);
        }
        Collections.sort(v);

        String numbs = v.toString();


        return numbs.replace('[',' ').replace(']',' ').replace(',',' ');
    }
}
