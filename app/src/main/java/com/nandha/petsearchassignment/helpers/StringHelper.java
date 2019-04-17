package com.nandha.petsearchassignment.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringHelper {
  public static String dateToReleaseDate(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy ", Locale.getDefault());
    return format.format(date);
  }

  public static String intToMillion(int number) {
    float million = number / 1000000;
    return String.format(Locale.getDefault(), "$ %.1f Million", million);
  }
}
