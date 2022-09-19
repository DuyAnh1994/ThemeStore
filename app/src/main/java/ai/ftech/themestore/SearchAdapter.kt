package ai.ftech.themestore

import ai.ftech.themestore.model.ItemsSearch
import ai.ftech.themestore.model.ItemsSearchHolder
import ai.ftech.themestore.model.TitleSearch
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchAdapter(
    private var listImageUrls: MutableList<ItemsSearch>,
    private var listTitle : MutableList<TitleSearch>,
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val image_type = 0
        private const val title_type = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(image_type == 0){
            val imageView : View = LayoutInflater.from(parent.context).inflate(R.layout.ideas_item, parent, false)
            return ImageViewHolder(imageView)
        }
        else{
            val titleView: View = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
            return TitleViewHolder(titleView)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var image = listImageUrls.get(position)
        val title = listTitle.get(position)
        holder.apply {
            when(holder){
                is TitleViewHolder -> holder.bindDataTitle(title)
                is ImageViewHolder -> holder.bindDataImage(image)
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
            0,5  -> title_type
            else -> image_type
        }
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      private  var ivIdeasSearch : ImageView
      private  var tvIdeasSearch :TextView

        init {
            ivIdeasSearch = itemView.findViewById(R.id.ivIdeasSearch)
            tvIdeasSearch = itemView.findViewById(R.id.tvIdeasSearch)
        }

        fun bindDataImage(itemsSearch: ItemsSearch){
            tvIdeasSearch.text = itemsSearch.text

            Glide.with(context)
                .load(itemsSearch.urlImage)
                .into(ivIdeasSearch)
        }
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvTitleSearch : TextView
        init {
            tvTitleSearch = itemView.findViewById(R.id.tvTitleSearch)
        }

        fun bindDataTitle(titleSearch: TitleSearch){
            tvTitleSearch.text = titleSearch.textSearch
        }
    }

}


