package com.example.mvibyme.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvibyme.R
import com.example.mvibyme.modelRequest.Result

class SlideshowRecyclerView(var topList: ArrayList<Result>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SlideshowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slideshow_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SlideshowViewHolder -> {
                holder.bindElements(topList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return topList.size
    }


    class SlideshowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val slideshowImage: ImageView = itemView.findViewById(R.id.slideshow_image)

        fun bindElements(topMovie: Result) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(itemView.context.getString(R.string.poster_url).plus(topMovie.poster_path))
                .into(slideshowImage)
        }
    }
}

