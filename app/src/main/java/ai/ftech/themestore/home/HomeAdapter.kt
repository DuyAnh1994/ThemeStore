package ai.ftech.themestore.home

import ai.ftech.themestore.R
import ai.ftech.themestore.TestActivity
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

class HomeAdapter(
    private var context: Context
) : RecyclerView.Adapter<HomeAdapter.ImageViewHolder>() {

    private var listPostUrls: MutableList<Post> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        if (listPostUrls[position].isImage()) {
            Glide.with(context)
                .load(listPostUrls[position].url)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_image)
                .into(holder.ivImage)
        } else { // lấy thumbnail của video
            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(listPostUrls[position].url, HashMap())
            val image = retriever.getFrameAtTime(2000000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
            Glide.with(context)
                .load(image)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_image)
                .into(holder.ivImage)
        }

        holder.ivImage.setOnClickListener { // click vào bất kì 1 ảnh thì sẽ cho ra activity chi tiết của ảnh đó, truyền dữ liệu là obj
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("thomnt", listPostUrls[position])
            context.startActivity(intent)
        }

//        holder.ivImage.setOnClickListener {
//            if(listPostUrls[position].isImage()){
//                val intent = Intent(context, DetailActivity::class.java)
//                intent.putExtra("thomnt", listPostUrls[position])
//                context.startActivity(intent)
//            }
//            else{
//                val intent1 = Intent(context, TestActivity::class.java)
//                intent1.putExtra("thomnt", listPostUrls[position])
//                context.startActivity(intent1)
//            }
//
//        }

    }

    override fun getItemCount(): Int {
        return listPostUrls.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listPostUrls: MutableList<Post>) {
        this.listPostUrls.clear()
        this.listPostUrls.addAll(listPostUrls)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        private var ivImageSelect: ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)
        }
    }
}

