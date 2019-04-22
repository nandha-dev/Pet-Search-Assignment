package com.nandha.petsearchassignment.movie.list;

import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nandha.petsearchassignment.Assignment;
import com.nandha.petsearchassignment.R;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.model.Movie;
import com.nandha.petsearchassignment.movie.details.MovieDetailsActivity;
import java.util.List;
import javax.inject.Inject;

public class MovieListActivity extends AppCompatActivity
    implements MovieListView {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.movieList_recyclerView) RecyclerView movieListRecyclerView;
  @Inject MovieListAdapter movieListAdapter;
  @Inject AssignmentApi assignmentApi;

  private MovieListComponent movieListComponent;
  private MovieListPresenter movieListPresenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_list);
    ButterKnife.bind(this);
    getActivityComponent().injectActivity(this);

    setUpToolBar();
    initializePresenter();
    initializeRecyclerView();

    movieListPresenter.getMovieList(assignmentApi);
  }

  private void initializePresenter() {
    movieListPresenter = new MovieListPresenter(this);
  }

  private void setUpToolBar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      if (getSupportActionBar() != null) {
        getSupportActionBar().setTitle(R.string.title);
      }
    }
  }

  private void initializeRecyclerView() {
    movieListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    movieListAdapter.setListener(movie ->
        startActivity(MovieDetailsActivity.getActivityIntent(this, movie.getId(), movie.getTitle()))
    );
    movieListRecyclerView.setAdapter(movieListAdapter);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.movie_list_menu, menu);
    return true;
  }

  private MovieListComponent getActivityComponent() {
    if (movieListComponent == null) {
      movieListComponent = DaggerMovieListComponent.builder()
          .applicationComponent(((Assignment) getApplication()).getApplicationComponent())
          .movieListModule(new MovieListModule(this))
          .build();
    }
    return movieListComponent;
  }

  @Override public void showMovieList(List<Movie> Movies) {
    movieListAdapter.setData(Movies);
  }
}
