package ai.ftech.themestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.ftech.themestore.R
import ai.ftech.themestore.model.TabTopic
import ai.ftech.themestore.ViewPagerAdapter
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
        var fragmentView: View =  inflater.inflate(R.layout.fragment_topic, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabTopic)

        vpTopic = view.findViewById(R.id.vpTopic)

        vpTopicAdapter =  ViewPagerAdapter(childFragmentManager)

        vpTopicAdapter.addTab( TabTopic(wallpapersFragment, "Wallpapers"))
        vpTopicAdapter.addTab( TabTopic(ringtonesFragment, "Ringtones"))
        vpTopicAdapter.addTab( TabTopic(notificationSoundsFragment, "Notifications"))


        vpTopic.adapter = vpTopicAdapter

        tabLayout.setupWithViewPager(vpTopic)


    }
}
