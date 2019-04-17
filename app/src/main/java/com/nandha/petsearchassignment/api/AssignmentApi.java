package com.nandha.petsearchassignment.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AssignmentApi {
  private final AssignmentService assignmentService;

  public AssignmentApi(String baseUrl, OkHttpClient okHttpClient, Gson gson){
    Retrofit retroFit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build();

    assignmentService = retroFit.create(AssignmentService.class);
  }
}
