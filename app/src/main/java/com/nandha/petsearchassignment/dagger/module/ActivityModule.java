package com.nandha.petsearchassignment.dagger.module;

import android.app.Activity;
import android.content.Context;
import com.nandha.petsearchassignment.dagger.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity Activity activity() {
    return activity;
  }

  @Provides @PerActivity Context provideActivityContext() {
    return activity;
  }
}
