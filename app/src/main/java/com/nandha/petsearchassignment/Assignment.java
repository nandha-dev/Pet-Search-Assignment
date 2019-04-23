package com.nandha.petsearchassignment;

import android.app.Application;
import com.nandha.petsearchassignment.dagger.component.ApplicationComponent;
import com.nandha.petsearchassignment.dagger.component.DaggerApplicationComponent;
import com.nandha.petsearchassignment.dagger.module.ApplicationModule;

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
