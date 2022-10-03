package ai.ftech.themestore.topic.wallpapers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.ElementImageMore
import ai.ftech.themestore.detailPreview.Image
import ai.ftech.themestore.home.ImageHome
import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*

class WallpapersFragment : Fragment() {
    private lateinit var rvImageW : RecyclerView
    private lateinit var wallpapersAdapter : WallpapersAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_wallpapers, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvImageW = view.findViewById(R.id.rvWallpapers)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshW)

        val image : MutableList<Image> = ImageHome.listElement()

        if(activity != null){
            wallpapersAdapter = WallpapersAdapter(image, activity!!)
        }
        rvImageW.adapter = wallpapersAdapter

        var staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        rvImageW.layoutManager = staggeredGridLayoutManager

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(image, Random(System.currentTimeMillis()))
        }
    }

}
