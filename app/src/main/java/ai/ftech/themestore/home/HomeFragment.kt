package ai.ftech.themestore.home

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.DetailActivity
import ai.ftech.themestore.detailPreview.ListDisplay
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var rvHome: RecyclerView
    private lateinit var prbLoading: ProgressBar
    private var homeAdapter = HomeAdapter().apply {
        iOnClickPost = object : HomeAdapter.IOnClickPost {
            override fun onClickPost(post: Post) {
                Log.d("123", "onClickPost: ")
                if (context != null) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("thomnt", post)
                    context!!.startActivity(intent)
                }
            }
        }
    }
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    @SuppressLint("UseRequireInsteadOfGet", "NotifyDataSetChanged", "CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvHome = view.findViewById(R.id.rvHome)
        prbLoading = view.findViewById(R.id.prbLoading)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)

        var listPost: MutableList<HomeAdapter.Display> = mutableListOf()

        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

//        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rvHome.layoutManager = staggeredGridLayoutManager

        rvHome.adapter = homeAdapter

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            listPost.shuffle(Random(System.currentTimeMillis()))
            homeAdapter.notifyDataSetChanged()
        }


        lifecycleScope.launch(Dispatchers.IO) {

            listPost = ListDisplay.listElement()

            withContext(Dispatchers.Main) {
                homeAdapter.resetData(listPost)
                prbLoading.visibility = ProgressBar.GONE
            }
        }


    }
}
