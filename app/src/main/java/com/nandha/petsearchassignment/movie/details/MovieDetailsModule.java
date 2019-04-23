package com.nandha.petsearchassignment.movie.details;

import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.dagger.ActivityModule;
import dagger.Module;
import dagger.Provides;

@Module class MovieDetailsModule extends ActivityModule {

  private MovieDetailsView movieDetailsView;

  MovieDetailsModule(MovieDetailsActivity activity) {
    super(activity);
    this.movieDetailsView = activity;
  }

  @Provides MovieDetailsPresenter provoidesMovieDetailsPresenter(AssignmentApi assignmentApi) {
    return new MovieDetailsPresenter(movieDetailsView, assignmentApi);
  }
}
