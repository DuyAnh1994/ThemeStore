package ai.ftech.themestore.login

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson

class AccountLoginActivity : AppCompatActivity() {
    private  lateinit var edtEnterEmail: EditText
    private lateinit var edtEnterPassword : EditText
    private lateinit var btLogin : Button
    private lateinit var cbRemember : CheckBox
    private lateinit var sharedPreferences: SharedPreferences

    companion object{
        private const val TAG = "AccountLoginActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_login)

        edtEnterEmail = findViewById(R.id.edtEnterEmail)
        edtEnterPassword = findViewById(R.id.edtEnterPassword)
        btLogin = findViewById(R.id.btLogin)
        cbRemember = findViewById(R.id.cbRemember)

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE)

        edtEnterEmail.setText(sharedPreferences.getString("email", ""))
        edtEnterPassword.setText(sharedPreferences.getString("password", ""))
        cbRemember.isChecked = sharedPreferences.getBoolean("statusCheckbox", false)


        btLogin.setOnClickListener {
            val email : String = edtEnterEmail.text.toString().trim()
            val password : String = edtEnterPassword.text.toString().trim()

            if(email.equals("thomnt@gmail.com") && password.equals("123456")){
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show()
                if(cbRemember.isChecked){ // nếu click remember -> lưu
                    val editor : SharedPreferences.Editor = sharedPreferences.edit()

                    val post : Post = Post()
                    val gson : Gson = Gson()
                    val json : String? = gson.toJson(post)
                  //  Log.d(TAG, "onCreate: $json")
                   editor.putString("image", json)

                    val post1s : MutableList<Post> = mutableListOf(
                        Post().apply {
                            url = ""
                            urlAvatar = "urlAvatar1"
                            nameA = "Hehe"
                            follower = "173k follower"
                            title = "Xin chao"
                            content = "content1"
                            urlAccess = "urlAccess1"
                        },
                        Post().apply {
                            url = ""
                            urlAvatar = "urlAvatar2"
                            nameA = "Hoho"
                            follower = "223k follower"
                            title = "Hello"
                            content = "content2"
                            urlAccess = "urlAccess2"
                        }
                    )
                        val json1 : String = gson.toJson(post1s)
                        Log.d(TAG, "onCreate: $json1")
                        editor.putString("image1", json1)



                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.putBoolean("statusCheckbox", true) // lưu trạng thái của checkbox
                    editor.apply()
                }else{
                    val editor : SharedPreferences.Editor = sharedPreferences.edit()
                    editor.remove("email")
                    editor.remove("password")
                    editor.remove("statusCheckbox")
                    editor.remove("image")
                    editor.apply()
                }
            }
            else{
                Toast.makeText(this, "Sai email hoặc password", Toast.LENGTH_LONG).show()
            }
        }
    }

// gọi vào phần data chứa obj đó rùi save
}
