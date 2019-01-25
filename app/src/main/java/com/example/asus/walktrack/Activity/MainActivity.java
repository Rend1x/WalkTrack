package com.example.asus.walktrack.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.walktrack.Adapter.MetricAdapter;
import com.example.asus.walktrack.Model.Metric;
import com.example.asus.walktrack.R;
import com.example.asus.walktrack.Retrofit.MyAPI;
import com.example.asus.walktrack.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    MyAPI myAPI;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //api
        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);

        //recycle
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getMetricData();
    }

    private void getMetricData() {

        compositeDisposable.add(myAPI.getMetrics()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<Metric>>() {
                        @Override
                        public void accept(List<Metric> metrics) throws Exception {
                            displayData(metrics);
                        }
                    }));

    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    private void displayData(List<Metric> metrics) {
        MetricAdapter metricAdapter = new MetricAdapter(this,metrics);
        recyclerView.setAdapter(metricAdapter);
    }
}
