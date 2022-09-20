package com.example.helloword.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloword.R;
// 列表   每一行都有好几个列表  在这里设置的是3个
public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.rv_grid);
        recyclerView.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        recyclerView.setAdapter(new GridAdapter(GridRecyclerViewActivity.this));
    }
}