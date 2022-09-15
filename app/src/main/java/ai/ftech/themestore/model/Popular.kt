package ai.ftech.themestore.model

object Popular {
    fun listPopular() : MutableList<ItemsSearch> {
        val popular: MutableList<ItemsSearch> = ArrayList()
        popular.add(ItemsSearch("https://i.pinimg.com/236x/9a/05/53/9a0553dd21124a9071b0e5eefeb3fd52.jpg", "Captions ngắn thả thính"))//Captions ngắn thả thính
        popular.add(ItemsSearch("https://i.pinimg.com/236x/4a/f7/cf/4af7cf2d3160a1835f7539303e129b5c.jpg", "Ảnh vintage")) // Ảnh vintage
        popular.add(ItemsSearch("https://i.pinimg.com/236x/6b/43/0f/6b430fa34c78efdf59cc69244b3bebfa.jpg", "Big Bang")) // Big Bang
        popular.add(ItemsSearch("https://i.pinimg.com/236x/5f/c1/17/5fc117034791ab2555467bc868e803c1.jpg", "Lời trích")) // Lời trích
        popular.add(ItemsSearch("https://i.pinimg.com/236x/73/95/55/7395559c4fce054508e021d5c13fa616.jpg", "Galaxy")) // Galaxy
        popular.add(ItemsSearch("https://i.pinimg.com/236x/35/68/dc/3568dccde41e5545125b0e01823189c0.jpg", "Mèo đáng yêu")) // Mèo đáng yêu
        popular.add(ItemsSearch("https://i.pinimg.com/236x/2f/e3/e7/2fe3e7df41d61ab571538591967e5899.jpg", "Couple")) // Couple
        popular.add(ItemsSearch("https://i.pinimg.com/236x/96/9b/16/969b16354b88549fbced081f19b2da4f.jpg", "Pink Venom")) // Pink Venom
        return popular
    }
}

