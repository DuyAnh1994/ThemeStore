package ai.ftech.themestore

import ai.ftech.themestore.model.ItemsSearch
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularAdapter(
    private var listImageUrls: MutableList<ItemsSearch>,
    private var context: Context
) : RecyclerView.Adapter<PopularAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val viewPopular = LayoutInflater.from(context).inflate(R.layout.popular_item, parent, false)
        return ImageViewHolder(viewPopular)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var image = listImageUrls.get(position)

        holder.bindData(image)
    }

    override fun getItemCount(): Int {
        if(listImageUrls.size != null){
            return listImageUrls.size
        }
        else
            return 0
    }

    inner class ImageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private var ivPopularSearch : ImageView
        private var tvPopularSearch : TextView
        init {
            ivPopularSearch = itemView.findViewById(R.id.ivPopularSearch)
            tvPopularSearch = itemView.findViewById(R.id.tvPopularSearch)
        }

        fun bindData(itemsSearch: ItemsSearch){
            tvPopularSearch.text = itemsSearch.text

            Glide.with(context)
                .load(itemsSearch.urlImage)
                .into(ivPopularSearch)
        }

    }
}
