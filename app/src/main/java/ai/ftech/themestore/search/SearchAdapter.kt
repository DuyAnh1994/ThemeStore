package ai.ftech.themestore.search

import ai.ftech.themestore.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchAdapter(
    private var listTitle : MutableList<String>,
    private var listImageUrls: MutableList<ImageSearch>,
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        private const val image_type = 0
        private const val title_type = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == image_type){
            val imageView : View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.image_search_item, parent, false)
            return ImageViewHolder(imageView)
        }
        else{
            val titleView: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.title_search_item, parent, false)
            return TitleViewHolder(titleView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when(holder){
                is TitleViewHolder -> holder.bindDataTitle(position)
                is ImageViewHolder -> holder.bindDataImage(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listImageUrls.size + listTitle.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0, 9 -> title_type
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

        fun bindDataImage(position: Int){
            if(position<9){
                tvIdeasSearch.text = listImageUrls.get(position-1).text

                Glide.with(context)
                    .load(listImageUrls.get(position-1).urlImage).fitCenter()
                    .into(ivIdeasSearch)
            }
            else if(position>9){
                tvIdeasSearch.text = listImageUrls.get(position-2).text

                Glide.with(context)
                    .load(listImageUrls.get(position-2).urlImage).fitCenter()
                    .into(ivIdeasSearch)
            }
        }
    }

    inner class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvTitleSearch : TextView
        init {
            tvTitleSearch = itemView.findViewById(R.id.tvTitleSearch)
        }

        fun bindDataTitle(position: Int){
            if(position==0){
                tvTitleSearch.text = listTitle.get(position)
            }
            else if(position==9){
                tvTitleSearch.text = listTitle.get(position-8)
            }

        }
    }
}



