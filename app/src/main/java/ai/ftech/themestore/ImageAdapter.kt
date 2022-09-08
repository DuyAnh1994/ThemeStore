package ai.ftech.themestore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(private var listImageUrls: MutableList<String>,
                   private var listContext : Context)
    : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageViewHolder, position: Int) {
        var image = listImageUrls.get(position)
        if(image == null){
            return
        }
//        holder.ivImage.setImageResource(image.RESOURCE_IMAGE_ID)
//        holder.ibImage.setImageResource(image.IMAGE_BUTTON_SELECT)
        Glide.with(listContext)
            .load(listImageUrls[position])
            .override(800,800)
            .into(holder.ivImage)
    }

    override fun getItemCount(): Int {
        if(listImageUrls != null){
            return listImageUrls.size
        }
        else
            return 0
    }

    class ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var ivImage : ImageView
        var ibImage : ImageButton
        init {
            ivImage = itemView.findViewById(R.id.ivImage)
                 ibImage = itemView.findViewById(R.id.ibSelect)
        }
    }
}