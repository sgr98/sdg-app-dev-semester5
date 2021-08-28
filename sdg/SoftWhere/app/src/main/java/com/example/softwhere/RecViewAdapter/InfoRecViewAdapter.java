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

import com.bumptech.glide.Glide;
import com.example.softwhere.Asorted.Infos;
import com.example.softwhere.R;

import java.util.ArrayList;


public class InfoRecViewAdapter extends RecyclerView.Adapter<InfoRecViewAdapter.ViewHolder> {

    private ArrayList<Infos> infos = new ArrayList<>();
    private Context context;

    public InfoRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Infos info = infos.get(position);
        holder.textViewInfoCardTitle.setText(info.getTitle());

        holder.parentCardViewInfoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, info.getTitle() + " is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(info.getImageURL())
                .into(holder.imgCardInfo);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public void setInfos(ArrayList<Infos> infos) {
        this.infos = infos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView parentCardViewInfoItem;
        private ImageView imgCardInfo;
        private TextView textViewInfoCardTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentCardViewInfoItem = itemView.findViewById(R.id.parentCardViewInfoItem);
            imgCardInfo = itemView.findViewById(R.id.imgCardInfo);
            textViewInfoCardTitle = itemView.findViewById(R.id.textViewInfoCardTitle);
        }
    }
}
