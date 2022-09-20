package com.example.helloword.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloword.R;
// 列表   上下好多个列表
public class LinearRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置初始界面
        setContentView(R.layout.activity_linear_recycle_view);
//        绘制recycleView
        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
//        设置manager,传入的是当前的activity
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));
        // 设置分隔线
        mRvMain.addItemDecoration(new MyDecoration());
//        设置adapter    添加点击事件
//        传入的是当前的activity
        mRvMain.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecycleViewActivity.this,"pos" + pos,Toast.LENGTH_SHORT).show();
            }
        }));


    }
    //分隔线的类  ItemDecoration类是抽象类，所以必须新建一个子类来继承它
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}