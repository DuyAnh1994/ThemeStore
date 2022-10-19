package ai.ftech.themestore.home

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

class HomeFragment : Fragment() {
    private lateinit var rvHome: RecyclerView
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    @SuppressLint("UseRequireInsteadOfGet", "NotifyDataSetChanged", "CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvHome = view.findViewById(R.id.rvHome)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)

        val element : MutableList<Post> = ListPost.listElement()

        if(activity != null){
            homeAdapter = HomeAdapter(activity!!)
        }


        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvHome.layoutManager = staggeredGridLayoutManager

        rvHome.adapter = homeAdapter
        homeAdapter.resetData(element)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(element, Random(System.currentTimeMillis()))
            homeAdapter.notifyDataSetChanged()
        }
    }
}
//    private fun saveData() {
//        sharedPreferences = context.getSharedPreferences("dataImage", 0)
//        val editor : SharedPreferences.Editor = sharedPreferences.edit()
//        val gson : Gson = Gson()
//        val json : String? = gson.toJson()
//        editor.putString("image", json)
//        editor.apply()
//    }
//
//    private fun loadData(){
//        sharedPreferences = context.getSharedPreferences("dataImage", 0)
//        val gson : Gson = Gson()
//        val json : String? = sharedPreferences.getString("image", null)
//        val type : Type = TypeToken<MutableList<Image>>().type
//        listImageUrls = json.fromJson(json, type)
//
//    }


