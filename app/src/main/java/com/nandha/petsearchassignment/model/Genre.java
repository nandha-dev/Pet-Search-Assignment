package com.nandha.petsearchassignment.model;

import com.google.gson.annotations.SerializedName;

public class Genre {
  @SerializedName("id") int id;
  @SerializedName("name") String name;

  public String getName() {
    return name;
  }
}
