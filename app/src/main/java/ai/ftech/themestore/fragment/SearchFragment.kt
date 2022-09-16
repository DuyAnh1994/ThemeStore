package ai.ftech.themestore.fragment

import ai.ftech.themestore.*
import ai.ftech.themestore.model.Ideas
import ai.ftech.themestore.model.ItemsSearch
import ai.ftech.themestore.model.Popular
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.annotation.SuppressLint
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {
    private lateinit var rvIdeasSearch : RecyclerView
    private lateinit var rvPopularSearch : RecyclerView
    private lateinit var ideasAdapter: IdeasAdapter
    private lateinit var popularAdapter: PopularAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        rvIdeasSearch = view.findViewById(R.id.rvIdeasSearch)
        rvPopularSearch = view.findViewById(R.id.rvPopularSearch)


        val imagesIdea : MutableList<ItemsSearch> = Ideas.listIdea()
        if(activity != null){
            ideasAdapter = IdeasAdapter(imagesIdea, context!!)
        }
        rvIdeasSearch.adapter = ideasAdapter
        var layoutManager1 = GridLayoutManager(context,2)
        rvIdeasSearch.layoutManager = layoutManager1

        val imagesPopular : MutableList<ItemsSearch> = Popular.listPopular()
        if(activity != null){
             popularAdapter = PopularAdapter(imagesPopular,context!!)
        }
        rvPopularSearch.adapter = popularAdapter
        var layoutManager2 = GridLayoutManager(context,2)
        rvPopularSearch.layoutManager = layoutManager2
    }

}
