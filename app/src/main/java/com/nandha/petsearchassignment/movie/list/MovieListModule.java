package com.nandha.petsearchassignment.movie.list;

import com.nandha.petsearchassignment.dagger.ActivityModule;
import dagger.Module;
import dagger.Provides;

@Module class MovieListModule extends ActivityModule {

  MovieListModule(MovieListActivity activity) {
    super(activity);
  }

  @Provides MovieListAdapter provideMovieListAdapter() {
    return new MovieListAdapter();
  }
}
