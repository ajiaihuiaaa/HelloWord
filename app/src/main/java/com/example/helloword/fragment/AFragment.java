package com.example.helloword.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.helloword.R;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChange, mBtnSetText,mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick iOnMessageClick;

    // 参数的传递
    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    // 这里是通过接口的方法 传入数据，这个方法比较推荐
    public interface IOnMessageClick{
        void onClick(String str);
    }

    //类似于activity中的setContentView。返回的是view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    // 当view创建完成之后，会调这个方法
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // todo
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);  // 其实activity中的findviewbyid也是
        // view的方法，不过这个view在oncreate中已经导入了

        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }
        // aFragment 里面可以添加按钮，直接切换成bFragment
        // 这里的逻辑是把aFragment替换成bFragment，所以他们当前的activity还是一样的
        mBtnChange = (Button) view.findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
//                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).
//                            commitAllowingStateLoss(); // 这里的逻辑是把aFragment替换成bFragment，所以他们当前的activity还是一样的
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).
                            addToBackStack(null).commitAllowingStateLoss(); // 这里的逻辑是隐藏了aFragment，这样就不会调用oncreate
                    // 然后关闭bFragment后，就会显示aFragment
                } else {
                    Log.d("null","null");
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).
                            addToBackStack(null).commitAllowingStateLoss(); // 这里的逻辑是放入了栈中，所以后退时就是回到aFragment
                }

            }
        });

        mBtnSetText = (Button) view.findViewById(R.id.btn_reset);
        mBtnSetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("换一个text");

            }
        });


        // 使用getActivity时，需要判断是否为null
        if (getActivity() != null) {
            // TODO: 2022/8/4
        } else {

        }

        mBtnMessage = (Button) view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fragment 传递数据给activity
                // 它这里直接调用了上面ativity里面的方法了(不推荐)
//                ((ContainerActivity)getActivity()).setText("你好");
                iOnMessageClick.onClick("换一个text");
            }
        });
    }

    //fragment is attaching activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            iOnMessageClick = (IOnMessageClick) context;
        }catch(ClassCastException e){
            throw new ClassCastException("Activity 必须实现IOnMessageClick 接口");
        }
    }

    //fragment is detaching activity
    @Override
    public void onDetach() {
        super.onDetach();
    }

    //fragment is destoried
    @Override
    public void onDestroy() {
        super.onDestroy();


    }
}
