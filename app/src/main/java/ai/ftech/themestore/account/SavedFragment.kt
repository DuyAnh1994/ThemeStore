package ai.ftech.themestore.account

import ai.ftech.themestore.Key
import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SavedFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesFollow: SharedPreferences
    private lateinit var rvSaved: RecyclerView
    private lateinit var saveAdapter: SaveAdapter
    private lateinit var listSaved: MutableList<Post>

    companion object {
        private const val TAG = "SavedFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        sharedPreferences = context?.getSharedPreferences("Save", MODE_PRIVATE)!!
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet", "CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvSaved = view.findViewById(R.id.rvSaved)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rvSaved.layoutManager = staggeredGridLayoutManager

        loadData()

    }

    fun loadData() {
        val jsonPost = sharedPreferences.getString(Key.KEY_SAVE, null)
        val jsonPost1 = sharedPreferences.getString("followed", null)
        var post: MutableList<Post> = mutableListOf()
        if (jsonPost != null) {
            val gson = Gson()
            val listType = object : TypeToken<List<Post>>() {}.type
            if (listType != null) {
                post = gson.fromJson(jsonPost, listType)
            }
        }
        listSaved = post
        saveAdapter = SaveAdapter(requireContext())
        rvSaved.adapter = saveAdapter
        saveAdapter.resetData(listSaved)
    }

}
