package com.example.softwhere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
//    private Spinner spinnerLanguage;

    private EditText editTextLanguageSearch;
    private Button btnLanguageFilter;

    private String search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        editTextLanguageSearch = findViewById(R.id.editTextLanguageSearch);
        btnLanguageFilter = findViewById(R.id.btnLanguageFilter);

        recyclerView = findViewById(R.id.recyclerViewLanguage);
        tvNoLanguages = findViewById(R.id.tvNoLanguages);
        tvNoLanguages.setVisibility(View.GONE);

//        spinnerLanguage = findViewById(R.id.spinnerLanguage);
//        final ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.filter_items, android.R.layout.simple_spinner_item);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerLanguage.setAdapter(spinnerAdapter);

        initialiseAdapterAndActivity("", "");

        btnLanguageFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search = editTextLanguageSearch.getText().toString();
                initialiseAdapterAndActivity(search, "");
            }
        });

//        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String status = spinnerLanguage.getSelectedItem().toString();
//                if(status == "All")
//                    status = "";
//                initialiseAdapterAndActivity(search, status);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    /*
    Initialising the Languages array list and deciding its contents based on the searchText and statusText.
    Setting up the adapter with the array list.
    Setting the recycler view with the adapter.
     */
    private void initialiseAdapterAndActivity(String search, String status) {
        ArrayList<Languages> languages = new ArrayList<>();
        recyclerView.setVisibility(View.VISIBLE);
        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(LanguageActivity.this);
            languages = dataBaseHelper.getAllLanguages(search, status);

            Thread.sleep(500);
        }
        catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

        if(languages.size() == 0) {
            tvNoLanguages.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        else {
            tvNoLanguages.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

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