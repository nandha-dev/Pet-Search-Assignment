package com.nandha.petsearchassignment.api;

import com.google.gson.Gson;
import com.nandha.petsearchassignment.AppConstants;
import com.nandha.petsearchassignment.helpers.RxHelper;
import com.nandha.petsearchassignment.model.Movie;
import com.nandha.petsearchassignment.model.MovieListResponse;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class AssignmentApi {
  private final AssignmentService assignmentService;

  public AssignmentApi(String baseUrl, OkHttpClient okHttpClient, Gson gson) {
    Retrofit retroFit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build();

    assignmentService = retroFit.create(AssignmentService.class);
  }

  public Observable<MovieListResponse> getPopularMovies() {
    return assignmentService.getPopularMovies(AppConstants.API_KEY,
        AppConstants.VALUE_SORT_BY_POPULARITY_DESC).compose(RxHelper.getTransformer());
  }

  public Observable<Movie> getMovieDetails(int movieId) {
    return assignmentService.getMovieDetails(movieId, AppConstants.API_KEY)
        .compose(RxHelper.getTransformer());
  }
}
