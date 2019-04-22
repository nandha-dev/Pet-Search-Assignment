package com.nandha.petsearchassignment.model;

import com.google.gson.annotations.SerializedName;

public class Genre {
  @SerializedName("name") private String name;

  public String getName() {
    return name;
  }
}
