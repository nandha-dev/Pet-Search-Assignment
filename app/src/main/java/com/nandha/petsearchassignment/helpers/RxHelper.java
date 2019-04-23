package com.nandha.petsearchassignment.helpers;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxHelper {
  private static Observable.Transformer transformer;

  static {
    transformer = createTransformer();
  }

  @SuppressWarnings("unchecked")
  private static <T> Observable.Transformer<T, T> createTransformer() {
    return tObservable -> tObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @SuppressWarnings("unchecked")
  public static <T> Observable.Transformer<T, T> getTransformer() {
    return transformer;
  }
}
