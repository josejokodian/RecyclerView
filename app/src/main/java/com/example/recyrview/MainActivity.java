package com.example.recyrview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_main;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] myRDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_main=findViewById(R.id.recyclerview_main);

        //to improve performance, we can assign fixed size to recyclerview
        //if the contents passing to the list will not change the recyclerview size.
        recyclerView_main.setHasFixedSize(true);

        //attaching layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView_main.setLayoutManager(layoutManager);

        //specifying an adapter.
        myRDataset = getResources().getStringArray(R.array.myData);

        mAdapter = new MyAdapter(myRDataset);
        recyclerView_main.setAdapter(mAdapter);



    }
}
