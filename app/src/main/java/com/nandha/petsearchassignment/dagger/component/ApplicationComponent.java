package com.nandha.petsearchassignment.dagger.component;

import android.app.Application;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.dagger.module.ApiModule;
import com.nandha.petsearchassignment.dagger.module.ApplicationModule;
import com.nandha.petsearchassignment.dagger.module.GsonModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {ApplicationModule.class, ApiModule.class, GsonModule.class})
public interface ApplicationComponent {

  Application getApplication();

  AssignmentApi getAssignmentApi();
}
