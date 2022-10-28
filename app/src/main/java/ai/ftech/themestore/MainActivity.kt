package ai.ftech.themestore

import ai.ftech.themestore.account.AccountFragment
import ai.ftech.themestore.home.HomeFragment
import ai.ftech.themestore.search.SearchFragment
import ai.ftech.themestore.topic.TopicFragment
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
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

        vpHomeAdapter.addTab(Tab(homeFragment))
        vpHomeAdapter.addTab(Tab(topicFragment))
        vpHomeAdapter.addTab(Tab(searchFragment))
        vpHomeAdapter.addTab( Tab(accountFragment))

        vpHome.setOnTouchListener(
        object : View.OnTouchListener{
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                return true
            }
        })

        vpHome.adapter = vpHomeAdapter
        vpHome.offscreenPageLimit = vpHomeAdapter.count

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
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Ấn back lần 2 để thoát!", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 1000)
    }
}

