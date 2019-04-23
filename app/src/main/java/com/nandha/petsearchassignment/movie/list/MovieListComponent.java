package com.nandha.petsearchassignment.movie.list;

import com.nandha.petsearchassignment.dagger.PerActivity;
import com.nandha.petsearchassignment.dagger.component.ApplicationComponent;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {MovieListModule.class})
public interface MovieListComponent {
  void injectActivity(MovieListActivity movieListActivity);
}
