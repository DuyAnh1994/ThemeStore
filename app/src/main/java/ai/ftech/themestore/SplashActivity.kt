package ai.ftech.themestore

import ai.ftech.themestore.topic.wallpapers.WallpapersAdapter
import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import java.io.InputStream
import java.net.URL

class SplashActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //delaying 3 seconds to open MainActivity


//        val ivClick : ImageView = findViewById(R.id.ivClick)
//        ivClick.setOnClickListener(){
//            action()
//        }
    }
//    fun action(){
//        val wallpaerManager = WallpaperManager.getInstance(applicationContext)
//        val ins : InputStream = URL("https://media1.nguoiduatin.vn/media/nguyen-ngoc-hoai-thanh/2021/12/28/duong-mich-tiet-lo-ly-do-ho-hung-chuyen-tinh-yeu-sau-do-vo-hon-nhan.jpg").openStream()
//        wallpaerManager.setStream(ins)
//    }
}



