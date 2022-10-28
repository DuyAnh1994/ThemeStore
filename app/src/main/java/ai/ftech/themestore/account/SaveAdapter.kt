package ai.ftech.themestore.account

import ai.ftech.themestore.Key
import ai.ftech.themestore.R
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

class SaveAdapter(
    private var context: Context
) : RecyclerView.Adapter<SaveAdapter.ItemSavedViewHolder>() {

    private val listSave: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSavedViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ItemSavedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listSave.size
    }

    override fun onBindViewHolder(holder: ItemSavedViewHolder, position: Int) {
        holder.bindData(listSave[position])
        holder.ivImage.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(Key.KEY_DETAIL, listSave[position])
            context.startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listSave: MutableList<Post>) {
        this.listSave.clear()
        this.listSave.addAll(listSave)
        notifyDataSetChanged()
    }

    class ItemSavedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView
        var requestOptions = RequestOptions()
        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        }
        fun bindData(post: Post){
            if (post.isImage()) {
                Glide.with(itemView.context)
                    .load(post.url)
                    .apply(requestOptions)
                    .into(ivImage)
            } else {
                val retriever = MediaMetadataRetriever()
                retriever.setDataSource(post.url, HashMap())
                val image = retriever.getFrameAtTime(2000000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
                Glide.with(itemView.context)
                    .load(image)
                    .apply(requestOptions)
                    .placeholder(R.drawable.ic_image)
                    .into(ivImage)
            }
        }
    }

}

