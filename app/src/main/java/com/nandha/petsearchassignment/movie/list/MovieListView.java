package com.nandha.petsearchassignment.movie.list;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.nandha.petsearchassignment.model.Movie;
import java.util.List;

public interface MovieListView extends MvpView {

  void showMovieList(List<Movie> patients);
}
