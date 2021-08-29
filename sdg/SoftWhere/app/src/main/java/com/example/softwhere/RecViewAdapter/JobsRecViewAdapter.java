package com.example.softwhere.RecViewAdapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.softwhere.Asorted.ShortJob;
import com.example.softwhere.DataBaseHelper;
import com.example.softwhere.InnerViews.JobDetailsActivity;
import com.example.softwhere.MainActivity;
import com.example.softwhere.R;

import java.util.ArrayList;

import static com.example.softwhere.InnerViews.JobDetailsActivity.JobDetailId;

public class JobsRecViewAdapter extends RecyclerView.Adapter<JobsRecViewAdapter.JobsViewHolder>{

    private ArrayList<ShortJob> shortJobs = new ArrayList<>();
    private Context mContext;

    public JobsRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_jobs, parent, false);
        return new JobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, final int position) {
        final ShortJob shortJob = shortJobs.get(position);

        holder.textViewJobsCardTitle.setText(shortJob.getTitle());
        holder.textViewJobsCardSalary.setText(shortJob.getSalary());

        holder.parentCardViewJobsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"Card Id: " + shortJob.getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, JobDetailsActivity.class);
                intent.putExtra(JobDetailId, shortJob.getId());
                mContext.startActivity(intent);

//                DataBaseHelper dataBaseHelper = new DataBaseHelper(mContext);
//                if(dataBaseHelper.deleteOneJob(shortJob.getId())) {
//                    Toast.makeText(mContext,"Item Deleted", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(mContext,"Deletion Failed", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        Glide.with(mContext)
                .asBitmap()
                .load(shortJob.getImageURL())
                .into(holder.imgCardJobs);
    }

    @Override
    public int getItemCount() {
        return shortJobs.size();
    }

    public void setShortJobs(ArrayList<ShortJob> shortJobs) {
        this.shortJobs = shortJobs;
        notifyDataSetChanged();
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {

        private CardView parentCardViewJobsItem;
        private ImageView imgCardJobs;
        private TextView textViewJobsCardTitle, textViewJobsCardSalary;

        public JobsViewHolder(@NonNull View itemView) {
            super(itemView);

            parentCardViewJobsItem = itemView.findViewById(R.id.parentCardViewJobsItem);
            imgCardJobs = itemView.findViewById(R.id.imgCardJobs);
            textViewJobsCardTitle = itemView.findViewById(R.id.textViewJobsCardTitle);
            textViewJobsCardSalary = itemView.findViewById(R.id.textViewJobsCardSalary);
        }
    }
}
