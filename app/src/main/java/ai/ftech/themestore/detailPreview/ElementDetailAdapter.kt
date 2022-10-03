package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ElementDetailAdapter(
    private val imageDetail: Image,
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val IMAGE_DETAIL_TYPE = 0
        private const val LIST_MORE_LIKE_THIS = 1
        private const val TAG = "ElementDetailAdapter"
    }

    private val listMoreLikeThis: MutableList<Image> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == IMAGE_DETAIL_TYPE) {
            val imageDetailView: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.detail_image_item, parent, false)
            return ImageDetailViewHolder(imageDetailView)
        }

        val moreLikeThisView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.more_like_this_item, parent, false)
        return MoreLikeThisViewHolder(moreLikeThisView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when (holder) {
                is ImageDetailViewHolder -> holder.bindDataImageDetail()
                is MoreLikeThisViewHolder -> {
                    if (position > 0) {
                        val elementImageMore = listMoreLikeThis[position-1]
                        holder.bindDataMoreLikeThis(elementImageMore)
                        
                        if (elementImageMore.firstItem) {
                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_corner_top)
                        }
                        else if (elementImageMore.lastItem) {
                            Log.d(TAG, "onBindViewHolder: ")
                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_corner_bottom)
                        }
                        else{
                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_normal)
                        }

                        holder.ivImageMore.setOnClickListener {
                            val intent = Intent(context, ElementDetailActivity::class.java)
                            intent.putExtra("thomnt", elementImageMore)
                            context.startActivity(intent)
                        }

                    }
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return 1 + listMoreLikeThis.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> IMAGE_DETAIL_TYPE
            else -> LIST_MORE_LIKE_THIS
        }
    }

    inner class ImageDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivImage: ImageView
        private val civAvatar: CircleImageView
        private val tvAccountName: TextView
        private val tvFollowersDetail: TextView
        private val tvTitle: TextView
        private val tvContent: TextView
        private val civAvatarAccount: CircleImageView
        private val edtComment: EditText


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

        fun bindDataImageDetail() {
            Glide.with(context).load(imageDetail.urlImage).into(ivImage)
            tvTitle.text = imageDetail.title
            tvContent.text = imageDetail.content

            Glide.with(context).load(imageDetail.urlAvatar).into(civAvatar)
            tvAccountName.text = imageDetail.nameA
            tvFollowersDetail.text = imageDetail.follower

            Glide.with(context).load(imageDetail.urlImage).into(civAvatarAccount)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listMoreLikeThis: List<Image>) {
        this.listMoreLikeThis.clear()
        this.listMoreLikeThis.addAll(listMoreLikeThis)
        notifyDataSetChanged()
    }

    inner class MoreLikeThisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImageMore: ImageView
        private var tvTitleMore: TextView
        private var ivImageSelectMore: ImageView
        var llImageDetail: LinearLayout

        init {
            ivImageMore = itemView.findViewById(R.id.ivImageMore)
            tvTitleMore = itemView.findViewById(R.id.tvTitleMore)
            ivImageSelectMore = itemView.findViewById(R.id.ivImageSelectMore)
            llImageDetail = itemView.findViewById(R.id.llImageDetail)
        }

        fun bindDataMoreLikeThis(elementImageMore: Image ) {
            Glide.with(context).load(elementImageMore.urlImage).into(ivImageMore)
            tvTitleMore.text = elementImageMore.title
        }
    }

}

