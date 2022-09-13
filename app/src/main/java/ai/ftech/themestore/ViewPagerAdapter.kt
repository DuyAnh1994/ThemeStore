package ai.ftech.themestore

import androidx.fragment.app.*

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
