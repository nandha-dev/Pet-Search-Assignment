package com.nandha.petsearchassignment.helpers;

import com.nandha.petsearchassignment.model.Genre;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StringHelper {
  public static String dateToReleaseDate(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy ", Locale.getDefault());
    return format.format(date);
  }

  public static String intToMillion(int number) {
    float million = number / 1000000f;
    return String.format(Locale.getDefault(), "$%.1f Million", million);
  }

  public static String genreListToString(List<Genre> genreList) {
    StringBuilder genres = new StringBuilder();
    for (Genre genre : genreList) {
      genres.append(genre.getName()).append(", ");
    }
    genres.deleteCharAt(genres.lastIndexOf(", "));
    return genres.toString();
  }
}
