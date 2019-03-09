package com.example.navigationapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.navigationapp.adapter.MyAdapter;
import com.example.navigationapp.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabBFragment extends Fragment {
    private ListView listView;
    //自定义BaseAdapter
    private MyAdapter adapter;

    public static TabBFragment newInstance(String text) {
        TabBFragment fragmentCommon = new TabBFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //不同的Activity对应不同的布局
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        listView = (ListView) view.findViewById(R.id.listview);

        this.setAdapter(view);
        return view;
    }

    /**
     * @param view
     */
    private void setAdapter(View view) {
        listView = (ListView) view.findViewById(R.id.listview);
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
        adapter = new MyAdapter(stuList, this.getActivity());
        listView.setAdapter(adapter);
    }


}
