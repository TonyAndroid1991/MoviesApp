package com.example.mvibyme.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvibyme.R
import com.example.mvibyme.activities.MovieDetailsActivity
import com.example.mvibyme.modelRequest.Result
import java.io.Serializable

class MainRecyclerAdapter(private val results: ArrayList<Result>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MoviesViewholder(LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder) {
           is MoviesViewholder -> {
               holder.bindElements(results[position])

               holder.itemView.setOnClickListener{
                   val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
                   intent.putExtra("Result", results[position] as Serializable)
                   context.startActivity(intent)
               }
           }
       }
    }

    class MoviesViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        private val movieDate: TextView = itemView.findViewById(R.id.movie_date)
        private val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)

        fun bindElements(result: Result) {

            movieTitle.text = result.title
            movieDate.text = result.release_date

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(itemView.context.getString(R.string.poster_url).plus(result.poster_path))
                .into(moviePoster)
        }
    }
}