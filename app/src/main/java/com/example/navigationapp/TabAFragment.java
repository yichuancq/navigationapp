package com.example.navigationapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.navigationapp.adapter.MyAdapter;
import com.example.navigationapp.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TabAFragment extends Fragment implements TabHost.OnTabChangeListener {
    private ListView listView;
    //自定义BaseAdapter
    private MyAdapter adapter;


    public static TabAFragment newInstance(String text) {
        TabAFragment fragmentCommon = new TabAFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //不同的Activity对应不同的布局
//        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        //不同的Activity对应不同的布局
        View view = inflater.inflate(R.layout.table_host_layout, container, false);

        TabHost tab = (TabHost) view.findViewById(android.R.id.tabhost);
        //初始化TabHost容器
        tab.setup();
        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        tab.addTab(tab.newTabSpec("tab1").setIndicator("本地音乐", null).setContent(R.id.tab1));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("网络音乐", null).setContent(R.id.tab2));
        tab.addTab(tab.newTabSpec("tab3").setIndicator("我的收藏", null).setContent(R.id.tab3));
        tab.addTab(tab.newTabSpec("tab4").setIndicator("我的购物", null).setContent(R.id.tab4));
        tab.addTab(tab.newTabSpec("tab5").setIndicator("我的积分", null).setContent(R.id.tab5));
        tab.setOnTabChangedListener(this);
        // 设置adapter
        this.setAdapter(view);
        return view;
    }

    private void setAdapter(View view) {
        listView = (ListView) view.findViewById(R.id.listview);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list = new ArrayList<>();

        List<Student> stuList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student stu = new Student();
            stu.setAge(10 + i);
            stu.setName("name" + i);
            stu.setPhoto(R.mipmap.ic_launcher);
            stuList.add(stu);
        }
        adapter = new MyAdapter(stuList, this.getActivity());
        listView.setAdapter(adapter);
    }

    /**
     * @param tabId
     */
    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals("tab1")) {   //第1个标签
            Toast.makeText(this.getActivity(), "点击标签页1", Toast.LENGTH_SHORT).show();
        }
        if (tabId.equals("tab2")) {   //第2个标签
            Toast.makeText(this.getActivity(), "点击标签页2", Toast.LENGTH_SHORT).show();
        }
        if (tabId.equals("tab3")) {   //第3个标签
            Toast.makeText(this.getActivity(), "点击标签页3", Toast.LENGTH_SHORT).show();
        }
        if (tabId.equals("tab4")) {   //第4个标签
            Toast.makeText(this.getActivity(), "点击标签页4", Toast.LENGTH_SHORT).show();
        }
        if (tabId.equals("tab5")) {   //第5个标签
            Toast.makeText(this.getActivity(), "点击标签页5", Toast.LENGTH_SHORT).show();
        }
    }
}
