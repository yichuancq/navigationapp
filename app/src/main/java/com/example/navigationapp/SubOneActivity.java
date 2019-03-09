package com.example.navigationapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class SubOneActivity extends Fragment implements ViewPager.OnPageChangeListener {
    public static MainActivity mainActivity;

    private ViewPager pager;
    private MyPagerAdapter pagerAdapter;
    private PagerSlidingTabStrip pagerSlidingTabStrip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //不同的Activity对应不同的布局
        View view = inflater.inflate(R.layout.activity_sub_one_layout, container, false);
        pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        ArrayList<Fragment> fragmentlist = new ArrayList<Fragment>();
        //pagerSlidingTabStrip.setClickable(true);
        // 设置Tab底部选中的指示器 Indicator的颜色
        pagerSlidingTabStrip.setIndicatorColor(Color.RED);
        //设置Tab标题文字的颜色
        pagerSlidingTabStrip.setTextColor(Color.WHITE);
        // 设置Tab标题文字的大小
        pagerSlidingTabStrip.setTextSize(25);
        //设置Tab底部分割线的颜色
        pagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置点击某个Tab时的背景色,设置为0时取消背景色
        pagerSlidingTabStrip.setTabBackground(0);
        // 设置Tab是自动填充满屏幕的
        pagerSlidingTabStrip.setShouldExpand(true);
        //tab间的分割线
        pagerSlidingTabStrip.setDividerColor(Color.WHITE);
        //注意，这三个Fragment需要自己实现
        TabAFragment tabFragment1 = new TabAFragment();
        TabBFragment tabFragment2 = new TabBFragment();
        TabCFragment tabFragment3 = new TabCFragment();
        fragmentlist.add(tabFragment1);
        fragmentlist.add(tabFragment2);
        fragmentlist.add(tabFragment3);
        pagerAdapter = new MyPagerAdapter(mainActivity.getSupportFragmentManager(), fragmentlist);
        pager.setAdapter(pagerAdapter);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        pagerSlidingTabStrip.setViewPager(pager);
        pagerSlidingTabStrip.setOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        //System.out.println("onPageScrolled");
    }

    @Override
    public void onPageSelected(int i) {
//        System.out.println("onPageSelected");
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        // System.out.println("onPageScrollStateChanged");
    }

    //MyPagerAdapter要和上面实现的三个Fragment对应起来
    class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"标签1", "标签2", "标签3"};
        private ArrayList<Fragment> fragmentlist;

        public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            fragmentlist = list;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return fragmentlist.size();
        }

        public Fragment getItem(int position) {
            return fragmentlist.get(position);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // todo  布局
    }
}
