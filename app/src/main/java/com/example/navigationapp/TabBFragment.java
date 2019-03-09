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
    //listview
    private ListView listView;
    private String[] strPerson = {"本地音乐1", "本地音乐2", "本地音乐3", "本地音乐4", "本地音乐5", "本地音乐6", "本地音乐7", "本地音乐8"};
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
            map.put("img", R.mipmap.ic_launcher);
            list.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(this.getActivity(),
                list,
                android.R.layout.simple_list_item_2,
                new String[]{"person", "id"},
                new int[]{android.R.id.text1, iDrawble[0]});
        listView.setAdapter(adapter);
        return view;
    }


}
