package ai.ftech.themestore

import ai.ftech.themestore.fragment.AccountFragment
import ai.ftech.themestore.fragment.HomeFragment
import ai.ftech.themestore.fragment.SearchFragment
import ai.ftech.themestore.fragment.TopicFragment
import ai.ftech.themestore.model.TabTopic
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var vpHome: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    private var homeFragment: HomeFragment = HomeFragment()
    private var topicFragment: TopicFragment = TopicFragment()
    private var searchFragment: SearchFragment = SearchFragment()
    private var accountFragment: AccountFragment = AccountFragment()
    private var vpHomeAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationMenu)

        vpHome = findViewById(R.id.vpHome)
        vpHomeAdapter.addTab(TabTopic(homeFragment))
        vpHomeAdapter.addTab(TabTopic(topicFragment))
        vpHomeAdapter.addTab(TabTopic(searchFragment))
        vpHomeAdapter.addTab( TabTopic(accountFragment))

        vpHome.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                return true
            }

        })

        vpHome.adapter = vpHomeAdapter
        bottomNavigationView.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        vpHome.setCurrentItem(0)
                        return true
                    }
                    R.id.action_topic -> {
                        vpHome.setCurrentItem(1)
                        return true
                    }
                    R.id.action_search -> {
                        vpHome.setCurrentItem(2)
                        return true
                    }
                    else -> {
                        vpHome.setCurrentItem(3)
                        return true
                    }
                }
                return false
            }
        })
   }
}
