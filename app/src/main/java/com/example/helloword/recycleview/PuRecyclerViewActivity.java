package com.example.helloword.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.helloword.R;


// 瀑布流   每个item可以不对齐
public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.rv_pu);
        // VERTICAL：代表有2列
        // horizontal：代表有2行
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new MyDecoration());
        recyclerView.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight);
            outRect.set(gap,gap,gap,gap);
        }
    }
}