package com.nandha.petsearchassignment.movie.details;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.nandha.petsearchassignment.model.Movie;

public interface MovieDetailsView extends MvpView {
  void updateDetails(Movie movie);
}
