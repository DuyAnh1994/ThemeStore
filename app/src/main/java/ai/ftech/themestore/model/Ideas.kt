package ai.ftech.themestore.model

object Ideas {
    fun listIdea() : MutableList<ItemsSearch> {
        val ideas: MutableList<ItemsSearch> = mutableListOf()
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/42/e7/6c/42e76c7e47a400825afd69f1b327d7b7.jpg", "Hình biểu cảm")) 
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/26/1f/67/261f67e1793230dbfcad24276339557f.jpg", "Nhuộm highlight"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/cc/b0/fa/ccb0fa310af8e624100b168f1b5df515.jpg", "Hài hước về mèo"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/5e/de/56/5ede56532a6bf699afd0e470eede6244.jpg", "Baby Cute"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/ce/40/74/ce40745698176433da0e10fd40edf6a9.jpg", "Anime"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/fb/e5/f3/fbe5f39ebf2deaeab69e6dc8d679eb63.jpg", "Thiên nhiên phong cảnh"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/5a/29/8d/5a298d30b1574674c2c075887487fe15.jpg", "Kpop"))
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/90/0e/5d/900e5db1b0013f918692081e67fde371.jpg","Bầu trời"))
        return ideas
    }
}

