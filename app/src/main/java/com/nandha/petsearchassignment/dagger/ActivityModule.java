package com.nandha.petsearchassignment.dagger;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {
  private final Activity mActivity;

  public ActivityModule(Activity activity) {
    mActivity = activity;
  }

  @Provides @PerActivity Activity activity() {
    return mActivity;
  }

  @Provides @PerActivity Context provideActivityContext() {
    return mActivity;
  }
}
