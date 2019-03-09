package com.example.navigationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationapp.R;
import com.example.navigationapp.dto.Student;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Student> stuList;
    private LayoutInflater inflater;

    public MyAdapter() {
    }

    public MyAdapter(List<Student> stuList, Context context) {
        this.stuList = stuList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stuList == null ? 0 : stuList.size();
    }

    @Override
    public Student getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view = inflater.inflate(R.layout.student_layout, null);
        Student student = getItem(position);
        //在view视图中查找id为image_photo的控件
        ImageView image_photo = (ImageView) view.findViewById(R.id.image_photo);
        TextView tv_name = (TextView) view.findViewById(R.id.name);
        TextView tv_age = (TextView) view.findViewById(R.id.age);
        image_photo.setImageResource(student.getPhoto());
        tv_name.setText(student.getName());
        tv_age.setText(String.valueOf(student.getAge()));
        return view;
    }
}