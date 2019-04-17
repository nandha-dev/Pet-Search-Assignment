package com.nandha.petsearchassignment.api;

import java.util.List;
import retrofit2.http.GET;

interface AssignmentService {

  @GET("movies") List getPopularMovies();
}
