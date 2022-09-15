package ai.ftech.themestore

import ai.ftech.themestore.model.ItemsSearch
import ai.ftech.themestore.model.ItemsSearchHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class IdeasAdapter(
    private var listImageUrls: MutableList<ItemsSearch>,
    private var context: Context
) : RecyclerView.Adapter<IdeasAdapter.ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val viewIdea : View = LayoutInflater.from(parent.context).inflate(R.layout.ideas_item, parent, false)
        return ImageViewHolder(viewIdea)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var image = listImageUrls.get(position)

        holder.bindData(image)

    }

    override fun getItemCount(): Int {
        if(listImageUrls != null){
            return listImageUrls.size
        }
        return 0
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private  var ivIdeasSearch : ImageView
      private  var tvIdeasSearch :TextView

        init {
            ivIdeasSearch = itemView.findViewById(R.id.ivIdeasSearch)
            tvIdeasSearch = itemView.findViewById(R.id.tvIdeasSearch)
        }

        fun bindData(itemsSearch: ItemsSearch){
            tvIdeasSearch.text = itemsSearch.text

            Glide.with(context)
                .load(itemsSearch.urlImage)
                .into(ivIdeasSearch)
        }
    }

}
