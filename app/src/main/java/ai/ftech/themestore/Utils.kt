package ai.ftech.themestore

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.util.Log

object Utils {

    fun getBitmap(url: String): Bitmap? {
        val retriever = MediaMetadataRetriever()
       return try {
           Log.d("getBitmap", "getBitmap: $url")
            retriever.setDataSource(url, HashMap<String, String>())

            val durationVideo = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val millSecond = durationVideo?.toLong()
            var image: Bitmap? = null
            if (millSecond != null) {
                image = retriever.getFrameAtTime(
                    millSecond / 2L,
                    MediaMetadataRetriever.OPTION_CLOSEST_SYNC
                )
            }

           image
        } catch (e: Exception) {
            e.printStackTrace()
           return null
        } finally {
           retriever.release()
        }
    }
}
