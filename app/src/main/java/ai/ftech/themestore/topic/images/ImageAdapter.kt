package ai.ftech.themestore.topic.images

import ai.ftech.themestore.Key
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.DetailActivity
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(
    private val context: Context
): RecyclerView.Adapter<ImageAdapter.ImageWallpapersViewHolder>() {

    private val listImageUrl : MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageWallpapersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent , false)
    return ImageWallpapersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageWallpapersViewHolder, position: Int) {
        holder.bindData(listImageUrl[position])

        holder.ivImage.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(Key.KEY_DETAIL, listImageUrl[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listImageUrl.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listImageUrl : MutableList<Post>){
        this.listImageUrl.clear()
        this.listImageUrl.addAll(listImageUrl)
        notifyDataSetChanged()
    }

    class ImageWallpapersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage : ImageView
        private var ivImageSelect : ImageView
        var requestOptions = RequestOptions()

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))
        }

        fun bindData(post: Post){
            Glide.with(itemView.context)
                .load(post.url)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_image)
                .into(ivImage)
        }
    }
}
