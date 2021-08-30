package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.softwhere.Asorted.ShortJob;
import com.example.softwhere.RecViewAdapter.JobsRecViewAdapter;

import java.util.ArrayList;

public class JobsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JobsRecViewAdapter adapter;
    private TextView tvNoJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        recyclerView = findViewById(R.id.recyclerViewJobs);
        tvNoJobs = findViewById(R.id.tvNoJobs);
        tvNoJobs.setVisibility(View.GONE);

        ArrayList<ShortJob> shortJobs = new ArrayList<>();
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(JobsActivity.this);
            shortJobs = dataBaseHelper.getAllCardJobs();

            Thread.sleep(500);
        }
        catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

//        shortJobs.add(new ShortJob(1, "Hello", "50000", "https://resources.workable.com/wp-content/uploads/2017/02/how-to-post-jobs-indeed-featured.png"));


        if(shortJobs.size() == 0)
            tvNoJobs.setVisibility(View.VISIBLE);
        else {
            tvNoJobs.setVisibility(View.GONE);

            try {
                adapter = new JobsRecViewAdapter(this);
                adapter.setShortJobs(shortJobs);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(JobsActivity.this));
            }
            catch (Exception e) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
//            Toast.makeText(this, shortJobs.get(0) + "", Toast.LENGTH_SHORT).show();

    }
}