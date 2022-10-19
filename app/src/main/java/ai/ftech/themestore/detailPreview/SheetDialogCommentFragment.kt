package ai.ftech.themestore.detailPreview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import android.app.DialogFragment.STYLE_NORMAL
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import java.time.format.DecimalStyle

class SheetDialogCommentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_dialog_comment, container, false)
        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        context?.setTheme(R.style.DialogStyle)
//    }
}
