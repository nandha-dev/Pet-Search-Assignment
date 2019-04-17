package com.nandha.petsearchassignment.movie.details;

import android.util.Log;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.Movie;
import rx.Observable;
import rx.Observer;
import rx.subscriptions.CompositeSubscription;

class MovieDetailsPresenter extends MvpBasePresenter<MovieDetailsView> {

  private MovieDetailsView view;

  @Override public void attachView(@NonNull MovieDetailsView view) {
    this.view = view;
  }

  void getMovieDetails(AssignmentApi assignmentApi, int movieId) {
    final Observable<Movie> movieListResponseObservable =
        assignmentApi.getMovieDetails(movieId);
    CompositeSubscription compositeSubscription = new CompositeSubscription();
    compositeSubscription.add(movieListResponseObservable.subscribe(
        new Observer<Movie>() {
          @Override public void onCompleted() {
            Log.d("TAG", "onCompleted");
          }

          @Override public void onError(Throwable e) {
            Log.e("TAG", "onError" + e.toString(), e);
          }

          @Override public void onNext(Movie movie) {
            Log.i("TAG", "onNext");
            view.updateDetails(movie);
          }
        }));
  }
}
