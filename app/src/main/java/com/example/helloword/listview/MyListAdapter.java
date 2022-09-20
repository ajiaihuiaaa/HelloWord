package com.example.helloword.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.helloword.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyListAdapter(Context context){
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }

    // 每个格子长什么样子 在这里设置
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv_5);
            holder.tvTitle = (TextView) view.findViewById(R.id.tv_title3);
            holder.tvTime = (TextView) view.findViewById(R.id.tv_time);
            holder.tvContent = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
//        给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2022-06-22");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://csdnimg.cn/pubfooter/images/job-QR.png").into(holder.imageView);
        return view;
    }
}
