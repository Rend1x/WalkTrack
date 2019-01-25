package com.example.asus.walktrack.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.walktrack.R;

public class MetricViewHolder extends RecyclerView.ViewHolder{

    TextView walk,aerobic,run,date,all_count_walk,all_metric;
    LinearLayout goal;

    public MetricViewHolder(@NonNull View itemView) {
        super(itemView);

        walk = (TextView) itemView.findViewById(R.id.walk_metric);
        aerobic = (TextView) itemView.findViewById(R.id.aerobic_metric);
        run = (TextView) itemView.findViewById(R.id.run_metric);
        date = (TextView) itemView.findViewById(R.id.date_metric);
        all_count_walk = (TextView) itemView.findViewById(R.id.all_count_walk);
        all_metric = (TextView) itemView.findViewById(R.id.all_count);
        goal = (LinearLayout) itemView.findViewById(R.id.goal);
    }
}
