package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class MoreLikeThisAdapter(
    private var listUrlImageMore : MutableList<Image>,
    private var context : Context
) : RecyclerView.Adapter<MoreLikeThisAdapter.MoreLikeThisViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreLikeThisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_like_this_item, parent, false)
        return MoreLikeThisViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreLikeThisViewHolder, position: Int) {
        val itemMore = listUrlImageMore[position]
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))
        Glide.with(context).load(itemMore.urlImage).apply(requestOptions).into(holder.ivImageMore)
    }


    override fun getItemCount(): Int {
        return listUrlImageMore.size
    }

    class MoreLikeThisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivImageMore : ImageView
        private var tvTitleMore : TextView
        private var ivImageSelectMore : ImageView

        init {
            ivImageMore = itemView.findViewById(R.id.ivImageMore)
            tvTitleMore = itemView.findViewById(R.id.tvTitleMore)
            ivImageSelectMore = itemView.findViewById(R.id.ivImageSelectMore)
        }
    }
}
