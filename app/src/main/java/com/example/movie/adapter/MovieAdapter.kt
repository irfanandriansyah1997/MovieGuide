package com.example.movie.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.model.MovieModel
import com.example.movie.R
import kotlinx.android.synthetic.main.recycle_new_movie_card.view.*

class NewMovieAdapter(
    private val movies: List<MovieModel>
) : RecyclerView.Adapter<MovieHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(
                    R.layout.recycle_new_movie_card,
                    viewGroup,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bindHero(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}

class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvHeroName = view.new_movie_card_title

    fun bindHero(movie: MovieModel) {
        tvHeroName.text = movie.title
    }
}