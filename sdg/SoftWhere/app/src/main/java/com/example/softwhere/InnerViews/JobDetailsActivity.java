package com.example.softwhere.InnerViews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.softwhere.Asorted.Jobs;
import com.example.softwhere.DataBaseHelper;
import com.example.softwhere.R;

public class JobDetailsActivity extends AppCompatActivity {

    public static final String JobDetailId = "jobDetailId";

    private ImageView imgJobDetail;
    private TextView textViewJobDetailMainTitle, textViewJobDetailDescription,
            textViewJobDetailsSkills, textViewJobDetailLink, textViewJobDetailSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        initData();

        Intent intent = getIntent();
        int id = intent.getIntExtra(JobDetailId, -1);
        if(id != -1) {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            Jobs job = dataBaseHelper.getJobById(id);

            Toast.makeText(this, "Skills:\n" + job.getSkills(), Toast.LENGTH_SHORT).show();

            textViewJobDetailMainTitle.setText(job.getTitle());
            textViewJobDetailDescription.setText(job.getDescription());
            textViewJobDetailsSkills.setText(job.getSkills());
            textViewJobDetailLink.setText(job.getLink());
            textViewJobDetailSalary.setText(job.getSalary());

            Glide.with(this)
                    .asBitmap()
                    .load(job.getImageURL())
                    .into(imgJobDetail);
        }
        else {
            textViewJobDetailMainTitle.setText("Title Not Available");
            textViewJobDetailDescription.setText("No Description Available");
            textViewJobDetailsSkills.setText("No Skills Available");
            textViewJobDetailLink.setText("No Link Available");
            textViewJobDetailSalary.setText("No Salary Available");
        }
    }

    private void initData() {
        imgJobDetail = findViewById(R.id.imgJobDetailsMain);
        textViewJobDetailMainTitle = findViewById(R.id.textViewJobDetailMainTitle);
        textViewJobDetailDescription = findViewById(R.id.textViewJobDetailDescription);
        textViewJobDetailsSkills = findViewById(R.id.textViewJobDetailsSkills);
        textViewJobDetailLink = findViewById(R.id.textViewJobDetailLink);
        textViewJobDetailSalary = findViewById(R.id.textViewJobDetailSalary);
    }
}