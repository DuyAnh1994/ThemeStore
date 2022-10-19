package ai.ftech.themestore

import android.annotation.SuppressLint
import android.media.MediaMetadataRetriever
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util


class TestActivity : AppCompatActivity(), Player.Listener {
   private var mPlayer : SimpleExoPlayer? = null
   private lateinit var playerView: PlayerView
//   private lateinit var ivTest : ImageView

   private val urlVideo : String = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        playerView = findViewById(R.id.exoVideo)

//        ivTest = findViewById(R.id.ivTest)
//        val retriever = MediaMetadataRetriever()
//        retriever.setDataSource(urlVideo, HashMap())
//        val image = retriever.getFrameAtTime(2000000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
//
//        ivTest.setImageBitmap(image)


    }

    fun initPlayer(){
        mPlayer = SimpleExoPlayer.Builder(this).build()

        playerView.player = mPlayer

        mPlayer?.playWhenReady = true

        mPlayer?.setMediaSource(buildMediaSource())

        mPlayer?.prepare()
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT < 24 || mPlayer == null) {
            initPlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }


    private fun releasePlayer() {
        if (mPlayer == null) {
            return
        }
        //release player when done
        mPlayer!!.release()
        mPlayer = null
    }

    private fun buildMediaSource(): MediaSource {
        val data : DataSource.Factory = DefaultHttpDataSource.Factory()
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(data)
            .createMediaSource(MediaItem.fromUri(urlVideo))
        return mediaSource
    }

}

