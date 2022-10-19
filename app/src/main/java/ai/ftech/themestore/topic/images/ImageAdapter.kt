package ai.ftech.themestore.topic.images

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.content.Context
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
    private val listImageUrls: MutableList<Post>,
    private val context: Context
) : RecyclerView.Adapter<ImageAdapter.ImageWallpapersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageWallpapersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent , false)
    return ImageWallpapersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageWallpapersViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        Glide.with(context)
            .load(listImageUrls[position].url)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        return listImageUrls.size
    }

    class ImageWallpapersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage : ImageView
        private var ivImageSelect : ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
        }
    }
}
