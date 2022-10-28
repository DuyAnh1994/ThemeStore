package ai.ftech.themestore.detailPreview

import ai.ftech.themestore.Utils
import ai.ftech.themestore.home.HomeAdapter

object ListDisplay {
    fun listPost(): MutableList<HomeAdapter.Display> {
        val listPost: MutableList<HomeAdapter.Display> = mutableListOf()

        //1
        val item1 = Post().apply {
            title = "100 ảnh meme có chọn lọc"
            url = "https://i.pinimg.com/236x/ca/4e/72/ca4e7245293f384444e65544741ce787.jpg"
        }

      val bitmap1 =   if(!item1.isImage()) {
            Utils.getBitmap(item1.url)
        }else{
            null
      }

        listPost.add(
            HomeAdapter.Display(
                post = item1,
                bitmap = bitmap1
            ))


        // 2
        val item2 = Post().apply {
            check = 1
            title = "Big Buck Bunny"
            //    content = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge"
            url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        }
        val bitmap2 =   if(!item2.isImage()) {
            Utils.getBitmap(item2.url)
        }else{
            null
        }

        listPost.add(
            HomeAdapter.Display(
                post = item2,
                bitmap = bitmap2
            ))

        //3
        val item3 = Post().apply {
            title = "Meme Quỳnh aka "
            url = "https://i.pinimg.com/236x/cf/06/02/cf0602829d1185a4e5038e917d785589.jpg"
        }
        val bitmap3 =   if(!item3.isImage()) {
            Utils.getBitmap(item3.url)
        }else{
            null
        }

        listPost.add(
            HomeAdapter.Display(
                post = item3,
                bitmap = bitmap3
            ))
//4
        val item4 = Post().apply {
            check = 1
            title = "Elephant Dream"
            content = "The first Blender Open Movie from 2006"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
        }
        val bitmap4 =   if(!item4.isImage()) {
            Utils.getBitmap(item4.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item4,
                bitmap = bitmap4
            ))
//5
        val item5 = Post().apply {
            title = "100 ảnh meme có chọn lọc"
            url = "https://i.pinimg.com/236x/52/97/79/529779ff57d814027d0bf1e6f57764ee.jpg"
        }
        val bitmap5 =   if(!item5.isImage()) {
            Utils.getBitmap(item5.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item5,
                bitmap = bitmap5
            ))

        val item6 = Post().apply {
            check = 1
            title = "Big Buck Bunny"
            //    content = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge"
            url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        }
        val bitmap6 =   if(!item6.isImage()) {
            Utils.getBitmap(item6.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item6,
                bitmap = bitmap5
            ))

        val item7 = Post().apply {
            title = "Meme Quỳnh aka "
            url = "https://i.pinimg.com/236x/cf/06/02/cf0602829d1185a4e5038e917d785589.jpg"
        }
        val bitmap7 =   if(!item7.isImage()) {
            Utils.getBitmap(item7.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item7,
                bitmap = bitmap7
            ))

        val item8 = Post().apply {
            check = 1
            title = "Elephant Dream"
            content = "The first Blender Open Movie from 2006"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
        }
        val bitmap8 =   if(!item8.isImage()) {
            Utils.getBitmap(item8.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item8,
                bitmap = bitmap8
            ))

        val item9 = Post().apply {
            title = "100 ảnh meme có chọn lọc"
            url = "https://i.pinimg.com/236x/52/97/79/529779ff57d814027d0bf1e6f57764ee.jpg"
        }
        val bitmap9 =   if(!item9.isImage()) {
            Utils.getBitmap(item9.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item9,
                bitmap = bitmap9
            ))

        val item10 = Post().apply {
            check = 1
            title = "For Bigger Blazes"
            content = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For $35.\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
        }
        val bitmap10 =   if(!item10.isImage()) {
            Utils.getBitmap(item10.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item10,
                bitmap = bitmap10
            ))

        val item11 = Post().apply {
            check = 1
            title = "For Bigger Escape"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
        }
        val bitmap11 =   if(!item11.isImage()) {
            Utils.getBitmap(item11.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item11,
                bitmap = bitmap11
            ))

        val item12 = Post().apply {
            title = "Meme mèo"
            url = "https://i.pinimg.com/236x/fa/10/e9/fa10e94aecd445f775617c079c38f07c.jpg"
        }
        val bitmap12 =   if(!item12.isImage()) {
            Utils.getBitmap(item12.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item12,
                bitmap = bitmap12
            ))

        val item13 = Post().apply {
            check = 1
            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For $35.  Find out more at google.com/chromecast."
            title = "For Bigger Fun"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
        }
        val bitmap13 =   if(!item13.isImage()) {
            Utils.getBitmap(item13.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item13,
                bitmap = bitmap13
            ))

        val item14 = Post().apply {
            title = "Meme mèo"
            url = "https://i.pinimg.com/236x/7d/ce/10/7dce10fe06a8790d8fde5db84fa0fef0.jpg"
        }
        val bitmap14 =   if(!item14.isImage()) {
            Utils.getBitmap(item14.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item14,
                bitmap = bitmap14
            ))

        val item15 = Post().apply {
            check = 1
            title = "For Bigger Joyrides"
            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For $35. Learn how to use Chromecast with YouTube and more at google.com/chromecast."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"
        }
        val bitmap15 =   if(!item15.isImage()) {
            Utils.getBitmap(item15.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item15,
                bitmap = bitmap15
            ))

        val item16 = Post().apply {
            title = " Meme mèo cute"
            url = "https://i.pinimg.com/236x/e6/89/47/e689476d68157a3b33961489db179a81.jpg"
        }
        val bitmap16 =   if(!item16.isImage()) {
            Utils.getBitmap(item16.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item16,
                bitmap = bitmap16
            ))

        val item17 = Post().apply {
            check = 1
            title = "For Bigger Meltdowns"
            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For $35. Learn how to use Chromecast with Netflix and more at google.com/chromecast."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
        }
        val bitmap17 =   if(!item17.isImage()) {
            Utils.getBitmap(item17.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item17,
                bitmap = bitmap17
            ))

        val item18 = Post().apply {
            title = "300+ meme được yêu thích"
            url = "https://i.pinimg.com/236x/0c/0b/2a/0c0b2a55eb4e5d26240caf997e60e360.jpg"
        }
        val bitmap18 =   if(!item18.isImage()) {
            Utils.getBitmap(item18.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item18,
                bitmap = bitmap18
            ))

        val item19 = Post().apply {
            check = 1
            title = "Sintel"
            content = "Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender. With initial funding provided by 1000s of donations via the internet community, it has again proven to be a viable development model for both open 3D technology as for independent animation film.\nThis 15 minute film has been realized in the studio of the Amsterdam Blender Institute, by an international team of artists and developers. In addition to that, several crucial technical and creative targets have been realized online, by developers and artists and teams all over the world.\nwww.sintel.org"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
        }
        val bitmap19 =   if(!item19.isImage()) {
            Utils.getBitmap(item19.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item19,
                bitmap = bitmap19
            ))

        val item20 = Post().apply {
            check = 1
            title = "Subaru Outback On Street And Dirt"
            content = "Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"
        }
        val bitmap20 =   if(!item20.isImage()) {
            Utils.getBitmap(item20.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item20,
                bitmap = bitmap20
            ))

        val item21 = Post().apply {
            check = 1
            title = "Tears of Steel"
            content = "Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
        }
        val bitmap21 =   if(!item21.isImage()) {
            Utils.getBitmap(item21.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item21,
                bitmap = bitmap21
            ))

        val item22 = Post().apply {
            check = 1
            title = "Volkswagen GTI Review"
            content = "The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see..."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"
        }
        val bitmap22 =   if(!item22.isImage()) {
            Utils.getBitmap(item22.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item22,
                bitmap = bitmap22
            ))

        val item23 = Post().apply {
            title = "V_BTS "
            url = "https://i.pinimg.com/236x/78/f9/63/78f9631ebb6e4a2f798fe561f7126571.jpg"
        }
        val bitmap23 =   if(!item23.isImage()) {
            Utils.getBitmap(item23.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item23,
                bitmap = bitmap23
            ))

        val item24 = Post().apply {
            check = 1
            title = "We Are Going On Bullrun"
            content = "The Smoking Tire is going on the 2010 Bullrun Live Rally in a 2011 Shelby GT500, and posting a video from the road every single day! The only place to watch them is by subscribing to The Smoking Tire or watching at BlackMagicShine.com"
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4"
        }
        val bitmap24 =   if(!item24.isImage()) {
            Utils.getBitmap(item24.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item24,
                bitmap = bitmap24
            ))

        val item25 = Post().apply {
            check = 1
            title = "What care can you get for a grand?"
            content = "The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car.The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car."
            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"
        }
        val bitmap25 =   if(!item25.isImage()) {
            Utils.getBitmap(item25.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item25,
                bitmap = bitmap25
            ))

        val item26 = Post().apply {
            title = "Meme của quàng thượng và những con sen"
            url = "https://i.pinimg.com/564x/16/f7/61/16f761edf9bb3107c4bb4f67018bd3de.jpg"
        }
        val bitmap26 =   if(!item26.isImage()) {
            Utils.getBitmap(item26.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item26,
                bitmap = bitmap26
            ))

        val item27 = Post().apply {
            title = "Ảnh hoàng hôn"
            url = "https://i.pinimg.com/236x/c1/f9/47/c1f94730a71def6ae34ff2221051d523.jpg"
        }
        val bitmap27 =   if(!item27.isImage()) {
            Utils.getBitmap(item27.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item27,
                bitmap = bitmap27
            ))

        val item28 = Post().apply {
            title = "List ảnh đáng yêu Lisa BlackPink"
            url = "https://i.pinimg.com/236x/7b/d5/51/7bd5513b739b30611141dda4021fe593.jpg"
        }
        val bitmap28 =   if(!item28.isImage()) {
            Utils.getBitmap(item28.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item28,
                bitmap = bitmap28
            ))

        val item29 = Post().apply {
            title = "Meme Quỳnh Aka "
            url = "https://i.pinimg.com/236x/91/54/be/9154be20a78b27e4d4ac95c852698f5a.jpg"
        }
        val bitmap29 =   if(!item29.isImage()) {
            Utils.getBitmap(item29.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item29,
                bitmap = bitmap29
            ))

        val item30 = Post().apply {
            title = "Ảnh bầu trời đẹp"
            url = "https://i.pinimg.com/236x/96/35/61/963561e016ce08da0779c7656533eefc.jpg"
        }
        val bitmap30 =   if(!item30.isImage()) {
            Utils.getBitmap(item30.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item30,
                bitmap = bitmap30
            ))

        val item31 = Post().apply {
            title = "Top những idol nữ được bình chonj nhiều nhất"
            url = "https://i.pinimg.com/236x/cd/19/6d/cd196d33206b6e57ceaed5890c637f4a.jpg"
        }
        val bitmap31 =   if(!item31.isImage()) {
            Utils.getBitmap(item31.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item31,
                bitmap = bitmap31
            ))

        val item32 = Post().apply {
            title = "Pink Venom BlackPink"
            url = "https://i.pinimg.com/236x/fa/e5/50/fae5503352eb3050a2430dab469f80b3.jpg"
        }
        val bitmap32 =   if(!item32.isImage()) {
            Utils.getBitmap(item32.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item32,
                bitmap = bitmap32
            ))

        val item33 = Post().apply {
            title = "Kẹo ngọt"
            url = "https://i.pinimg.com/236x/89/79/9b/89799beb3abb0130c4eb206fbdb1b44e.jpg"
        }
        val bitmap33 =   if(!item33.isImage()) {
            Utils.getBitmap(item33.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item33,
                bitmap = bitmap33
            ))

        val item34 = Post().apply {
            title = "Ảnh hoa phong cảnh đẹp"
            url = "https://i.pinimg.com/236x/0b/7f/e6/0b7fe6725c4fc8f8da07bfbb8548bf2b.jpg"
        }
        val bitmap34 =   if(!item34.isImage()) {
            Utils.getBitmap(item34.url)
        }else{
            null
        }
        listPost.add(
            HomeAdapter.Display(
                post = item34,
                bitmap = bitmap34
            ))

//        val item35 = Post().apply {
//            title = "Ảnh hoa phong cảnh đẹp"
//            url = "https://i.pinimg.com/236x/0b/7f/e6/0b7fe6725c4fc8f8da07bfbb8548bf2b.jpg"
//        }
//        val bitmap35 =   if(!item35.isImage()) {
//            Utils.getBitmap(item35.url)
//        }else{
//            null
//        }
//        listPost.add(
//            HomeAdapter.Display(
//                post = item35,
//                bitmap = bitmap35
//            ))

        return listPost
    }
}























