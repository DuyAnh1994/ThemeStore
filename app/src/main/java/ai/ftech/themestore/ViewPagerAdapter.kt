package ai.ftech.themestore

import ai.ftech.themestore.fragment.AccountFragment
import ai.ftech.themestore.fragment.HomeFragment
import ai.ftech.themestore.fragment.SearchFragment
import ai.ftech.themestore.fragment.TopicFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) :FragmentPagerAdapter(fragmentManager) {

    private var listFragment : MutableList<Fragment> = mutableListOf()

    override fun getCount() : Int = listFragment.size

    override fun getItem(position: Int): Fragment {
        return listFragment.get(position)
    }

    fun addFragment(position: Int, fragment: Fragment){
        listFragment.add(position,fragment)
    }
}
