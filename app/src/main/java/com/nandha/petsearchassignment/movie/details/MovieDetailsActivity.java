package com.nandha.petsearchassignment.movie.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.nandha.petsearchassignment.AppConstants;
import com.nandha.petsearchassignment.Assignment;
import com.nandha.petsearchassignment.R;
import com.nandha.petsearchassignment.api.AssignmentApi;
import com.nandha.petsearchassignment.helpers.StringHelper;
import com.nandha.petsearchassignment.model.Movie;
import javax.inject.Inject;

public class MovieDetailsActivity extends AppCompatActivity
    implements MovieDetailsView {

  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.backdrop_imageView) ImageView backDropImageView;
  @BindView(R.id.overview_textView) TextView overViewTextView;
  @BindView(R.id.duration_textView) TextView durationTextView;
  @BindView(R.id.releaseDate_textView) TextView releaseDateTextView;
  @BindView(R.id.rating_textView) TextView ratingTextView;
  @BindView(R.id.genre_textView) TextView genreTextView;
  @BindView(R.id.language_textView) TextView languageTextView;
  @BindView(R.id.budget_textView) TextView budgetTextView;
  @BindView(R.id.revenue_textView) TextView revenueTextView;

  @Inject AssignmentApi assignmentApi;
  @Inject MovieDetailsPresenter movieDetailsPresenter;

  private int movieId;
  private String movieTitle;
  private MovieDetailsComponent movieDetailsComponent;

  public static Intent getActivityIntent(Context context, int movieId, String title) {
    Intent intent = new Intent(context, MovieDetailsActivity.class);
    intent.putExtra(AppConstants.BUNDLE_KEY_MOVIE_ID, movieId);
    intent.putExtra(AppConstants.BUNDLE_KEY_MOVIE_NAME, title);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_details);
    ButterKnife.bind(this);

    getIntentData();
    setHomeAsUp();
    getActivityComponent().injectActivity(this);

    if (movieId == 0) {
      finish();
    }
    movieDetailsPresenter.getMovieDetails(movieId);
  }

  private void setHomeAsUp() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      if (getSupportActionBar() != null) {
        getSupportActionBar().setTitle(movieTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }
    }
  }

  private void getIntentData() {
    movieId = getIntent().getIntExtra(AppConstants.BUNDLE_KEY_MOVIE_ID, 0);
    movieTitle = getIntent().getStringExtra(AppConstants.BUNDLE_KEY_MOVIE_NAME);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public MovieDetailsComponent getActivityComponent() {
    if (movieDetailsComponent == null) {
      movieDetailsComponent = DaggerMovieDetailsComponent.builder()
          .applicationComponent(((Assignment) getApplication()).getApplicationComponent())
          .movieDetailsModule(new MovieDetailsModule(this))
          .build();
    }
    return movieDetailsComponent;
  }

  @Override public void updateDetails(Movie movie) {

    Glide.with(getApplicationContext())
        .load(AppConstants.BASE_IMAGE_URL + movie.getBackdrop_path())
        .into(backDropImageView);

    overViewTextView.setText(movie.getOverview());
    durationTextView.setText(getString(R.string.duration, movie.getRuntime()));
    releaseDateTextView.setText(
        StringHelper.dateToReleaseDate(movie.getRelease_date()));
    ratingTextView.setText(String.valueOf(movie.getRating()));
    languageTextView.setText(movie.getLanguage());
    genreTextView.setText(StringHelper.genreListToString(movie.getGenreList()));
    budgetTextView.setText(StringHelper.intToMillion(movie.getBudget()));
    revenueTextView.setText(StringHelper.intToMillion(movie.getRevenue()));
  }
}
