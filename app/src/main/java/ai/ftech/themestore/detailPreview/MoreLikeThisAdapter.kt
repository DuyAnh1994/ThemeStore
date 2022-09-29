package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import ai.ftech.themestore.home.ImageHome
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class MoreLikeThisAdapter(
    private var listUrlImageMore : MutableList<ElementImageMore>,
    private var context : Context
) : RecyclerView.Adapter<MoreLikeThisAdapter.MoreLikeThisViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreLikeThisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_like_this_item, parent, false)
        return MoreLikeThisViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreLikeThisViewHolder, position: Int) {
        val itemMore = listUrlImageMore.get(position)
        var requestOptions : RequestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(60))
        Glide.with(context).load(itemMore.url).apply(requestOptions).into(holder.ivImageMore)

    }

    override fun getItemCount(): Int {
        return listUrlImageMore.size
    }

    class MoreLikeThisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivImageMore : ImageView
        private var ivImageSelectMore : ImageView

        init {
            ivImageMore = itemView.findViewById(R.id.ivImageMore)
            ivImageSelectMore = itemView.findViewById(R.id.ivImageSelectMore)
        }
    }
}
