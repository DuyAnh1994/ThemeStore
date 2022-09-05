package ai.ftech.themestore

import ai.ftech.themestore.model.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvImage: RecyclerView
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvImage = findViewById(R.id.rvImage)
        swipeRefreshLayout = findViewById(R.id.swipeRefresh)

        var images : MutableList<Image> = mutableListOf<Image>()
        images.add(Image(R.drawable.ic_image_0, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_1, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_10, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_11, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_12, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_13, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_14, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_15, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_16, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_17, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_18, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_19, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_2, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_20, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_3, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_4, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_5, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_6, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_7, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_8, R.drawable.ic_select))
        images.add(Image(R.drawable.ic_image_9, R.drawable.ic_select))

        imageAdapter = ImageAdapter(images, this)
        rvImage.adapter = imageAdapter
        var staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvImage.layoutManager = staggeredGridLayoutManager

        imageAdapter.notifyDataSetChanged()
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(images, Random(System.currentTimeMillis()))
            imageAdapter.notifyDataSetChanged()
        }
    }
}