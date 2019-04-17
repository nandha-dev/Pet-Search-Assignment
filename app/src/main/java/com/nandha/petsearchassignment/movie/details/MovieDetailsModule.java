package com.nandha.petsearchassignment.movie.details;

import com.nandha.petsearchassignment.dagger.ActivityModule;
import dagger.Module;

@Module class MovieDetailsModule extends ActivityModule {

  MovieDetailsModule(MovieDetailsActivity activity) {
    super(activity);
  }
}
