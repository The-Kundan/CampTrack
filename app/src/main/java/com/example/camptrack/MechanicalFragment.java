package com.example.camptrack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MechanicalFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerMechanicalData;
    private ArrayList<ContactModel> arrFacDetails = new ArrayList<>();
    private recyclerAdapter adapter;

    public MechanicalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mechanical, container, false);
    }
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();
        recyclerMechanicalData = view.findViewById(R.id.recyclerMechanicalData);
        recyclerMechanicalData.setLayoutManager(new LinearLayoutManager(getContext()));

        mechanicalData();
        adapter = new recyclerAdapter(context, arrFacDetails);
        recyclerMechanicalData.setAdapter(adapter);
    }
    private void mechanicalData(){
        arrFacDetails.add(new ContactModel(R.drawable.c,"Neeraj Sharma","Block-1, Ground Floor, Room No. 11"));
        arrFacDetails.add(new ContactModel(R.drawable.c,"Dr. Avinash Sharma","Block-1, 2nd Floor, Room No. 208 "));
        arrFacDetails.add(new ContactModel(R.drawable.c,"Mohan Prasad","Block-1, Ground Floor, Room No. 06"));
        arrFacDetails.add(new ContactModel(R.drawable.g,"Rini Saxena","Block-1, 3rd Floor, Room No. 311"));

    }
}