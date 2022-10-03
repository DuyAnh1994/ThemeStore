package ai.ftech.themestore.home

import ai.ftech.themestore.detailPreview.Image

object ImageHome {
    fun listElement(): MutableList<Image> {
        val listElementHome: MutableList<Image> = mutableListOf()
        val listUrl: MutableList<String> = mutableListOf(
            "https://i.pinimg.com/236x/f2/5a/e5/f25ae5445a02133d5407392a08c70644.jpg",
            "https://i.pinimg.com/236x/ca/4e/72/ca4e7245293f384444e65544741ce787.jpg",
            "https://i.pinimg.com/236x/cf/06/02/cf0602829d1185a4e5038e917d785589.jpg",
            "https://i.pinimg.com/236x/52/97/79/529779ff57d814027d0bf1e6f57764ee.jpg",
            "https://i.pinimg.com/564x/15/f4/e3/15f4e380c0ca4e093c6992d66c2ef0ab.jpg",

            "https://i.pinimg.com/236x/fa/92/35/fa92357acf0eb53e0e4d4170a2f00cb0.jpg",
            "https://i.pinimg.com/236x/7d/ce/10/7dce10fe06a8790d8fde5db84fa0fef0.jpg",
            "https://i.pinimg.com/236x/e6/89/47/e689476d68157a3b33961489db179a81.jpg",
            "https://i.pinimg.com/236x/0c/0b/2a/0c0b2a55eb4e5d26240caf997e60e360.jpg",
            "https://i.pinimg.com/236x/e5/cf/34/e5cf343e8dbe5f3526d8b385446c1442.jpg",

            "https://i.pinimg.com/236x/af/04/fa/af04fad65ea06a814c8668c373b94348.jpg",
            "https://i.pinimg.com/236x/62/7e/aa/627eaacd1bc50428a686de5bbd93470b.jpg",
            "https://i.pinimg.com/236x/14/37/cc/1437cc4128bbc610769cacf1db5852c8.jpg",
            "https://i.pinimg.com/236x/78/f9/63/78f9631ebb6e4a2f798fe561f7126571.jpg",
            "https://i.pinimg.com/236x/9e/1b/56/9e1b567a5445db392298cd5affa4239e.jpg",

            "https://i.pinimg.com/236x/fc/52/89/fc5289db9e6f8386e8d57302a45ce236.jpg",
            "https://i.pinimg.com/736x/80/73/e9/8073e9f8bd991df447fd7c592ccb425b.jpg",
            "https://i.pinimg.com/564x/16/f7/61/16f761edf9bb3107c4bb4f67018bd3de.jpg",
            "https://i.pinimg.com/236x/3d/81/61/3d816155f3dc8b472d745bd7285c42d3.jpg",
            "https://i.pinimg.com/236x/a7/10/67/a7106735e0965396d6434f64d44d6274.jpg",

            "https://i.pinimg.com/236x/c1/f9/47/c1f94730a71def6ae34ff2221051d523.jpg",
            "https://i.pinimg.com/236x/08/b8/d4/08b8d444dfe974673f130e41d3a60227.jpg",
            "https://i.pinimg.com/236x/8e/40/0b/8e400b98d24e70651fb654401be901f0.jpg",
            "https://i.pinimg.com/236x/7b/d5/51/7bd5513b739b30611141dda4021fe593.jpg",
            "https://i.pinimg.com/236x/91/54/be/9154be20a78b27e4d4ac95c852698f5a.jpg",

            "https://i.pinimg.com/236x/cd/19/6d/cd196d33206b6e57ceaed5890c637f4a.jpg",
            "https://i.pinimg.com/236x/96/35/61/963561e016ce08da0779c7656533eefc.jpg",
            "https://i.pinimg.com/236x/fa/e5/50/fae5503352eb3050a2430dab469f80b3.jpg"
        )

        for (i in 0 until listUrl.size) {
            val image = Image().apply {
                urlImage = listUrl[i]
                if (i == 0){
                    firstItem = true
                }
                else if (i == listUrl.size - 1) {
                    lastItem = true
                }
            }
            listElementHome.add(image)
        }
        return listElementHome
    }
}
