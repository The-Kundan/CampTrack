package com.example.camptrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrFacDetails;
    recyclerAdapter(Context context , ArrayList<ContactModel> arrFacDetails){
        this.context=context;
        this.arrFacDetails = arrFacDetails;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel model = (ContactModel) arrFacDetails.get(position);
        holder.imgFaculty.setImageResource(model.img);
        holder.txtName.setText(model.name);
        holder.txtDetails.setText(model.details);
    }

    @Override
    public int getItemCount() {
        return arrFacDetails.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDetails;
        ImageView imgFaculty;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtDetails = itemView.findViewById(R.id.txtDetails);
            imgFaculty = itemView.findViewById(R.id.imgFaculty);
        }
    }
}
