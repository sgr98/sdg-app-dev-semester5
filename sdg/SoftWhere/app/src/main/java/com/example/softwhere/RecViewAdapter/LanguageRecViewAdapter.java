package com.example.softwhere.RecViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwhere.Asorted.Languages;
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
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, final int position) {
        final Languages language = languages.get(position);

        holder.textViewLanguageCardTitle.setText(language.getTitle());
        holder.textViewLanguageType.setText(language.getType());
        holder.textViewLanguageStatus.setText(language.getStatus());
        holder.textViewLanguageDescription.setText(language.getDescription());

//        holder.parentCardViewLanguageItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, language + "", Toast.LENGTH_SHORT).show();
//            }
//        });
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
        private TextView textViewLanguageCardTitle, textViewLanguageType,
                textViewLanguageDescription, textViewLanguageStatus;
        private ImageView btnLanguageDownArrow, btnLanguageUpArrow;

        public LanguageViewHolder(@NonNull View itemView) {
            super(itemView);

            parentCardViewLanguageItem = itemView.findViewById(R.id.parentCardViewLanguageItem);

            textViewLanguageCardTitle = itemView.findViewById(R.id.textViewLanguageCardTitle);
            textViewLanguageType = itemView.findViewById(R.id.textViewLanguageType);
            textViewLanguageDescription = itemView.findViewById(R.id.textViewLanguageDescription);
            textViewLanguageStatus = itemView.findViewById(R.id.textViewLanguageStatus);

            btnLanguageDownArrow = itemView.findViewById(R.id.btnLanguageDownArrow);
            btnLanguageUpArrow = itemView.findViewById(R.id.btnLanguageUpArrow);
        }
    }
}
