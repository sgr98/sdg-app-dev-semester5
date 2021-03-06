package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.softwhere.Asorted.Jobs;
import com.example.softwhere.Asorted.Languages;

public class MainActivity extends AppCompatActivity {

    private CardView cardViewHomePL, cardViewHomeInfo, cardViewHomeJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        if(Utils.getInstance(this).getIniti() == "false") {
            initialiseDatabase();
            Utils.getInstance(this).setIniti("true");
        }

        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to initialise", Toast.LENGTH_SHORT).show();
        }

        cardViewHomePL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(MainActivity.this, JobsActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    Initiating the required layout components of activity_main
     */
    private void initData() {
        cardViewHomePL = findViewById(R.id.cardViewHomePL);
        cardViewHomeInfo = findViewById(R.id.cardViewHomeInfo);
        cardViewHomeJobs = findViewById(R.id.cardViewHomeJobs);
    }

    /*
    Initialising the local database with required values.
    Two tables are present: JOB_DETAILS_TABLE and LANGUAGES_TABLE.
     */
    private void initialiseDatabase() {
        // 1
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addJob(new Jobs(
                    -1,
                    "Software integration engineer",
                    "In the modern era of smart devices and the internet of things, software integration engineers (also referred to as embedded systems developers) use coding languages to program hardware like consumer devices, home security alert systems, electronics, interfaces, real-time systems and serial data transmissions.",
                    "C, C++, Assembly, Java, proprietary technologies/frameworks/toolkits",
                    "https://www.indeed.com/career-advice/finding-a-job/types-of-software-engineer",
                    "$108,182 per year",
                    "https://resources.workable.com/wp-content/uploads/2017/02/how-to-post-jobs-indeed-featured.png"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 2
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addJob(new Jobs(
                    -1,
                    "Strategic Cloud Engineer, Infrastructure, Cloud Professional Services",
                    "As a Strategic Cloud Engineer, you'll guide customers on how to configure and deploy their containers on the cloud, consisting of network architecture, identity and access management, application security, logging, monitoring, billing and more.\n" +
                            "\n" +
                            "In this role, you'll work with strategic cloud customers. Together with the team, you will support customer implementation of Google Cloud products through architecture guidance, best practices, data migration, capacity planning, implementation, troubleshooting, monitoring, and more.\n" +
                            "\n" +
                            "Work as a trusted technical advisor to customers and solve complex cloud infrastructure challenges in the areas of networking, containerization and clustering.\n" +
                            "Create and deliver best practice recommendations, tutorials, blog articles, open-source and sample code, and technical presentations adapting to different levels of key business and technical stakeholders.\n" +
                            "\n" +
                            "Act as a liaison for the engineering and product teams to commercialize solutions with partners and customers.",
                    "Experience with cluster deployment and orchestration technologies (e.g., Puppet, Chef, Salt, Ansible, Docker, Kubernetes, Mesos, OpenStack, Jenkins).\n" +
                            "Experience with scalable networking technologies (e.g., Load Balancers, Firewalls) and web standards (e.g., REST APIs, web security mechanisms).\n" +
                            "Experience in system administration tasks in Linux, Unix, or Windows and familiarity with standard IT security practices (e.g., encryption, certificates, key management).\n" +
                            "Knowledge of managing Kubernetes in large production environments.\n" +
                            "Demonstrated understanding of open source server software (e.g., NGINX, RabbitMQ, Redis, Elasticsearch, etc).",
                    "https://in.linkedin.com/jobs/view/strategic-cloud-engineer-infrastructure-cloud-professional-services-at-google-2616071343?refId=2Wz5hMHWPN5n5%2BhULhB33g%3D%3D&trackingId=nU%2B%2BbragrCuFXunZanXBrw%3D%3D&trk=public_jobs_topcard-title",
                    "$39,457 per year",
                    "https://bsmedia.business-standard.com/_media/bs/img/about-page/1562577931.jpg"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 3
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addJob(new Jobs(
                    -1,
                    "Full-stack engineer",
                    "A software engineer who is fluent in front-end and back-end skills and responsibilities is referred to as a full-stack engineer. These individuals possess all the skills necessary to create a fully functional web app, from the front-facing user experience to the complex systems behind it.",
                    "UX and UI frameworks, CSS, JavaScript, HTML, Java, C, C++, Ruby, Perl, Python, Scala, Go, Kubernetes, Docker, Apache Mesos, Jenkins, HashiCorp stack (Terraform, Vault, Consul, Nomad)",
                    "https://www.indeed.com/career-advice/finding-a-job/types-of-software-engineer",
                    "$111,425 per year",
                    "https://resources.workable.com/wp-content/uploads/2017/02/how-to-post-jobs-indeed-featured.png"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 4
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addJob(new Jobs(
                    -1,
                    "Data scientist",
                    "A data scientist, or data engineer, develops software programs that analyze information. This often puts them in charge of statistical analysis, machine learning, data visualization and predictive modeling, providing an organization with metrics that can help determine how a product will grow to fit the needs of the business.",
                    "SQL, R, Python",
                    "https://www.indeed.com/career-advice/finding-a-job/types-of-software-engineer",
                    "$123,060 per year",
                    "https://resources.workable.com/wp-content/uploads/2017/02/how-to-post-jobs-indeed-featured.png"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // =========================================================================================
        // =========================================================================================
        // =========================================================================================

        // 1
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "Java",
                    "Imperative, Object-Oriented, Functional",
                    "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 2
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "XML",
                    "Markup",
                    "Extensible Markup Language is a markup language that defines a set of rules for encoding documents in a format that is both human-readable and machine-readable. The World Wide Web Consortium's XML 1.0 Specification of 1998 and several other related specifications???all of them free open standards???define XML.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 3
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "SQL",
                    "Declarative",
                    "SQL is a domain-specific language used in programming and designed for managing data held in a relational database management system, or for stream processing in a relational data stream management system.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 4
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "JSON",
                    "Object-Notation",
                    "JSON is an open standard file format and data interchange format that uses human-readable text to store and transmit data objects consisting of attribute???value pairs and arrays.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 5
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "C++",
                    "Imperative, Object-Oriented, Procedural",
                    "C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or \"C with Classes\".",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 6
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "Python",
                    "Imperative, Functional, Procedural, Object-Oriented",
                    "Python is an interpreted high-level general-purpose programming language. Its design philosophy emphasizes code readability with its use of significant indentation. Its language constructs as well as its object-oriented approach aim to help programmers write clear, logical code for small and large-scale projects.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        // 7
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            boolean success = dataBaseHelper.addLanguage(new Languages(
                    -1,
                    "CSS",
                    "StyleSheet",
                    "Cascading Style Sheets is a style sheet language used for describing the presentation of a document written in a markup language such as HTML. CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript.",
                    "UNSEEN"
            ));
//            Toast.makeText(this, "Operation is " + success, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Error uploading data", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}