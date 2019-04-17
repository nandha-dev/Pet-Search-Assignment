package com.nandha.petsearchassignment.movie.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.nandha.petsearchassignment.AppConstants;
import com.nandha.petsearchassignment.R;
import com.nandha.petsearchassignment.helpers.StringHelper;
import com.nandha.petsearchassignment.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

  private List<Movie> movies = new ArrayList<>();
  private OnMovieSelectionListener onMovieSelectionListener;

  void setListener(OnMovieSelectionListener onMovieSelectionListener) {
    this.onMovieSelectionListener = onMovieSelectionListener;
  }

  void setData(List<Movie> movies) {
    this.movies = movies;
    notifyDataSetChanged();
  }

  @NonNull @Override
  public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    final MovieListViewHolder movieListViewHolder;
    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_movie_layout, viewGroup, false);
    movieListViewHolder = new MovieListViewHolder(view);
    movieListViewHolder.rootView.setOnClickListener(v -> onMovieSelectionListener.onMovieSelected(
        movies.get(movieListViewHolder.getAdapterPosition())));
    return movieListViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull MovieListViewHolder movieListViewHolder, int position) {
    Movie movie = movies.get(position);

    movieListViewHolder.titleTextView.setText(movie.getTitle());
    movieListViewHolder.overviewTextView.setText(movie.getOverview());
    movieListViewHolder.ratingTextView.setText(String.valueOf(movie.getRating()));
    movieListViewHolder.releaseDateTextView.setText(
        StringHelper.dateToReleaseDate(movie.getRelease_date()));
    movieListViewHolder.languageTextView.setText(movie.getLanguage());

    Glide.with(movieListViewHolder.rootView.getContext())
        .load(AppConstants.BASE_IMAGE_URL + movie.getPosterPath())
        .into(movieListViewHolder.posterImageView);
  }

  @Override public int getItemCount() {
    return movies == null ? 0 : movies.size();
  }

  interface OnMovieSelectionListener {
    void onMovieSelected(Movie movie);
  }

  class MovieListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.poster_imageView) ImageView posterImageView;
    @BindView(R.id.title_textView) TextView titleTextView;
    @BindView(R.id.overview_textView) TextView overviewTextView;
    @BindView(R.id.rating_textView) TextView ratingTextView;
    @BindView(R.id.releaseDate_textView) TextView releaseDateTextView;
    @BindView(R.id.language_textView) TextView languageTextView;
    View rootView;

    MovieListViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      rootView = itemView;
    }
  }
}
