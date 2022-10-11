package ai.ftech.themestore.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.Tab
import ai.ftech.themestore.ViewPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class AccountFragment : Fragment() {
    private lateinit var tabProfile : TabLayout
    private lateinit var vpProfile : ViewPager
    private lateinit var vpProfileAdapter : ViewPagerAdapter
    private var createdFragment : CreatedFragment = CreatedFragment()
    private var savedFragment : SavedFragment = SavedFragment()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabProfile = view.findViewById(R.id.tabProfile)
        vpProfile = view.findViewById(R.id.vpProfile)
        
        vpProfileAdapter = ViewPagerAdapter(childFragmentManager)
        
        vpProfileAdapter.addTab(Tab(createdFragment, "Đã tạo"))
        vpProfileAdapter.addTab(Tab(savedFragment, "Đã lưu"))

//        createdFragment to R.drawable.shape_bt_white
//        savedFragment to R.drawable.shape_bt_white

        vpProfile.adapter = vpProfileAdapter
        tabProfile.setupWithViewPager(vpProfile)
    }

}
