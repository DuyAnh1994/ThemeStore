package ai.ftech.themestore.home

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ImageViewHolder>() {

    private var listPostUrls: MutableList<Display> = mutableListOf()
    var iOnClickPost : IOnClickPost ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(listPostUrls[position])
    }

    override fun getItemCount(): Int {
        return listPostUrls.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listPostUrls: MutableList<Display>) {
        this.listPostUrls.clear()
        this.listPostUrls.addAll(listPostUrls)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var ivImage: ImageView
        private var ivImageSelect: ImageView
        private var requestOptions = RequestOptions()


        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)


            ivImage.setOnClickListener {
                val item = listPostUrls[absoluteAdapterPosition].post
                iOnClickPost?.onClickPost(item)
            }

            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))
        }

        fun onBind(display: Display) {
            if (display.post.isImage()) {

                Glide.with(itemView.context)
                    .load(display.post.url)
                    .apply(requestOptions)
                    .placeholder(R.drawable.ic_image)
                    .into(ivImage)

            } else {
                Glide.with(itemView.context)
                    .load(display.bitmap)
                    .apply(requestOptions)
                    .into(ivImage)
            }
        }

    }

    class Display(
         val post: Post,
         val bitmap : Bitmap?
        ){

    }

    interface IOnClickPost{
        fun onClickPost(post: Post)
    }
}


