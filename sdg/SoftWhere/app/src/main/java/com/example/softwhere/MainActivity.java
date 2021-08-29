package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.softwhere.Asorted.Jobs;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewHomePL, cardViewHomeInfo, cardViewHomeJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

//        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
//        if(dataBaseHelper.deleteOneJob(-1)) {
//            Toast.makeText(MainActivity.this,"Item Deleted", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(MainActivity.this,"Deletion Failed", Toast.LENGTH_SHORT).show();
//        }


//        try {
//            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
//            boolean success = dataBaseHelper.addJob(new Jobs(
//                    -1,
//                    "Strategic Cloud Engineer, Infrastructure, Cloud Professional Services",
//                    "As a Strategic Cloud Engineer, you'll guide customers on how to configure and deploy their containers on the cloud, consisting of network architecture, identity and access management, application security, logging, monitoring, billing and more.\n" +
//                            "\n" +
//                            "In this role, you'll work with strategic cloud customers. Together with the team, you will support customer implementation of Google Cloud products through architecture guidance, best practices, data migration, capacity planning, implementation, troubleshooting, monitoring, and more.\n" +
//                            "\n" +
//                            "Work as a trusted technical advisor to customers and solve complex cloud infrastructure challenges in the areas of networking, containerization and clustering.\n" +
//                            "Create and deliver best practice recommendations, tutorials, blog articles, open-source and sample code, and technical presentations adapting to different levels of key business and technical stakeholders.\n" +
//                            "\n" +
//                            "Act as a liaison for the engineering and product teams to commercialize solutions with partners and customers.",
//                    "Experience with cluster deployment and orchestration technologies (e.g., Puppet, Chef, Salt, Ansible, Docker, Kubernetes, Mesos, OpenStack, Jenkins).\n" +
//                            "Experience with scalable networking technologies (e.g., Load Balancers, Firewalls) and web standards (e.g., REST APIs, web security mechanisms).\n" +
//                            "Experience in system administration tasks in Linux, Unix, or Windows and familiarity with standard IT security practices (e.g., encryption, certificates, key management).\n" +
//                            "Knowledge of managing Kubernetes in large production environments.\n" +
//                            "Demonstrated understanding of open source server software (e.g., NGINX, RabbitMQ, Redis, Elasticsearch, etc).",
//                    "https://in.linkedin.com/jobs/view/strategic-cloud-engineer-infrastructure-cloud-professional-services-at-google-2616071343?refId=2Wz5hMHWPN5n5%2BhULhB33g%3D%3D&trackingId=nU%2B%2BbragrCuFXunZanXBrw%3D%3D&trk=public_jobs_topcard-title",
//                    "$39,457 per year",
//                    "https://bsmedia.business-standard.com/_media/bs/img/about-page/1562577931.jpg"
//            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();
//
//        } catch (Exception e) {
//            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }

        cardViewHomePL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cardViewHomeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        cardViewHomeJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {
        cardViewHomePL = findViewById(R.id.cardViewHomePL);
        cardViewHomeInfo = findViewById(R.id.cardViewHomeInfo);
        cardViewHomeJobs = findViewById(R.id.cardViewHomeJobs);
    }
}