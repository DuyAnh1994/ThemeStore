package ai.ftech.themestore.home

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.ElementDetailActivity
import ai.ftech.themestore.detailPreview.Image
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ImageAdapter(
    private var context: Context
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var listImageUrls: MutableList<Image> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(40))

        Glide.with(context)
            .load(listImageUrls[position].urlImage)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_image)
            .into(holder.ivImage)

        holder.ivImage.setOnClickListener {
            val intent = Intent(context, ElementDetailActivity::class.java)
            intent.putExtra("thomnt",listImageUrls[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listImageUrls.size
    }

    fun resetData(listImageUrls: MutableList<Image>){
        this.listImageUrls.clear()
        this.listImageUrls.addAll(listImageUrls)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage: ImageView
        private var ivImageSelect: ImageView
        lateinit var sharedPreferences: SharedPreferences

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
            ivImageSelect = itemView.findViewById(R.id.ivImageSelect)

//            ivImage.setOnClickListener {
//                saveData()
//            }
        }

//        fun saveData(){
//            sharedPreferences = context.getSharedPreferences("dataImage", 0)
//            val editor : SharedPreferences.Editor = sharedPreferences.edit()
//            val gson : Gson = Gson()
//            val json : String? = gson.toJson(listImageUrls)
//            editor.putString("image", json)
//            editor.apply()
//        }
//
//        fun loadData(){
//            sharedPreferences = context.getSharedPreferences("dataImage", 0)
//            val gson : Gson = Gson()
//            val json : String? = sharedPreferences.getString("image", null)
//            val type : Type = TypeToken<MutableList<Image>>().type
//            listImageUrls = json.fromJson(json, type)
//
//        }


    }}

