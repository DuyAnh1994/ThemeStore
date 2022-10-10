package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import ai.ftech.themestore.home.HomeFragment
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlin.concurrent.fixedRateTimer

class ElementDetailActivity : AppCompatActivity() {
    private lateinit var rvDetailPreview: RecyclerView
    private lateinit var elementDetailAdapter: ElementDetailAdapter
    private lateinit var imageDetail: Image

    companion object {
        private const val TAG = "123"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element_detail)

        val extras: Bundle? = intent.extras
        if (extras != null) {
            imageDetail = extras.getSerializable("thomnt") as Image
        }

        rvDetailPreview = findViewById(R.id.rvDetailPreview)



        val element: MutableList<Image> = ListImage.listElementImage()

//        for(i in 0..element.size - 1){
//            Log.d(TAG, "onCreate: ${element[i].firstItem}  ${element[i].lastItem} ")
//        }

        elementDetailAdapter = ElementDetailAdapter(imageDetail, this)
        elementDetailAdapter.resetData(element)
        rvDetailPreview.adapter = elementDetailAdapter

        val layoutManager = GridLayoutManager(this,2)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(position){
                    0 -> 2
                    else -> 1
                }
            }
        }

        rvDetailPreview.layoutManager = layoutManager

    }

}

