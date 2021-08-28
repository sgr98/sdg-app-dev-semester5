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
                "Front-end web development, also known as client-side development is the practice of producing HTML, CSS and JavaScript for a website or Web Application so that a user can see and interact with them directly.",
                "HTML, CSS, JavaScript, Java, ReactJs, AngularJs",
                "https://www.datocms-assets.com/14946/1590690690-front-end.jpg"));
        infos.add(new Infos(2,
                "Web Development (Back-End)",
                "The back- end of a website consists of a server, an application, and a database. A back-end developer builds and maintains the technology that powers those components which, together, enable the user-facing side of the website to even exist in the first place.",
                "ReactJs, AngularJs, NodeJs, ExpressJs, Python, PHP, SQL, JSON",
                "https://cdn.guru99.com/images/1/091318_0717_WhatisBacke1.png"));
        infos.add(new Infos(3,
                "Web Development (Full-Stack)",
                "Full stack development: It refers to the development of both front end(client side) and back end(server side) portions of web application.\n" +
                        "\n" +
                        "Full stack web Developers: Full stack web developers have the ability to design complete web application and websites. They work on the frontend, backend, database and debugging of web application or websites.",
                "HTML, CSS, JavaScript, Java, ReactJs, AngularJs, NodeJs, ExpressJs, Python, PHP, SQL, JSON",
                "https://res.cloudinary.com/dmsxwwfb5/image/upload/v1595866967/full-stack-devlopment-min.png"));
        infos.add(new Infos(4,
                "App Development (Android)",
                "Android software development is the process by which applications are created for devices running the Android operating system. Google states that \"Android apps can be written using Kotlin, Java, and C++ languages\" using the Android software development kit, while using other languages is also possible.",
                "C++, Java, Kotlin, Android Studio",
                "https://5.imimg.com/data5/FH/UC/MY-9120378/android-app-development-company-500x500.png"));
        infos.add(new Infos(5,
                "App Development (IOS)",
                "iOS application development is the process of making mobile applications for Apple hardware, including iPhone, iPad and iPod Touch. The software is written in the Swift programming language or Objective-C and then deployed to the App Store for users to download.",
                "Objective C, Swift",
                "https://krify.co/wp-content/uploads/2019/04/iOS-app-development.jpg"));
        infos.add(new Infos(6,
                "App Development (Cross-Platform)",
                "Image result for cross platform app development\n" +
                        "The term “cross-platform mobile app development” or “hybrid mobile app development” speaks for itself: this is an approach that allows developers to build a mobile solution that is simultaneously compatible with several operating systems and platforms (Android, iOS, Windows).",
                "React Native, Flutter",
                "https://www.techaheadcorp.com/wp-content/uploads/2020/01/cross-platform-app-development-over-native-apps.png"));

        recyclerViewInfo = findViewById(R.id.recyclerViewInfo);
        adapter = new InfoRecViewAdapter(this);
        adapter.setInfos(infos);

        recyclerViewInfo.setAdapter(adapter);
        recyclerViewInfo.setLayoutManager(new LinearLayoutManager(InfoActivity.this));
    }
}