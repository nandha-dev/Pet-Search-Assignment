package com.nandha.petsearchassignment.movie.list;

import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.dagger.module.ActivityModule;
import dagger.Module;
import dagger.Provides;

@Module class MovieListModule extends ActivityModule {

  private MovieListView movieListView;

  MovieListModule(MovieListActivity activity) {
    super(activity);
    this.movieListView = activity;
  }

  @Provides MovieListAdapter provideMovieListAdapter() {
    return new MovieListAdapter();
  }

  @Provides MovieListPresenter provideMovieListPresenter(AssignmentApi assignmentApi) {
    return new MovieListPresenter(movieListView, assignmentApi);
  }
}
