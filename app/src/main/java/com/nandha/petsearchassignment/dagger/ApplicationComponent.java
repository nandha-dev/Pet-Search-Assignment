package com.nandha.petsearchassignment.dagger;

import android.app.Application;
import com.nandha.petsearchassignment.api.AssignmentApi;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {ApplicationModule.class, ApiModule.class, GsonModule.class})
public interface ApplicationComponent {

  Application getApplication();

  AssignmentApi getAssignmentApi();
}
