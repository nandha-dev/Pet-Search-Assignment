package com.nandha.petsearchassignment.movie.list;

import android.util.Log;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.MovieListResponse;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

class MovieListPresenter {

  private AssignmentApi assignmentApi;
  private MovieListView view;

  MovieListPresenter(MovieListView view, AssignmentApi assignmentApi) {
    this.view = view;
    this.assignmentApi = assignmentApi;
  }

  void getMovieList() {
    final Observable<MovieListResponse> movieListResponseObservable =
        this.assignmentApi.getPopularMovies();
    CompositeSubscription compositeSubscription = new CompositeSubscription();
    compositeSubscription.add(movieListResponseObservable.subscribe(
        this::onNext, this::onError));
  }

  private void onNext(MovieListResponse movieListResponse) {
    view.showMovieList(movieListResponse.getMovies());
  }

  private void onError(Throwable throwable) {
    Log.e("TAG", "onError" + throwable.getMessage(), throwable);
  }
}
