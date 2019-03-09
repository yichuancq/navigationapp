package com.example.navigationapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabBFragment extends Fragment {
    //绑定GridView布局
    private ListView listView;

    private List<Map> list;
    private String[] strPerson = {"妹子", "美女", "美美", "大美女", "sdfwefsf", "sdfsd", "sdfsdf", "sdfsf"};
    private int[] iDrawble = {R.drawable.ic_notifications_black_24dp};

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
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list = new ArrayList<>();
        for (int i = 0; i < strPerson.length; i++) {
            Map map = new HashMap();
            map.put("person", strPerson[i]);
            map.put("id", iDrawble[0]);
            list.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this.getActivity(),
                list,
                android.R.layout.simple_list_item_2,
                new String[]{"person", "id"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
        return view;
    }


}
