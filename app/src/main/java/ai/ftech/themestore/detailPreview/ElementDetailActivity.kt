package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElementDetailActivity : AppCompatActivity() {
    private lateinit var rvDetailPreview : RecyclerView
    private lateinit var elementDetailAdapter: ElementDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element_detail)

        rvDetailPreview = findViewById(R.id.rvDetailPreview)

        val imageDetail = Image().apply {
            urlImage = "https://i.pinimg.com/236x/fa/92/35/fa92357acf0eb53e0e4d4170a2f00cb0.jpg"
            urlAvatar = "https://i.pinimg.com/236x/fa/92/35/fa92357acf0eb53e0e4d4170a2f00cb0.jpg"
            follower = "173k người theo dõi"
            title = "Meme là gì?"
            content = "Meme là những hình ảnh đáng yêu"
            nameA = "Meme"
        }

        val listMoreLikeThis : MutableList<ElementImageMore> = ListElementImageMore.listElementImageMore()

        rvDetailPreview.adapter = ElementDetailAdapter(imageDetail,listMoreLikeThis, this)

        val layoutManager = LinearLayoutManager(this)
        rvDetailPreview.layoutManager =  layoutManager
    }

}

