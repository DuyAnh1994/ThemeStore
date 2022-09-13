package ai.ftech.themestore.fragment

import ai.ftech.themestore.ImageAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
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

        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvImage = view.findViewById(R.id.rvImage)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)
        var images: MutableList<String> = mutableListOf<String>()

        images.add("https://i.pinimg.com/236x/fa/92/35/fa92357acf0eb53e0e4d4170a2f00cb0.jpg")
        images.add("https://i.pinimg.com/236x/ac/6f/7f/ac6f7fda3d18c5ced8f660291a3f0921.jpg")
        images.add("https://i.pinimg.com/236x/7d/ce/10/7dce10fe06a8790d8fde5db84fa0fef0.jpg")
        images.add("https://i.pinimg.com/236x/e6/89/47/e689476d68157a3b33961489db179a81.jpg")
        images.add("https://i.pinimg.com/236x/43/37/7b/43377b63e89966d322266357ab3f42b8.jpg")
        images.add("https://i.pinimg.com/236x/e5/cf/34/e5cf343e8dbe5f3526d8b385446c1442.jpg")
        images.add("https://i.pinimg.com/236x/af/04/fa/af04fad65ea06a814c8668c373b94348.jpg")
        images.add("https://i.pinimg.com/236x/62/7e/aa/627eaacd1bc50428a686de5bbd93470b.jpg")
        images.add("https://i.pinimg.com/236x/14/37/cc/1437cc4128bbc610769cacf1db5852c8.jpg")
        images.add("https://i.pinimg.com/236x/78/f9/63/78f9631ebb6e4a2f798fe561f7126571.jpg")
        images.add("https://i.pinimg.com/236x/9e/1b/56/9e1b567a5445db392298cd5affa4239e.jpg")
        images.add("https://i.pinimg.com/236x/fc/52/89/fc5289db9e6f8386e8d57302a45ce236.jpg")
        images.add("https://i.pinimg.com/236x/50/ef/28/50ef280df39ceea625fd38da37defd1e.jpg")
        images.add("https://i.pinimg.com/564x/16/f7/61/16f761edf9bb3107c4bb4f67018bd3de.jpg")
        images.add("https://i.pinimg.com/236x/3d/81/61/3d816155f3dc8b472d745bd7285c42d3.jpg")
        images.add("https://i.pinimg.com/236x/a7/10/67/a7106735e0965396d6434f64d44d6274.jpg")
        images.add("https://i.pinimg.com/236x/f2/5a/e5/f25ae5445a02133d5407392a08c70644.jpg")
        images.add("https://i.pinimg.com/236x/ca/4e/72/ca4e7245293f384444e65544741ce787.jpg")
        images.add("https://i.pinimg.com/236x/cf/06/02/cf0602829d1185a4e5038e917d785589.jpg")
        images.add("https://i.pinimg.com/236x/52/97/79/529779ff57d814027d0bf1e6f57764ee.jpg")
        images.add("https://i.pinimg.com/236x/9d/52/85/9d528558f8b5e304e0bfc05146049786.jpg")
        images.add("https://i.pinimg.com/236x/c1/f9/47/c1f94730a71def6ae34ff2221051d523.jpg")
        images.add("https://i.pinimg.com/236x/08/b8/d4/08b8d444dfe974673f130e41d3a60227.jpg")
        images.add("https://i.pinimg.com/236x/8e/40/0b/8e400b98d24e70651fb654401be901f0.jpg")
        images.add("https://i.pinimg.com/236x/50/ef/28/50ef280df39ceea625fd38da37defd1e.jpg")
        images.add("https://i.pinimg.com/236x/cd/19/6d/cd196d33206b6e57ceaed5890c637f4a.jpg")
        images.add("https://i.pinimg.com/236x/96/35/61/963561e016ce08da0779c7656533eefc.jpg")
        images.add("https://i.pinimg.com/236x/fa/e5/50/fae5503352eb3050a2430dab469f80b3.jpg")

        imageAdapter = ImageAdapter(images, this)
        rvImage.adapter = imageAdapter
        var staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvImage.layoutManager = staggeredGridLayoutManager

        imageAdapter.notifyDataSetChanged()
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Collections.shuffle(images, Random(System.currentTimeMillis()))
            imageAdapter.notifyDataSetChanged()
        }



    }

}

