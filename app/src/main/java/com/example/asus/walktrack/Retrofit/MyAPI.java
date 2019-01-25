package com.example.asus.walktrack.Retrofit;

import com.example.asus.walktrack.Model.Metric;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyAPI {
    @GET("metric.json")
    Observable<List<Metric>> getMetrics();
}
