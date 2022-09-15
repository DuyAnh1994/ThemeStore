package ai.ftech.themestore.model

object Popular {
    fun listPopular() : MutableList<ItemsSearch> {
        val popular: MutableList<ItemsSearch> = ArrayList()
        popular.add(ItemsSearch("https://i.pinimg.com/236x/de/27/e5/de27e5c02bb316a4214cddf6c9ca253b.jpg", "Captions ngắn"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/35/68/dc/3568dccde41e5545125b0e01823189c0.jpg", "Mèo đáng yêu"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/c4/d8/0e/c4d80e61ebb8f65347fe6d22eaa090f1.jpg", "Galaxy"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/e8/4d/d9/e84dd9c3e849598d9be3acaf8c9b9e2b.jpg", "Pink Venom"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/ec/d2/7b/ecd27b32e41ab7883bae2e232a767d9f.jpg", "Lời trích"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/2f/e3/e7/2fe3e7df41d61ab571538591967e5899.jpg", "Couple"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/6b/43/0f/6b430fa34c78efdf59cc69244b3bebfa.jpg", "Big Bang"))
        popular.add(ItemsSearch("https://i.pinimg.com/236x/cc/84/82/cc8482834d7b94fa6df1287bfb973ee6.jpg", "Hoa hướng dương"))

        return popular
    }
}

