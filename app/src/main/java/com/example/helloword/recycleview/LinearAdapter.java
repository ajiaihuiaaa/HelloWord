package com.example.helloword.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;

// adapter是抽象类，所以必须创建一个子类
//创建子类后,必须把所有的抽象方法都写一下
// XRecyclerView: 可实现addHeadView，addFootView,下拉刷新，上拉加载 可以去github上找找
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }


    @NonNull
    @Override
    //        渲染的是传入的mContext，每个item的类型是靠layout_linear_item来定义的
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        } else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2, parent, false));
        }
    }
// 这里修改的是onCreateViewHolder中传入的viewType的值
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    //        这里面可以修改各个控件的具体内容
    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, int position) {
        // 设置打印出来的文字
        if(getItemViewType(position) == 0){
            holder.textView.setText("Hello World");
        }else {
            // 这里进行了强制转换
            ((LinearViewHolder2)holder).textView.setText("Hi World");
        }

//        通过外部调用点击方法
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"pos" + position,Toast.LENGTH_SHORT).show();
                mListener.onClick(position);
            }
        });
//          在内部设置长按的方法
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "长按" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    //        这里面要把item中的各种控件和layout中的控件连接起来
    @Override
    public int getItemCount() {
        return 20;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.rv_title);
        }
    }

    class LinearViewHolder2 extends LinearViewHolder {
        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.rv_title);
            imageView = (ImageView) itemView.findViewById(R.id.iv_6);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

}
