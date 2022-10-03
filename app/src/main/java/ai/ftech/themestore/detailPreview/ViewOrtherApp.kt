package ai.ftech.themestore.detailPreview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import android.content.Intent
import android.net.Uri
import android.widget.Button


class ViewOrtherApp : Fragment() {
    private lateinit var btAccessDetail : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_image_item, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btAccessDetail  = view.findViewById(R.id.btAccessDetail)
//        btAccessDetail.setOnClickListener(object : View.OnClickListener{
//            val uri = Uri.parse(Image().urlAccess)
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            context.startActivity(intent)
//        })
    }
}
