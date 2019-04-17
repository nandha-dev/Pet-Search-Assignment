package com.nandha.petsearchassignment.api;

import com.nandha.petsearchassignment.model.Movie;
import com.nandha.petsearchassignment.model.MovieListResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

interface AssignmentService {

  @GET("discover/movie") Observable<MovieListResponse> getPopularMovies(
      @Query("api_key") String api_key,
      @Query("sort_by") String sort_by);

  @GET("movie/{id}") Observable<Movie> getMovieDetails(
      @Path("id") int id,
      @Query("api_key") String api_key);
}
