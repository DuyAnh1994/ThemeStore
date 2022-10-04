package ai.ftech.themestore.topic.wallpapers

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Image
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

class WallpapersAdapter(
    private val listImageWallpapersUrls: MutableList<Image>,
    private val context: Context
) : RecyclerView.Adapter<WallpapersAdapter.ImageWallpapersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageWallpapersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wallpapers_item, parent , false)
    return ImageWallpapersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageWallpapersViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        Glide.with(context)
            .load(listImageWallpapersUrls[position].urlImage)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImageW)
    }

    override fun getItemCount(): Int {
        return listImageWallpapersUrls.size
    }

    class ImageWallpapersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImageW : ImageView
        private var ivImageSelectW : ImageView

        init {
            ivImageW = itemView.findViewById(R.id.ivImageW)
            ivImageSelectW = itemView.findViewById(R.id.ivImageSelectW)
        }
    }
}
