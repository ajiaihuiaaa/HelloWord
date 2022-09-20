package com.example.helloword.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.helloword.R;

public class BFragment extends Fragment {
    private TextView mTvTitle;

    //类似于activity中的setContentView。返回的是view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        return view;
    }

    // 当view创建完成之后，会调这个方法
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // todo
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);  // 其实activity中的findviewbyid也是
        // view的方法，不过这个view在oncreate中已经导入了

    }
}
