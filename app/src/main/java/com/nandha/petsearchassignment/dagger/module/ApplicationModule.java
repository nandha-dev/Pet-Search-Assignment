package com.nandha.petsearchassignment.dagger.module;

import android.app.Application;
import com.nandha.petsearchassignment.Assignment;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class ApplicationModule {
  private final Assignment assignment;

  public ApplicationModule(Assignment assignment) {
    this.assignment = assignment;
  }

  @Provides @Singleton Application providesApplication() {
    return assignment;
  }
}
