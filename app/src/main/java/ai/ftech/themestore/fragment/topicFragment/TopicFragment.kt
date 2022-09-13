package ai.ftech.themestore.fragment.topicFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.ViewPagerAdapter
import ai.ftech.themestore.fragment.HomeFragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class TopicFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var vpTopic : ViewPager
    private lateinit var vpTopicAdapter: ViewPagerAdapter
    private var wallpapersFragment : Fragment = WallpapersFragment()
    private var ringtonesFragment : Fragment = RingtonesFragment()
    private var notificationsFragment : Fragment = NotificationsFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var fragmentView: View =  inflater.inflate(R.layout.fragment_topic, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabTopic)
        vpTopic = view.findViewById(R.id.vpTopic)

        vpTopicAdapter =  ViewPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(vpTopic)

        vpTopicAdapter.addFragment(0, wallpapersFragment)
        vpTopicAdapter.addFragment(1, ringtonesFragment)
        vpTopicAdapter.addFragment(2, notificationsFragment)

        vpTopic.adapter = vpTopicAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                vpTopic.currentItem = tabLayout.selectedTabPosition
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
    }

}
