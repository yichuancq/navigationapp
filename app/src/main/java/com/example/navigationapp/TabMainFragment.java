package com.example.navigationapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class TabMainFragment extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp, "首页", SubOneActivity.newInstance("首页"));
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.ic_notifications_black_24dp, R.drawable.ic_notifications_black_24dp, "分类", TabBFragment.newInstance("分类"));
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp, "资讯", TabCFragment.newInstance("资讯"));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);

        TabView tabView = (TabView) findViewById(R.id.tabView);
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
                Toast.makeText(getApplicationContext(), "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

