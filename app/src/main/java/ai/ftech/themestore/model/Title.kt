package ai.ftech.themestore.model

object Title {
    fun listTitle() : MutableList<TitleSearch> {
        val titles: MutableList<TitleSearch> = mutableListOf()
        titles.add(0, TitleSearch("Ideas for you"))
        titles.add(1, TitleSearch("Popular ThemeStore"))
        return titles
    }
}
