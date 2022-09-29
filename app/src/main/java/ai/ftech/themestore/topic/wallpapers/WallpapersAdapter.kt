package ai.ftech.themestore.topic.wallpapers

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Image
import ai.ftech.themestore.home.ImageH
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WallpapersAdapter(
    private val listImageWallpapersUrls: MutableList<ImageH>,
    private val listContext: Context
) : RecyclerView.Adapter<WallpapersAdapter.ImageWallpapersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageWallpapersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wallpapers_item, parent , false)
    return ImageWallpapersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageWallpapersViewHolder, position: Int) {
        var image = listImageWallpapersUrls.get(position)
        if(image==null)
            return

        Glide.with(listContext).load(listImageWallpapersUrls[position]).into(holder.ivImageW)

    }

    override fun getItemCount(): Int {
        if(listImageWallpapersUrls.size != null)
            return listImageWallpapersUrls.size
        return 0
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
