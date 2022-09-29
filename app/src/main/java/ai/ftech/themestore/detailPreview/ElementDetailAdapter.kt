package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ElementDetailAdapter(
    private var imageDetail: Image,
    private var listMoreLikeThis : MutableList<ElementImageMore>,
    private var context : Context ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val IMAGE_DETAIL_TYPE = 0
        private const val LIST_MORE_LIKE_THIS = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == IMAGE_DETAIL_TYPE){
            val imageDetailView : View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.detail_image_item, parent, false)
            return ImageDetailViewHolder(imageDetailView)
        }

        val moreLikeThisView : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.detail_more_like_this_item, parent,false)
        return  MoreLikeThisViewHolder(moreLikeThisView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when(holder){
                is ImageDetailViewHolder -> holder.bindDataImageDetail(position)
                is MoreLikeThisViewHolder -> holder.bindDataMoreLikeThis(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> IMAGE_DETAIL_TYPE
            1 -> LIST_MORE_LIKE_THIS
            else -> 0
        }
    }

    inner class ImageDetailViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private val ivImage : ImageView
        private val civAvatar : CircleImageView
        private val tvAccountName : TextView
        private val tvFollowersDetail : TextView
        private val tvTitle: TextView
        private val tvContent : TextView
        private val civAvatarAccount : CircleImageView
        private val edtComment : EditText


        init {
            ivImage = itemView.findViewById(R.id.ivImageDetail)
            civAvatar = itemView.findViewById(R.id.civAvatar)
            tvAccountName = itemView.findViewById(R.id.tvAccountName)
            tvFollowersDetail = itemView.findViewById(R.id.tvFollowersDetail)
            tvTitle = itemView.findViewById(R.id.tvTitleContent)
            tvContent = itemView.findViewById(R.id.tvContent)
            civAvatarAccount = itemView.findViewById(R.id.civAvatarAccount)
            edtComment = itemView.findViewById(R.id.edtComment)
        }

        fun bindDataImageDetail(position: Int){
            // Bo tròn góc của ảnh
//            var requestOptions : RequestOptions = RequestOptions()
//            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(60))
//            Glide.with(context).load("https://i.pinimg.com/236x/3d/cc/61/3dcc61af39ec4e4a70e092ed73f12e83.jpg").apply(requestOptions).into(ivImage)
            Glide.with(context).load("https://i.pinimg.com/236x/3d/cc/61/3dcc61af39ec4e4a70e092ed73f12e83.jpg").into(ivImage)
            tvTitle.text = imageDetail.title
            tvContent.text = imageDetail.content

            Glide.with(context).load("https://i.pinimg.com/236x/0b/de/01/0bde01ce539cb60a18482a2bb3400108.jpg").into(civAvatar)
            tvAccountName.text = imageDetail.nameA
            tvFollowersDetail.text = imageDetail.follower

            Glide.with(context).load("https://i.pinimg.com/236x/e8/e4/7d/e8e47d682fa0fae69989606b01f11af8.jpg").into(civAvatarAccount)
        }
    }

    inner class MoreLikeThisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val rvMoreLikeThisDetail : RecyclerView
        private lateinit var adapter : MoreLikeThisAdapter


        init {
            rvMoreLikeThisDetail = itemView.findViewById(R.id.rvMoreLikeThisDetail)
        }

        fun bindDataMoreLikeThis(position: Int){
            var listUrlImageMore : MutableList<ElementImageMore> = ListElementImageMore.listElementImageMore()
            rvMoreLikeThisDetail.adapter = MoreLikeThisAdapter(listUrlImageMore, context)
            var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            var layoutManager = GridLayoutManager(context,2)
            rvMoreLikeThisDetail.layoutManager = layoutManager
        }
    }

}
