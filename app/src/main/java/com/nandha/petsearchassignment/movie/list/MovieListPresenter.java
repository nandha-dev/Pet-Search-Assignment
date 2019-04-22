package com.nandha.petsearchassignment.movie.list;

import android.util.Log;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.MovieListResponse;
import rx.Observable;
import rx.Observer;
import rx.subscriptions.CompositeSubscription;

class MovieListPresenter {

  private MovieListView view;

  MovieListPresenter(MovieListView view) {
    this.view = view;
  }

  void getMovieList(AssignmentApi assignmentApi) {
    final Observable<MovieListResponse> movieListResponseObservable =
        assignmentApi.getPopularMovies();
    CompositeSubscription compositeSubscription = new CompositeSubscription();
    compositeSubscription.add(movieListResponseObservable.subscribe(
        new Observer<MovieListResponse>() {
          @Override public void onCompleted() {
            Log.d("TAG", "onCompleted");
          }

          @Override public void onError(Throwable e) {
            Log.e("TAG", "onError" + e.toString(), e);
          }

          @Override public void onNext(MovieListResponse movieListResponse) {
            Log.i("TAG", "onNext");
            view.showMovieList(movieListResponse.getMovies());
          }
        }));
  }
}
