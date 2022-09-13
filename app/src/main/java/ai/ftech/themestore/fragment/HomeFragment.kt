package ai.ftech.themestore.fragment

import ai.ftech.themestore.AddImage
import ai.ftech.themestore.ImageAdapter
import ai.ftech.themestore.ImageAdd.listImage
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.ImageAdd
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var rvImage: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvImage = view.findViewById(R.id.rvImage)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)

        val images : MutableList<String> =AddImage.listImage()
        imageAdapter = ImageAdapter(images, this)
        rvImage.adapter = imageAdapter

        var staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvImage.layoutManager = staggeredGridLayoutManager

        imageAdapter.notifyDataSetChanged()
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(images, Random(System.currentTimeMillis()))
            imageAdapter.notifyDataSetChanged()
        }
    }

}

