package com.nandha.petsearchassignment.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Movie {
  @SerializedName("id") private int id;
  @SerializedName("title") private String title;
  @SerializedName("overview") private String overview;
  @SerializedName("vote_average") private float rating;
  @SerializedName("poster_path") private String posterPath;
  @SerializedName("original_language") private String language;
  @SerializedName("release_date") private Date release_date;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getOverview() {
    return overview;
  }

  public float getRating() {
    return rating;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public String getLanguage() {
    return language;
  }

  public Date getRelease_date() {
    return release_date;
  }
}
