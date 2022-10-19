package ai.ftech.themestore.topic.videos

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class VideoAdapter(
    private val context: Context
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    companion object{
        private const val TAG = "VideoAdapter"
    }

    private val listVideoUrl : MutableList<String> = mutableListOf(
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4",
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.VideoViewHolder, position: Int) {
    //    var requestOptions = RequestOptions()
 //       requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        Glide.with(context)
            .load(listVideoUrl[position])
  //          .apply(requestOptions)
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImage)

    }

    override fun getItemCount(): Int {
        return listVideoUrl.size
    }

    class VideoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var ivImage : ImageView
        private var ivImageSelect : ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
        }
    }
}
