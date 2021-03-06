package com.nandha.petsearchassignment.dagger.module;

import com.google.gson.Gson;
import com.nandha.petsearchassignment.AppConstants;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.helpers.OkHttpHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Module public class ApiModule {

  @Provides @Singleton OkHttpClient getOkHttpClient() {
    return OkHttpHelper.getOkHttpClientInstance();
  }

  @Provides @Singleton String getBaseUrl() {
    return AppConstants.BASE_URL;
  }

  @Provides @Singleton AssignmentApi getAssignmentApi(Gson gson) {
    return new AssignmentApi(getBaseUrl(), getOkHttpClient(), gson);
  }
}
