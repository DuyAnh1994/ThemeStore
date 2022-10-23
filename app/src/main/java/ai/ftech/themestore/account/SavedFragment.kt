package ai.ftech.themestore.account

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson

class SavedFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var rvSaved : RecyclerView
    private lateinit var saveAdapter: SaveAdapter
    
    companion object{
        private const val TAG = "SavedFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        sharedPreferences = context?.getSharedPreferences("SaveData", MODE_PRIVATE)!!
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet", "CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvSaved = view.findViewById(R.id.rvSaved)

        val listSave : MutableList<Post> = mutableListOf()

        val gson = Gson()
        val json: String? = sharedPreferences.getString("save", "")

        val obj: Post = gson.fromJson(json, Post::class.java)
        Log.d(TAG, "onViewCreated: ")

        saveAdapter = SaveAdapter(context!!)
        listSave.add(obj)
        saveAdapter.resetData(listSave)
        rvSaved.adapter = saveAdapter

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rvSaved.layoutManager = staggeredGridLayoutManager

    }
}
