package ai.ftech.themestore.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Image
import ai.ftech.themestore.detailPreview.ListImage
import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var rvImage: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }


    @SuppressLint("UseRequireInsteadOfGet", "NotifyDataSetChanged", "CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvImage = view.findViewById(R.id.rvImage)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)

        val element : MutableList<Image> = ListImage.listElementImage()

//        if(activity!=null){
//            sharedPreferences = this.activity!!.getSharedPreferences("dataImage", Context.MODE_PRIVATE)
//        }
//        val editor : SharedPreferences.Editor = sharedPreferences.edit()
//        val image : Image = Image()
//        val gson : Gson = Gson()
//        val json : String? = gson.toJson(image)
//        editor.putString("image", json)

        if(activity != null){
            imageAdapter = ImageAdapter(activity!!)
        }


        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvImage.layoutManager = staggeredGridLayoutManager

        rvImage.adapter = imageAdapter
        imageAdapter.resetData(element)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(element, Random(System.currentTimeMillis()))
            imageAdapter.notifyDataSetChanged()
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
}

