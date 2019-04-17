package com.nandha.petsearchassignment.movie.list;

import android.util.Log;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.MovieListResponse;
import rx.Observable;
import rx.Observer;
import rx.subscriptions.CompositeSubscription;

class MovieListPresenter extends MvpBasePresenter<MovieListView> {

  private MovieListView view;

  MovieListPresenter() {
  }

  void getData(AssignmentApi assignmentApi) {
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

  @Override public void attachView(@NonNull MovieListView view) {
    this.view = view;
  }

  @Override public void detachView() {

  }

  @Override public void destroy() {

  }
}
