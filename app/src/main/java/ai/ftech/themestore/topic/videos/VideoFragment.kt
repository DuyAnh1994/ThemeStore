package ai.ftech.themestore.topic.videos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.ListPost
import ai.ftech.themestore.detailPreview.Post
import ai.ftech.themestore.topic.images.ImageAdapter
import android.annotation.SuppressLint
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import java.util.*


class VideoFragment : Fragment() {
    private lateinit var rvVideo : RecyclerView
    private lateinit var videoAdapter : VideoAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvVideo = view.findViewById(R.id.rvVideo)

        val post : MutableList<Post> = ListPost.listElement()

        val urlVideo : MutableList<Post> = mutableListOf()

        for(i in 0 until post.size){
            if(post[i].check == 1){
                urlVideo.add(post[i])
            }
        }

        if(activity != null){
            videoAdapter = VideoAdapter(context!!)
        }

        rvVideo.adapter = videoAdapter
        videoAdapter.resetData(urlVideo)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        rvVideo.layoutManager = staggeredGridLayoutManager

    }
}
