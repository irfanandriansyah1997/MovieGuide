package com.example.movieguide.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

import com.example.movieguide.R;
import com.example.movieguide.interfaces.MoviesListingView;
import com.example.movieguide.model.Movie;
import com.example.movieguide.module.APIModules;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;
    private MoviesListingView view;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        ImageView poster;

        @BindView(R.id.movie_name)
        TextView name;

        @BindView(R.id.movie_rating)
        TextView rating;

        @BindView(R.id.movie_date)
        TextView date;

        @BindView(R.id.movie_card)
        CardView card;

        public Movie movie;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            MoviesListingAdapter.this.view.onMovieClicked(movie);
        }
    }

    public MoviesListingAdapter(List<Movie> movies, MoviesListingView moviesView) {
        this.movies = movies;
        view = moviesView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.card.setOnClickListener(holder);
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());
        holder.rating.setText(Double.toString(holder.movie.getVoteAverage()));
        holder.date.setText(holder.movie.getReleaseDate());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);

        Glide.with(context)
                .asBitmap()
                .load(APIModules.getPosterPath(holder.movie.getPosterPath()))
                .apply(options)
                .into(new BitmapImageViewTarget(holder.poster) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        super.onResourceReady(bitmap, transition);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}

