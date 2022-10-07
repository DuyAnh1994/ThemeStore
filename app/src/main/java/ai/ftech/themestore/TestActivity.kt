package ai.ftech.themestore

import ai.ftech.themestore.detailPreview.Image
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson

class TestActivity : AppCompatActivity() {
    private lateinit var ivImageTest : ImageView
    private lateinit var tvTitleImage : TextView
    private lateinit var tvContentImage : TextView
    private lateinit var btImage : Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        ivImageTest = findViewById(R.id.ivImageTest)
        tvTitleImage = findViewById(R.id.tvTitleImage)
        tvContentImage = findViewById(R.id.tvContentImage)
        btImage = findViewById(R.id.btImage)


        sharedPreferences = getSharedPreferences("dataTest", MODE_PRIVATE)


        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        val gson : Gson = Gson()
        val json : String = gson.toJson(Image())
        editor.putString("MyObject", json)

        Glide.with(this).load(sharedPreferences.getString("urlImage", "")).into(ivImageTest)
        tvTitleImage.setText(sharedPreferences.getString("MyObject", ""))
        tvContentImage.setText(sharedPreferences.getString("MyObject", ""))


    }



}
