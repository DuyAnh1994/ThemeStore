package ai.ftech.themestore.topic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.Tab
import ai.ftech.themestore.ViewPagerAdapter
import ai.ftech.themestore.fragment.NotificationsFragment
import ai.ftech.themestore.topic.ringtones.RingtonesFragment
import ai.ftech.themestore.topic.wallpapers.WallpapersFragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class TopicFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var vpTopic : ViewPager
    private lateinit var vpTopicAdapter: ViewPagerAdapter
    private var wallpapersFragment : WallpapersFragment = WallpapersFragment()
    private var ringtonesFragment : RingtonesFragment = RingtonesFragment()
    private var notificationSoundsFragment : NotificationsFragment = NotificationsFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val fragmentView: View =  inflater.inflate(R.layout.fragment_topic, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabTopic)

        vpTopic = view.findViewById(R.id.vpTopic)

        vpTopicAdapter =  ViewPagerAdapter(childFragmentManager)

        vpTopicAdapter.addTab( Tab(wallpapersFragment, "Wallpapers"))
        vpTopicAdapter.addTab( Tab(ringtonesFragment, "Ringtones"))
        vpTopicAdapter.addTab( Tab(notificationSoundsFragment, "Notifications"))


        vpTopic.adapter = vpTopicAdapter

        tabLayout.setupWithViewPager(vpTopic)


    }
}
