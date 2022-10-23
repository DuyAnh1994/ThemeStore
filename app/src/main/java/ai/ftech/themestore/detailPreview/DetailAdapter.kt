package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView

class DetailAdapter(
    private val postDetail: Post,
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val POST_DETAIL_TYPE = 0
        private const val LIST_MORE_LIKE_THIS = 1
    }

    private val listMoreLikeThis: MutableList<Post> = mutableListOf()
    private var mPlayer: SimpleExoPlayer? = null
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        sharedPreferences = context.getSharedPreferences("SaveData", AppCompatActivity.MODE_PRIVATE)

        if (viewType == POST_DETAIL_TYPE) {
            val imageDetailView: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.detail_item, parent, false)
            return ImageDetailViewHolder(imageDetailView)
        }
        val moreLikeThisView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.more_like_this_item, parent, false)
        return MoreLikeThisViewHolder(moreLikeThisView)
    }

    @SuppressLint("CommitPrefEdits")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.apply {
            when (holder) {
                is ImageDetailViewHolder -> {
                    holder.bindDataImageDetail()

                    holder.btAccessDetail.setOnClickListener {
                        val uri = Uri.parse(Post().urlAccess)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    }

                    holder.btShareDetail.setOnClickListener {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://i.pinimg.com/236x/3c/d4/90/3cd490db9071e1aae2114e28929b51e5.jpg")
                        shareIntent.setType("text/plain")
                        shareIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                        context.startActivity(shareIntent)
                    }

                    holder.ivBack.setOnClickListener { // click vào back trên appbar thì nó sẽ xóa màn hiện tại và trả về màn trước đó
                        (context as Activity).finish()
                    }
//                    holder.ivSelect.setOnClickListener(object : View.OnClickListener{
//                        override fun onClick(v: View?) {
//                            val activity : AppCompatActivity = v?.context as AppCompatActivity
//                            val bottomSheetDialogFragment = BottomSheetDialogFragment()
//                            activity.supportFragmentManager.beginTransaction().replace(R.id.llElementDetail, bottomSheetDialogFragment).addToBackStack(null).commit()
//                        }
//                    })

                    holder.ivSelect.setOnClickListener {
                        showBottomSheetDialog()
                    }

                    holder.edtComment.setOnClickListener {
                        showBottomSheetDialogComment()
                    }

                    holder.btSaveDetail.setOnClickListener {
                        Toast.makeText(context, "Đã lưu", Toast.LENGTH_SHORT).show()
                        val editor : SharedPreferences.Editor = sharedPreferences.edit()
                        val post : Post = Post()
                        val gson : Gson = Gson()
                        val json : String? = gson.toJson(post)
                        editor.putString("save", json)
                        editor.apply()
                    }

                }
                is MoreLikeThisViewHolder -> {
                    if (position > 0) {
                        val elementImageMore = listMoreLikeThis[position - 1]
                        holder.bindDataMoreLikeThis(elementImageMore)

//                        if (elementImageMore.firstItem) {
//                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_corner_top)
//                        }
//                        else if (elementImageMore.lastItem) {
//                            Log.d(TAG, "onBindViewHolder: ")
//                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_corner_bottom)
//                        }
//                        else{
//                            holder.llImageDetail.setBackgroundResource(R.drawable.shape_normal)
//                        }

//                        val layoutParams : StaggeredGridLayoutManager.LayoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
//                        layoutParams.isFullSpan = true

                        holder.ivImageMore.setOnClickListener { // click vào bất kì một ảnh trong list more like this sẽ hiện ra màn chi tiết của ảnh đó
                            val intent = Intent(context, DetailActivity::class.java)
                            intent.putExtra("thomnt", elementImageMore)
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    val bottomSheetDialog = BottomSheetDialog(context)
    val bottomSheetDialogHide = BottomSheetDialog(context)
    val bottomSheetDialogReport = BottomSheetDialog(context)
    val bottomSheetDialogDownload = BottomSheetDialog(context)
    val bottomSheetDialogComment = BottomSheetDialog(context)

    private fun showBottomSheetDialogComment() {
        bottomSheetDialogComment.setContentView(R.layout.bottom_sheet_dialog_comment)

        val edtComment = bottomSheetDialogComment.findViewById<EditText>(R.id.edtComment)
        val btPostCmt = bottomSheetDialogComment.findViewById<Button>(R.id.btPostCmt)
        val closePost = bottomSheetDialogComment.findViewById<ImageView>(R.id.ivCloseCmt)

//        if (btPostCmt != null) {
//            btPostCmt.setOnClickListener {
//
//            }
//        }
        bottomSheetDialogComment.show()

        if (closePost != null) {
            closePost.setOnClickListener {
                bottomSheetDialogComment.dismiss()
            }
        }

    }

    private fun showBottomSheetDialog() {
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)

        val hide = bottomSheetDialog.findViewById<TextView>(R.id.tvHide)
        val download = bottomSheetDialog.findViewById<TextView>(R.id.tvDownload)
        val report = bottomSheetDialog.findViewById<TextView>(R.id.tvReport)
        val close = bottomSheetDialog.findViewById<Button>(R.id.btCloseBottomSheet)

        if (close != null) {
            close.setOnClickListener {
                bottomSheetDialog.dismiss()
            }
        }

        if (hide != null) {
            hide.setOnClickListener {
                showBottomSheetDialogHide()
            }
        }

        if (report != null) {
            report.setOnClickListener {
                showBottomSheetDialogReport()
            }
        }

        if (download != null) {
            download.setOnClickListener {
                Toast.makeText(context, "Đã tải hình ảnh xuống!", Toast.LENGTH_SHORT).show()
            }
        }
        bottomSheetDialog.show()

    }

    private fun showBottomSheetDialogReport() {
        bottomSheetDialogReport.setContentView(R.layout.bottom_sheet_dialog_report)

        val report1 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport1)
        val report2 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport2)
        val report3 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport3)
        val report4 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport4)
        val report5 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport5)
        val report6 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport6)
        val report7 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport7)
        val report8 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport8)
        val report9 = bottomSheetDialogReport.findViewById<RelativeLayout>(R.id.rlReport9)
        val closeReport = bottomSheetDialogReport.findViewById<ImageView>(R.id.ivCloseReport)

        bottomSheetDialogReport.show()

        if (closeReport != null) {
            closeReport.setOnClickListener {
                bottomSheetDialogReport.dismiss()
                bottomSheetDialog.dismiss()
            }
        }
    }

    private fun showBottomSheetDialogHide() {
        bottomSheetDialogHide.setContentView(R.layout.bottom_sheet_dialog_hide)

        val hide1 = bottomSheetDialogHide.findViewById<TextView>(R.id.tvHide1)
        val hide2 = bottomSheetDialogHide.findViewById<TextView>(R.id.tvHide2)
        val hide3 = bottomSheetDialogHide.findViewById<TextView>(R.id.tvHide3)
        val hide4 = bottomSheetDialogHide.findViewById<TextView>(R.id.tvHide4)
        val hide5 = bottomSheetDialogHide.findViewById<TextView>(R.id.tvHide5)
        val closeHide = bottomSheetDialogHide.findViewById<Button>(R.id.btCloseBottomSheetHide)

        if (closeHide != null) {
            closeHide.setOnClickListener {
                bottomSheetDialogHide.dismiss()
                bottomSheetDialog.dismiss()
            }
        }
        bottomSheetDialogHide.show()
    }

    override fun getItemCount(): Int {
        return 1 + listMoreLikeThis.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> POST_DETAIL_TYPE
            else -> LIST_MORE_LIKE_THIS
        }
    }

    inner class ImageDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivImage: ImageView
        private val civAvatar: CircleImageView
        private val tvAccountName: TextView
        private val tvFollowersDetail: TextView
        private val tvTitle: TextView
        private val tvContent: TextView
        private val civAvatarAccount: CircleImageView
        val edtComment: EditText
        val ivBack: ImageView
        val ivSelect: ImageView
        val btAccessDetail: Button
        val btShareDetail: ImageButton
        val btSaveDetail: Button
        var exoPlayer: PlayerView

        val player = SimpleExoPlayer.Builder(context).build()
        val urlVideo = Uri.parse(postDetail.url)
        val data: DataSource.Factory = DefaultHttpDataSource.Factory()
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(data)
            .createMediaSource(MediaItem.fromUri(urlVideo))

        init {
            ivImage = itemView.findViewById(R.id.ivImageDetail)
            civAvatar = itemView.findViewById(R.id.civAvatar)
            tvAccountName = itemView.findViewById(R.id.tvAccountName)
            tvFollowersDetail = itemView.findViewById(R.id.tvFollowersDetail)
            tvTitle = itemView.findViewById(R.id.tvTitleContent)
            tvContent = itemView.findViewById(R.id.tvContent)
            civAvatarAccount = itemView.findViewById(R.id.civAvatarAccount)
            edtComment = itemView.findViewById(R.id.edtComment)
            ivBack = itemView.findViewById(R.id.ivBack)
            ivSelect = itemView.findViewById(R.id.ivSelect)
            btAccessDetail = itemView.findViewById(R.id.btAccessDetail)
            btShareDetail = itemView.findViewById(R.id.ibShareDetail)
            btSaveDetail = itemView.findViewById(R.id.btSaveDetail)
            exoPlayer = itemView.findViewById(R.id.exoPvVideo)

            if (postDetail.isImage()) {
                ivImage.visibility = ImageView.VISIBLE
            } else {
                exoPlayer.visibility = PlayerView.VISIBLE
                ivImage.visibility = ImageView.GONE
            }
            exoPlayer.player = player
            player.playWhenReady = true
            player.setMediaSource(mediaSource)
            player.prepare()
        }

        fun bindDataImageDetail() {
            Glide.with(context).load(postDetail.url).into(ivImage)
            tvTitle.text = postDetail.title
            tvContent.text = postDetail.content

            Glide.with(context).load(postDetail.urlAvatar).into(civAvatar)
            tvAccountName.text = postDetail.nameA
            tvFollowersDetail.text = postDetail.follower

            Glide.with(context).load(postDetail.url).into(civAvatarAccount)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun resetData(listMoreLikeThis: List<Post>) {
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

        fun bindDataMoreLikeThis(elementPostMore: Post) {
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

            Glide.with(context).load(elementPostMore.url).apply(requestOptions).into(ivImageMore)
            tvTitleMore.text = elementPostMore.title
        }
    }
}
