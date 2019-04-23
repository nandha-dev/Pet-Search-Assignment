package com.nandha.petsearchassignment.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class Movie {
  @SerializedName("id") private int id;
  @SerializedName("title") private String title;
  @SerializedName("overview") private String overview;
  @SerializedName("vote_average") private float rating;
  @SerializedName("poster_path") private String posterPath;
  @SerializedName("original_language") private String language;
  @SerializedName("release_date") private Date release_date;
  @SerializedName("backdrop_path") private String backdrop_path;
  @SerializedName("budget") private int budget;
  @SerializedName("revenue") private int revenue;
  @SerializedName("runtime") private int runtime;
  @SerializedName("genres") private List<Genre> genreList;

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

  public String getBackdrop_path() {
    return backdrop_path;
  }

  public int getBudget() {
    return budget;
  }

  public int getRevenue() {
    return revenue;
  }

  public int getRuntime() {
    return runtime;
  }

  public List<Genre> getGenreList() {
    return genreList;
  }
}
