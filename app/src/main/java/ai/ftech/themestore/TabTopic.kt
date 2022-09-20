package ai.ftech.themestore

import ai.ftech.themestore.fragment.TopicFragment
import androidx.fragment.app.Fragment

data class TabTopic(
     val fragment: Fragment,
     val string: String = ""
    ) {

}
