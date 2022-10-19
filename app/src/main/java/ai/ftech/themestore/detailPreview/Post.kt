package ai.ftech.themestore.detailPreview

import java.io.Serializable

class Post : Serializable {
    var check : Int = 0
    var url: String = ""
    var title: String = ""

    var id : Int = 0
    var content: String = "Day la content"
    var urlAccess: String = "https://quantrimang.com/cong-nghe/meme-la-gi-va-mot-so-meme-pho-bien-163106"

    var urlAvatar: String = "https://i.pinimg.com/236x/e6/89/47/e689476d68157a3b33961489db179a81.jpg"
    var nameA: String = "Hehe"
    var follower: String = "173k follower"


//    var firstItem: Boolean = false
//    var lastItem: Boolean = false
    fun isImage() : Boolean{
        return check == 0
    }
}


