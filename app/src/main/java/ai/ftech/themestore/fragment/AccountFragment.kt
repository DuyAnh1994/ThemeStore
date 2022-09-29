package ai.ftech.themestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import android.content.Intent
import android.net.Uri
import android.widget.Button
import androidx.core.view.ContentInfoCompat


class AccountFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val viewAccount = inflater.inflate(R.layout.fragment_account, container, false)
        return viewAccount
    }
}
