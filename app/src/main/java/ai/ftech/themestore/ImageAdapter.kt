package ai.ftech.themestore

import ai.ftech.themestore.fragment.HomeFragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(
    private var listImageUrls: MutableList<String>,
    private var listContext: HomeFragment
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var image = listImageUrls.get(position)
        if (image == null) {
            return
        }

        Glide.with(listContext)
            .load(listImageUrls[position])
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        if (listImageUrls != null) {
            return listImageUrls.size
        } else
            return 0
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        private var ibImage: ImageButton

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ibImage = itemView.findViewById(R.id.ibSelect)
        }
    }
}
