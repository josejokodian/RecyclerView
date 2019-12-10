package com.example.recyrview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataset;
    Context context;
    //creating constructor with dataset.
    public MyAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    //layout manager calls the oncreateviewholder() method in adapter class.
    //this method construct a recyclerview.viewholder and uses it to display content.
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //created a single layout with textview
        context= parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        TextView textView = view.findViewById(R.id.textView);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //to bind the data to the viewholder, we call onBindViewHolder.
    //this viewHolders position to the recyclerview.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
    //getting the element from the dataset
        holder.textview.setText(mDataset[position]);
        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mDataset[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    //viewholder class provide reference to view for each data item.
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textview;
        public MyViewHolder(@NonNull View tView) {
            super(tView);
            textview=tView.findViewById(R.id.textView);
        }
    }
}
