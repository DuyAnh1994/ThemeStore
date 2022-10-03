package ai.ftech.themestore.home

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.ElementDetailActivity
import ai.ftech.themestore.detailPreview.Image
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
    private var context: Context
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val listImageUrls: MutableList<Image> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        Glide.with(context)
            .load(listImageUrls[position].urlImage)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImage)

        holder.ivImage.setOnClickListener {
            val intent = Intent(context, ElementDetailActivity::class.java)
            intent.putExtra("thomnt",listImageUrls[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listImageUrls.size
    }

    fun resetData(listImageUrls: MutableList<Image>){
        this.listImageUrls.clear()
        this.listImageUrls.addAll(listImageUrls)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        private var ivImageSelect: ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
        }
    }}

