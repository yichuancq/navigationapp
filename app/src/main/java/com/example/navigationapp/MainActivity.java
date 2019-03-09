package com.example.navigationapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment[] fragments;
    private int lastFragment;//用于记录上个选择的Fragment
    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        fragment1 = new SubOneActivity();
        fragment2 = new SubOneActivity();
        fragment3 = new SubOneActivity();

        mTextMessage = (TextView) findViewById(R.id.message);
        fragments = new Fragment[]{fragment1, fragment2, fragment3};
        lastFragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainView, fragment1).show(fragment1).commit();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    //切换Fragment
    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.mainView, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }


    /**
     *
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //region
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    mTextMessage.setText(R.string.title_home);
                    if (lastFragment != 0) {
                        // 切换
                        switchFragment(lastFragment, 0);
                        lastFragment = 0;
                    }
                    return true;
                }
                case R.id.navigation_dashboard: {
                    mTextMessage.setText(R.string.title_dashboard);
                    if (lastFragment != 1) {
                        // 切换
                        switchFragment(lastFragment, 1);
                        lastFragment = 1;

                    }

                    return true;
                }
                case R.id.navigation_notifications: {
                    mTextMessage.setText(R.string.title_notifications);
                    if (lastFragment != 2) {
                        // 切换
                        switchFragment(lastFragment, 2);
                        lastFragment = 2;
                    }
                    return true;
                }

            }
            return false;
            //endregion
        }
    };
}



