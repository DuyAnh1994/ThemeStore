package ai.ftech.themestore.topic.images

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import ai.ftech.themestore.detailPreview.ListPost
import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*

class ImageFragment : Fragment() {
    private lateinit var rvImage : RecyclerView
    private lateinit var imageAdapter : ImageAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvImage = view.findViewById(R.id.rvImage)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshW)

        val post : MutableList<Post> = ListPost.listElement()
        val urlImage : MutableList<Post> = mutableListOf()

        for(i in 0 until post.size){
            if(post[i].isImage()){
                urlImage.add(post[i])
            }
        }

        if(activity != null){
            imageAdapter = ImageAdapter(urlImage, activity!!)
        }
        rvImage.adapter = imageAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        rvImage.layoutManager = staggeredGridLayoutManager

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(post, Random(System.currentTimeMillis()))
        }
    }

}
