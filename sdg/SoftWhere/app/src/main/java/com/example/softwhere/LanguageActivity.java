package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.softwhere.Asorted.Languages;
import com.example.softwhere.Asorted.ShortJob;
import com.example.softwhere.RecViewAdapter.JobsRecViewAdapter;
import com.example.softwhere.RecViewAdapter.LanguageRecViewAdapter;

import java.util.ArrayList;

public class LanguageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LanguageRecViewAdapter adapter;
    private TextView tvNoLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        recyclerView = findViewById(R.id.recyclerViewLanguage);
        tvNoLanguages = findViewById(R.id.tvNoLanguages);
        tvNoLanguages.setVisibility(View.GONE);

        ArrayList<Languages> languages = new ArrayList<>();
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(LanguageActivity.this);
            languages = dataBaseHelper.getAllLanguages("", "");

            Thread.sleep(500);
        }
        catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

        if(languages.size() == 0)
            tvNoLanguages.setVisibility(View.VISIBLE);
        else {
            tvNoLanguages.setVisibility(View.GONE);

            try {
                adapter = new LanguageRecViewAdapter(this);
                adapter.setLanguages(languages);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(LanguageActivity.this));
            }
            catch (Exception e) {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}