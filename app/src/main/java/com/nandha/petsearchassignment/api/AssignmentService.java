package com.nandha.petsearchassignment.api;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface AssignmentService {

  @GET("discover/movie") List getPopularMovies(@Query("api_key") String api_key,
      @Query("sort_by") String sort_by);
}
