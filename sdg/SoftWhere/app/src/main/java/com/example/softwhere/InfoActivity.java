package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.softwhere.Asorted.Infos;
import com.example.softwhere.RecViewAdapter.InfoRecViewAdapter;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewInfo;
    private InfoRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ArrayList<Infos> infos = new ArrayList<>();
        infos.add(new Infos(1,
                "Web Development (Front-End)",
                "",
                "",
                "https://www.datocms-assets.com/14946/1590690690-front-end.jpg"));
        infos.add(new Infos(2,
                "Web Development (Back-End)",
                "",
                "",
                "https://cdn.guru99.com/images/1/091318_0717_WhatisBacke1.png"));
        infos.add(new Infos(3,
                "Web Development (Full-Stack)",
                "",
                "",
                "https://res.cloudinary.com/dmsxwwfb5/image/upload/v1595866967/full-stack-devlopment-min.png"));
        infos.add(new Infos(4,
                "App Development (Android)",
                "",
                "",
                "https://5.imimg.com/data5/FH/UC/MY-9120378/android-app-development-company-500x500.png"));
        infos.add(new Infos(5,
                "App Development (IOS)",
                "",
                "",
                "https://krify.co/wp-content/uploads/2019/04/iOS-app-development.jpg"));
        infos.add(new Infos(6,
                "App Development (Cross-Platform)",
                "",
                "",
                "https://www.techaheadcorp.com/wp-content/uploads/2020/01/cross-platform-app-development-over-native-apps.png"));

        recyclerViewInfo = findViewById(R.id.recyclerViewInfo);
        adapter = new InfoRecViewAdapter(this);
        adapter.setInfos(infos);

        recyclerViewInfo.setAdapter(adapter);
        recyclerViewInfo.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
    }
}