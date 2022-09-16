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

class SearchAdapter(
    private var listImageUrls: MutableList<ItemsSearch>,
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val ideas_type = 0
        private const val popular_type = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 0){
            val viewIdea : View = LayoutInflater.from(parent.context).inflate(R.layout.ideas_item, parent, false)
            return ImageIdeasViewHolder(viewIdea)
        }
        else{
            val viewPopular: View = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
            return ImagePopularViewHolder(viewPopular)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var image = listImageUrls.get(position)
        holder.apply {
            when(holder){
                is ImageIdeasViewHolder -> holder.bindDataIdeas(image)
                is ImagePopularViewHolder -> holder.bindDataPopular(image)
            }
        }
    }

    override fun getItemCount(): Int {
        if(listImageUrls != null){
            return listImageUrls.size
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            in 1..8 -> ideas_type
            else -> popular_type
        }
    }

    inner class ImageIdeasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private  var ivIdeasSearch : ImageView
      private  var tvIdeasSearch :TextView

        init {
            ivIdeasSearch = itemView.findViewById(R.id.ivIdeasSearch)
            tvIdeasSearch = itemView.findViewById(R.id.tvIdeasSearch)
        }

        fun bindDataIdeas(itemsSearch: ItemsSearch){
            tvIdeasSearch.text = itemsSearch.text

            Glide.with(context)
                .load(itemsSearch.urlImage)
                .into(ivIdeasSearch)
        }
    }

    inner class ImagePopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var ivPopularSearch : ImageView
        private var tvPopularSearch : TextView
        init {
            ivPopularSearch = itemView.findViewById(R.id.ivPopularSearch)
            tvPopularSearch = itemView.findViewById(R.id.tvPopularSearch)
        }

        fun bindDataPopular(itemsSearch: ItemsSearch){
            tvPopularSearch.text = itemsSearch.text

            Glide.with(context)
                .load(itemsSearch.urlImage)
                .into(ivPopularSearch)
        }
    }
}
