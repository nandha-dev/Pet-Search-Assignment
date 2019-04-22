package com.nandha.petsearchassignment.helpers;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class OkHttpHelper {
  private OkHttpHelper() {
  }

  public static OkHttpClient getOkHttpClientInstance() {
    return new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        .build();
  }
}
