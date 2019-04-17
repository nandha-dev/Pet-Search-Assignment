package com.nandha.petsearchassignment;

import android.app.Application;
import com.nandha.petsearchassignment.dagger.ApplicationComponent;
import com.nandha.petsearchassignment.dagger.ApplicationModule;
import com.nandha.petsearchassignment.dagger.DaggerApplicationComponent;

public class Assignment extends Application {

  protected ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeInjector();
  }

  private void initializeInjector() {
    applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
