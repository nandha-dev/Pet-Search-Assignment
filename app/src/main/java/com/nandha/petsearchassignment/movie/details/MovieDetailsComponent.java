package com.nandha.petsearchassignment.movie.details;

import com.nandha.petsearchassignment.dagger.PerActivity;
import com.nandha.petsearchassignment.dagger.component.ApplicationComponent;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {MovieDetailsModule.class})
public interface MovieDetailsComponent {
  void injectActivity(MovieDetailsActivity movieDetailsActivity);
}
