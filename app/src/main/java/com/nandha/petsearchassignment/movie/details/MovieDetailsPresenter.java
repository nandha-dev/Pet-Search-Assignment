package com.nandha.petsearchassignment.movie.details;

import android.util.Log;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.Movie;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

class MovieDetailsPresenter {

  private MovieDetailsView view;
  private AssignmentApi assignmentApi;

  MovieDetailsPresenter(MovieDetailsView view, AssignmentApi assignmentApi) {
    this.view = view;
    this.assignmentApi = assignmentApi;
  }

  void getMovieDetails(int movieId) {
    final Observable<Movie> movieListResponseObservable =
        assignmentApi.getMovieDetails(movieId);
    CompositeSubscription compositeSubscription = new CompositeSubscription();
    compositeSubscription.add(movieListResponseObservable.subscribe(this::onNext, this::onError));
  }

  private void onNext(Movie movie) {
    view.updateDetails(movie);
  }

  private void onError(Throwable throwable) {
    Log.e("TAG", "onError" + throwable.getMessage(), throwable);
  }
}
