package ai.ftech.themestore.fragment

import ai.ftech.themestore.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.annotation.SuppressLint
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {
//    private lateinit var rvIdeasSearch : RecyclerView
//    private lateinit var rvPopularSearch : RecyclerView
//    private lateinit var ideasAdapter: IdeasAdapter
//    private lateinit var popularAdapter: PopularAdapter
    private lateinit var rvSearch : RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        rvSearch = view.findViewById(R.id.rvSearch)
        val image : MutableList<ItemsSearch> = ImageItemsSearch.listImage()

        val title : MutableList<String> = mutableListOf()
        title.add("Ideas for you")
        title.add("Popular ThemeStore")

        if(activity != null){
            searchAdapter = SearchAdapter(title,image, context!!)
        }
        rvSearch.adapter = searchAdapter
        var layoutManager = GridLayoutManager(context,2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(position%9){
                    0, 9-> 2
                    else -> 1
                }
            }
        }
        rvSearch.layoutManager = layoutManager
        /*
//        index 0 : 2 (tức là gộp 2 ô thành 1)
        index 1 và 2 = 1( tức là mỗi vị trí chiếm 1 ô)
        index 3 và 4 = 1
        index 5 và 6 = 1
        index 7 và 8 = 1
//        index 9 : 2
        index 10 và 11 = 1
        index 12 và 13 = 1
        index 14 và 15 = 1
        index 16 và 17 = 1
        */


    }

}
