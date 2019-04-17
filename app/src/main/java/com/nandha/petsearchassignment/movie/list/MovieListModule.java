package com.nandha.petsearchassignment.movie.list;

import com.nandha.petsearchassignment.dagger.ActivityModule;
import dagger.Module;
import dagger.Provides;

@Module public class MovieListModule extends ActivityModule {

  public MovieListModule(MovieListActivity activity) {
    super(activity);
  }

  @Provides MovieListAdapter provideMovieListAdapter() {
    return new MovieListAdapter();
  }
}
