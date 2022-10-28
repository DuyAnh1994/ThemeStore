package ai.ftech.themestore.topic.videos

import ai.ftech.themestore.Key
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.DetailActivity
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaMetadataRetriever
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class VideoAdapter(
    private var context: Context
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    private var listVideoUrl : MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.VideoViewHolder, position: Int) {

        holder.bindData(listVideoUrl[position])

        holder.ivImage.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(Key.KEY_DETAIL, listVideoUrl[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listVideoUrl.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listVideoUrl : MutableList<Post>){
        this.listVideoUrl.clear()
        this.listVideoUrl.addAll(listVideoUrl)
        notifyDataSetChanged()
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage : ImageView
        private var ivImageSelect : ImageView
        var requestOptions = RequestOptions()
        val retriever = MediaMetadataRetriever()


        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))
        }

        fun bindData(post: Post){
            // lấy thumbnail của video
            retriever.setDataSource(post.url, HashMap())
            val image = retriever.getFrameAtTime(2000000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
            Glide.with(context)
                .load(image)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_image)
                .into(ivImage)
        }
    }
}
