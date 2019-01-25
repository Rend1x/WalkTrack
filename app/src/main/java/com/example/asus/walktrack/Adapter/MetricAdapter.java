package com.example.asus.walktrack.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.walktrack.Model.Metric;
import com.example.asus.walktrack.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MetricAdapter extends RecyclerView.Adapter<MetricViewHolder> {

    Context context;
    List<Metric> metrics;

    public MetricAdapter(Context context, List<Metric> metrics) {
        this.context = context;
        this.metrics = metrics;
    }

    @NonNull
    @Override
    public MetricViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.metric_layout,viewGroup,false);
        return new MetricViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MetricViewHolder holder, int pos) {

        int allCountWalk = metrics.get(pos).walk + metrics.get(pos).aerobic + metrics.get(pos).run;
        int allCount = 4000;

        Date date = new Date(metrics.get(pos).date);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        holder.date.setText(simpleDateFormat.format(date));
        holder.walk.setText(String.valueOf(metrics.get(pos).walk));
        holder.aerobic.setText(String.valueOf(metrics.get(pos).aerobic));
        holder.run.setText(String.valueOf(metrics.get(pos).run));
        holder.all_count_walk.setText(String.valueOf(allCountWalk));
        holder.all_metric.setText(String.valueOf(allCount));

        if (allCountWalk >= allCount){
            holder.goal.setVisibility(View.VISIBLE);
        }else {
            holder.goal.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return metrics.size();
    }
}
