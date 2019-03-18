package com.example.navigationapp;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.navigationapp.adapter.MyAdapter;
import com.example.navigationapp.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends TabActivity {
    private ListView listView, listView2;
    private MyAdapter adapter;
    private MyAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelf_map_tabhost_layout);
        /* 标签页初始化 */
        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tb1").setIndicator("标签1").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tb2").setIndicator("标签2").setContent(R.id.tab2));
        listView = (ListView) findViewById(R.id.listView1);
        this.setAdapter();

        listView2 = (ListView) findViewById(R.id.listView2);
        this.setAdapter2();


    }

    /**
     * @param
     */
    private void setAdapter() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list = new ArrayList<>();

        List<Student> stuList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student stu = new Student();
            stu.setAge(10 + i);
            stu.setName("name" + i);
            stu.setPhoto(R.mipmap.ic_launcher);
            stuList.add(stu);
        }

        adapter = new MyAdapter(stuList, getApplicationContext());

        listView.setAdapter(adapter);

    }


    /**
     * @param
     */
    private void setAdapter2() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list = new ArrayList<>();

        List<Student> stuList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student stu = new Student();
            stu.setAge(10 + i);
            stu.setName("namessss" + i);
            stu.setPhoto(R.mipmap.ic_launcher);
            stuList.add(stu);
        }
        adapter2 = new MyAdapter(stuList, getApplicationContext());
        listView2.setAdapter(adapter2);
    }


}
