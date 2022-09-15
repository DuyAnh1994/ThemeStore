package ai.ftech.themestore.model

object Ideas {
    fun listIdea() : MutableList<ItemsSearch> {
        val ideas: MutableList<ItemsSearch> = mutableListOf()
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/30/5a/0f/305a0f139d86dcbb0b5626824b9f5ff5.jpg", "Hình biểu cảm")) // Hình biểu cảm
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/0c/fd/d6/0cfdd605314dcd2071b4cce9dd8476cd.jpg", "Nghệ thuật trừu tượng")) // Nghệ thuật trừu tượng
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/cc/b0/fa/ccb0fa310af8e624100b168f1b5df515.jpg", "Hài hước về mèo")) // Hài hước về mèo
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/5a/29/8d/5a298d30b1574674c2c075887487fe15.jpg", "Kpop")) // Kpop
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/54/34/be/5434be1d2b769c018202dcb46e1f5f11.jpg", "Thiên nhiên phong cảnh")) // Thiên nhiên phong cảnh
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/c4/40/f3/c440f33ffc590f38a42167377a7396f6.jpg","Ý tưởng sinh nhật")) // ý tưởng sinh nhật
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/30/5a/0f/305a0f139d86dcbb0b5626824b9f5ff5.jpg", "Anime")) // Anime
        ideas.add(ItemsSearch("https://i.pinimg.com/236x/5e/de/56/5ede56532a6bf699afd0e470eede6244.jpg", "Baby Cute")) // Trẻ em đáng yêu
        return ideas
    }
}