//
//        listPost.add(Post().apply {
//            check = 1
//            title = "Big Buck Bunny"
//            //    content = "Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself. When one sunny day three rodents rudely harass him, something snaps... and the rabbit ain't no bunny anymore! In the typical cartoon tradition he prepares the nasty rodents a comical revenge"
//            url = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Meme Quỳnh aka "
//            url = "https://i.pinimg.com/236x/cf/06/02/cf0602829d1185a4e5038e917d785589.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "Elephant Dream"
//            content = "The first Blender Open Movie from 2006"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "100 ảnh meme có chọn lọc"
//            url = "https://i.pinimg.com/236x/52/97/79/529779ff57d814027d0bf1e6f57764ee.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "For Bigger Blazes"
//            content = "HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV. For when you want to settle into your Iron Throne to watch the latest episodes. For $35.\nLearn how to use Chromecast with HBO GO and more at google.com/chromecast."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "100 ảnh meme có chọn lọc"
//            url = "https://i.pinimg.com/564x/15/f4/e3/15f4e380c0ca4e093c6992d66c2ef0ab.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "For Bigger Escape"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Meme mèo"
//            url = "https://i.pinimg.com/236x/fa/10/e9/fa10e94aecd445f775617c079c38f07c.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV. For $35.  Find out more at google.com/chromecast."
//            title = "For Bigger Fun"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Meme mèo"
//            url = "https://i.pinimg.com/236x/7d/ce/10/7dce10fe06a8790d8fde5db84fa0fef0.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "For Bigger Joyrides"
//            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for the times that call for bigger joyrides. For $35. Learn how to use Chromecast with YouTube and more at google.com/chromecast."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = " Meme mèo cute"
//            url = "https://i.pinimg.com/236x/e6/89/47/e689476d68157a3b33961489db179a81.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "For Bigger Meltdowns"
//            content = "Introducing Chromecast. The easiest way to enjoy online video and music on your TV—for when you want to make Buster's big meltdowns even bigger. For $35. Learn how to use Chromecast with Netflix and more at google.com/chromecast."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "300+ meme được yêu thích"
//            url = "https://i.pinimg.com/236x/0c/0b/2a/0c0b2a55eb4e5d26240caf997e60e360.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "Sintel"
//            content = "Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender. With initial funding provided by 1000s of donations via the internet community, it has again proven to be a viable development model for both open 3D technology as for independent animation film.\nThis 15 minute film has been realized in the studio of the Amsterdam Blender Institute, by an international team of artists and developers. In addition to that, several crucial technical and creative targets have been realized online, by developers and artists and teams all over the world.\nwww.sintel.org"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"
//
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "Subaru Outback On Street And Dirt"
//            content = "Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"
//
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "Tears of Steel"
//            content = "Tears of Steel was realized with crowd-funding by users of the open source 3D creation tool Blender. Target was to improve and test a complete open and free pipeline for visual effects in film - and to make a compelling sci-fi film in Amsterdam, the Netherlands.  The film itself, and all raw material used for making it, have been released under the Creatieve Commons 3.0 Attribution license. Visit the tearsofsteel.org website to find out more about this, or to purchase the 4-DVD box with a lot of extras.  (CC) Blender Foundation - http://www.tearsofsteel.org"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "Volkswagen GTI Review"
//            content = "The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see..."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "V_BTS "
//            url = "https://i.pinimg.com/236x/78/f9/63/78f9631ebb6e4a2f798fe561f7126571.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "We Are Going On Bullrun"
//            content = "The Smoking Tire is going on the 2010 Bullrun Live Rally in a 2011 Shelby GT500, and posting a video from the road every single day! The only place to watch them is by subscribing to The Smoking Tire or watching at BlackMagicShine.com"
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4"
//
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            check = 1
//            title = "What care can you get for a grand?"
//            content = "The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car.The Smoking Tire meets up with Chris and Jorge from CarsForAGrand.com to see just how far $1,000 can go when looking for a car."
//            url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Meme của quàng thượng và những con sen"
//            url = "https://i.pinimg.com/564x/16/f7/61/16f761edf9bb3107c4bb4f67018bd3de.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Ảnh hoàng hôn"
//            url = "https://i.pinimg.com/236x/c1/f9/47/c1f94730a71def6ae34ff2221051d523.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "List ảnh đáng yêu Lisa BlackPink"
//            url = "https://i.pinimg.com/236x/7b/d5/51/7bd5513b739b30611141dda4021fe593.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Meme Quỳnh Aka "
//            url = "https://i.pinimg.com/236x/91/54/be/9154be20a78b27e4d4ac95c852698f5a.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Ảnh bầu trời đẹp"
//            url = "https://i.pinimg.com/236x/96/35/61/963561e016ce08da0779c7656533eefc.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Top những idol nữ được bình chonj nhiều nhất"
//            url = "https://i.pinimg.com/236x/cd/19/6d/cd196d33206b6e57ceaed5890c637f4a.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Pink Venom BlackPink"
//            url = "https://i.pinimg.com/236x/fa/e5/50/fae5503352eb3050a2430dab469f80b3.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = " Hoa tulip đẹp"
//            url = "https://i.pinimg.com/236x/14/72/79/147279f9ab7aeb6e54d4db98feede8c2.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Kẹo ngọt"
//            url = "https://i.pinimg.com/236x/89/79/9b/89799beb3abb0130c4eb206fbdb1b44e.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//        listPost.add(Post().apply {
//            title = "Ảnh hoa phong cảnh đẹp"
//            url = "https://i.pinimg.com/236x/0b/7f/e6/0b7fe6725c4fc8f8da07bfbb8548bf2b.jpg"
//            if (!isImage()){
//                bitmap = Utils.getBitmap(url)
//            }
//        })
//
//        return listPost
//    }
//}

//        val listTitleVideo: MutableList<String> = mutableListOf(
//            "Shutdown dance cover by Ciin",
//            "Cold blood dance cover by ciin",
//            "Lisa dance Attention",
//
//            "Quynh Aka",
//            "Chú khủng long vàng siêu cute",
//            "pìu piu píu",
//
//            "Gdragon",
//            "Outfit đơn giản giúp bạn trông bạn có gu hơn",
//            "ntcong"
//        )

//        for (i in 0 until listUrlImage.size) {
//            val post = Post().apply {
//                title = listTitleImage[i]
//                    url = listUrlImage[i]
//                if(check==0){
//                    title = listTitleImage[i]
//                    url = listUrlImage[i]
//                }
//                else if (check==1){
//                    title = listTitleVideo[i]
//                    url = listUrlVideo[i]
//                }

//                if (i == 0){
//                    firstItem = true
//                }
//                else if (i == listUrl.size - 1) {
//                    lastItem = true
//                }
//            }
//            listPost.add(post)
//        }

