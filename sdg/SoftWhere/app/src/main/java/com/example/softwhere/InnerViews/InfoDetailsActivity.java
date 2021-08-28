package com.example.softwhere.InnerViews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.softwhere.R;

public class InfoDetailsActivity extends AppCompatActivity {

    public static final String INFO_DETAIL_TITLE_KEY = "infoTitle";
    public static final String INFO_DETAIL_DESCRIPTION_KEY = "infoDescription";
    public static final String INFO_DETAIL_CONTENTS_KEY = "infoContents";

    private TextView textViewInfoDetailMainTitle, textViewInfoDetailDescription, textViewInfoDetailsCotents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_details);

        textViewInfoDetailMainTitle = findViewById(R.id.textViewInfoDetailMainTitle);
        textViewInfoDetailDescription = findViewById(R.id.textViewInfoDetailDescription);
        textViewInfoDetailsCotents = findViewById(R.id.textViewInfoDetailContents);

        Intent intent = getIntent();
        if(intent != null) {
            String infoTitle = intent.getStringExtra(INFO_DETAIL_TITLE_KEY);
            String infoDescription = intent.getStringExtra(INFO_DETAIL_DESCRIPTION_KEY);
            String infoContents = intent.getStringExtra(INFO_DETAIL_CONTENTS_KEY);

            if(infoTitle.equals(""))
                infoTitle = "Info Title";
            if(infoDescription.equals(""))
                infoDescription = "No Description Available";
            if(infoContents.equals(""))
                infoContents = "No Contents Available";

            textViewInfoDetailMainTitle.setText(infoTitle);
            textViewInfoDetailDescription.setText(infoDescription);
            textViewInfoDetailsCotents.setText(infoContents);
        }

    }
}