package com.example.softwhere.RecViewAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwhere.Asorted.Languages;
import com.example.softwhere.DataBaseHelper;
import com.example.softwhere.R;

import java.util.ArrayList;

public class LanguageRecViewAdapter extends RecyclerView.Adapter<LanguageRecViewAdapter.LanguageViewHolder> {

    private ArrayList<Languages> languages = new ArrayList<>();
    private Context mContext;

    public LanguageRecViewAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_language, parent, false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LanguageViewHolder holder, final int position) {
        final Languages language = languages.get(position);

        // Normal Setup
        holder.textViewLanguageCardTitle.setText(language.getTitle());
        holder.textViewLanguageType.setText(language.getType());
        holder.textViewLanguageStatus.setText(language.getStatus());
        holder.textViewLanguageDescription.setText(language.getDescription());
        holder.cardViewLanguageItemInnerConstraint2.setVisibility(View.GONE);
//        holder.cardViewLanguageItemInnerConstraint3.setBackgroundColor(Color.parseColor(language.getLanguageColor()));

        // Arrow Button Setup
        holder.btnLanguageDownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
                holder.btnLanguageDownArrow.setVisibility(View.GONE);
                holder.cardViewLanguageItemInnerConstraint2.setVisibility(View.VISIBLE);
            }
        });

        holder.btnLanguageUpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
                holder.btnLanguageDownArrow.setVisibility(View.VISIBLE);
                holder.cardViewLanguageItemInnerConstraint2.setVisibility(View.GONE);
            }
        });

        // RadioButtonSetup
        holder.radioButtonLanguageUnseen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardViewLanguageItemInnerConstraint3.setBackgroundColor(Color.parseColor("#F7F6F2"));
                DataBaseHelper dataBaseHelper = new DataBaseHelper(mContext);
                dataBaseHelper.updateLanguageStatus(language.getId(), "UNSEEN");
                holder.textViewLanguageStatus.setText("UNSEEN");
            }
        });

        holder.radioButtonLanguageStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardViewLanguageItemInnerConstraint3.setBackgroundColor(Color.parseColor("#FFF7AE"));
                DataBaseHelper dataBaseHelper = new DataBaseHelper(mContext);
                dataBaseHelper.updateLanguageStatus(language.getId(), "START");
                holder.textViewLanguageStatus.setText("START");
            }
        });

        holder.radioButtonLanguageCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardViewLanguageItemInnerConstraint3.setBackgroundColor(Color.parseColor("#80ED99"));
                DataBaseHelper dataBaseHelper = new DataBaseHelper(mContext);
                dataBaseHelper.updateLanguageStatus(language.getId(), "COMPLETED");
                holder.textViewLanguageStatus.setText("COMPLETED");
            }
        });

    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    public void setLanguages(ArrayList<Languages> languages) {
        this.languages = languages;
        notifyDataSetChanged();
    }

    public class LanguageViewHolder extends RecyclerView.ViewHolder {

        private CardView parentCardViewLanguageItem;
        private ConstraintLayout cardViewLanguageItemInnerConstraint2, cardViewLanguageItemInnerConstraint3;
        private TextView textViewLanguageCardTitle, textViewLanguageType,
                textViewLanguageDescription, textViewLanguageStatus;
        private ImageView btnLanguageDownArrow, btnLanguageUpArrow;
        private RadioGroup radioGroupLanguage;
        private RadioButton radioButtonLanguageUnseen, radioButtonLanguageStarted, radioButtonLanguageCompleted;


        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);

            parentCardViewLanguageItem = itemView.findViewById(R.id.parentCardViewLanguageItem);

            cardViewLanguageItemInnerConstraint2 = itemView.findViewById(R.id.cardViewLanguageItemInnerConstraint2);
            cardViewLanguageItemInnerConstraint3 = itemView.findViewById(R.id.cardViewLanguageItemInnerConstraint3);

            textViewLanguageCardTitle = itemView.findViewById(R.id.textViewLanguageCardTitle);
            textViewLanguageType = itemView.findViewById(R.id.textViewLanguageType);
            textViewLanguageDescription = itemView.findViewById(R.id.textViewLanguageDescription);
            textViewLanguageStatus = itemView.findViewById(R.id.textViewLanguageStatus);

            btnLanguageDownArrow = itemView.findViewById(R.id.btnLanguageDownArrow);
            btnLanguageUpArrow = itemView.findViewById(R.id.btnLanguageUpArrow);

            radioGroupLanguage = itemView.findViewById(R.id.radioGroupLanguage);
            radioButtonLanguageUnseen = itemView.findViewById(R.id.radioButtonLanguageUnseen);
            radioButtonLanguageStarted = itemView.findViewById(R.id.radioButtonLanguageStarted);
            radioButtonLanguageCompleted = itemView.findViewById(R.id.radioButtonLanguageCompleted);
        }
    }
}
