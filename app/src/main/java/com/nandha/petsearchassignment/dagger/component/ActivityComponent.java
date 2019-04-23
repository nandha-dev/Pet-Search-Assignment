package com.nandha.petsearchassignment.dagger.component;

import com.nandha.petsearchassignment.dagger.PerActivity;
import com.nandha.petsearchassignment.dagger.module.ActivityModule;
import dagger.Component;

@PerActivity @Component(dependencies = {
    ApplicationComponent.class
}, modules = ActivityModule.class) interface ActivityComponent extends ApplicationComponent {
}
