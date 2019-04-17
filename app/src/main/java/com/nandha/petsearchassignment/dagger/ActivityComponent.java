package com.nandha.petsearchassignment.dagger;

import dagger.Component;

@PerActivity @Component(dependencies = {
    ApplicationComponent.class
}, modules = ActivityModule.class) public interface ActivityComponent extends ApplicationComponent {
}
