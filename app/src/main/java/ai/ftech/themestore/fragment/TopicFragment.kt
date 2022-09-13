package ai.ftech.themestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.ViewPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener


class TopicFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var vpTopic : ViewPager
    private lateinit var vpTopicAdapter: ViewPagerAdapter
    private var wallpapersFragment : WallpapersFragment = WallpapersFragment()
    private var ringtonesFragment : RingtonesFragment = RingtonesFragment()
    private var notificationSoundsFragment : NotificationSoundsFragment = NotificationSoundsFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var fragmentView: View =  inflater.inflate(R.layout.fragment_topic, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabTopic)
        vpTopic = view.findViewById(R.id.vpTopic)

        vpTopicAdapter =  ViewPagerAdapter(childFragmentManager)

        vpTopicAdapter.addFragment(0, wallpapersFragment)
        vpTopicAdapter.addFragment(1, ringtonesFragment)
        vpTopicAdapter.addFragment(2, notificationSoundsFragment)

        vpTopic.adapter = vpTopicAdapter
        tabLayout.setOnTabSelectedListener(object : TabLayout.ViewPagerOnTabSelectedListener(vpTopic) {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                vpTopic.setCurrentItem(tab!!.position)
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                super.onTabSelected(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                super.onTabUnselected(tab)
            }
        })
        


    }
}
