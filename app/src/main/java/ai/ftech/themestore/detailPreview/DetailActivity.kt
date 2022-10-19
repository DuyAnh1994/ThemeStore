package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util

class DetailActivity : AppCompatActivity(), Player.Listener{
    private lateinit var rvDetailPreview: RecyclerView
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var postDetail: Post
//    private lateinit var exoPvVideo : PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element_detail)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            postDetail = extras.getSerializable("thomnt") as Post
        }

        rvDetailPreview = findViewById(R.id.rvDetailPreview)

        val listUrl: MutableList<Post> = ListPost.listElement() // listPost() gồm các url
 //       val listUrlVideo: MutableList<String> = mutableListOf()

//        for(i in 0 until listUrl.size){
//            if(listUrl[i].check == 1){
//                listUrlVideo.add(listUrl[i].url)
//            }
//        }

//        for(i in 0..element.size - 1){
//            Log.d(TAG, "onCreate: ${element[i].firstItem}  ${element[i].lastItem} ")
//        }
        detailAdapter = DetailAdapter(postDetail, this)
        detailAdapter.resetData(listUrl)
        rvDetailPreview.adapter = detailAdapter

        val layoutManager = GridLayoutManager(this,2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(position){
                    0 -> 2
                    else -> 1
                }
            }
        }
        rvDetailPreview.layoutManager = layoutManager
    }


}



