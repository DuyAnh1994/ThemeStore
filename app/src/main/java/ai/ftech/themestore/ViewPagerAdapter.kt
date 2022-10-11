package ai.ftech.themestore

import ai.ftech.themestore.account.CreatedFragment
import androidx.fragment.app.*

class ViewPagerAdapter(fragmentManager: FragmentManager) :FragmentPagerAdapter(fragmentManager) {

    private var listTab : MutableList<Tab> = mutableListOf()

    override fun getCount() : Int = listTab.size

    override fun getItem(position: Int): Fragment {
       val tab = listTab.get(position)
        return tab.fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val tab = listTab.get(position)
        return tab.string
    }

    fun addTab(tab: Tab){
        listTab.add(tab)
    }

}
