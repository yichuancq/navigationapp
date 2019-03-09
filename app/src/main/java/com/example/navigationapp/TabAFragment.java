package com.example.navigationapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


public class TabAFragment extends Fragment {
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
        tab.addTab(tab.newTabSpec("tab4").setIndicator("我的购物车", null).setContent(R.id.tab4));
        tab.addTab(tab.newTabSpec("tab6").setIndicator("我的积分", null).setContent(R.id.tab5));
        return view;
    }
}
