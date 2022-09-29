package ai.ftech.themestore.home

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

class ImageAdapter(
    private var listImageUrls: MutableList<ImageH>,
    private var context: Context
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var requestOptions = RequestOptions().override(600, 200)
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(60))

        Glide.with(context)
            .load(listImageUrls[position])
            .placeholder(R.drawable.ic_image)
            .apply(requestOptions)
            .into(holder.ivImage)

        //  apply(new RequestOptions().override(600, 200))
//        Glide.with(context).load(listImageUrls[position]).into(holder.ivImage)

    }

    override fun getItemCount(): Int {
        return listImageUrls.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        private var ivImageSelect: ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
        }
    }
}
