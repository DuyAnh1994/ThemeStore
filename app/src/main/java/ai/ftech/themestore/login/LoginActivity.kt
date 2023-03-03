package ai.ftech.themestore.login

import ai.ftech.themestore.R
import ai.ftech.themestore.detailPreview.Post
import ai.ftech.themestore.home.HomeFragment
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson

class LoginActivity : AppCompatActivity(), ILoginContract.View {

    private  lateinit var edtEnterEmail: EditText
    private lateinit var edtEnterPassword : EditText
    private lateinit var btLogin : Button
    private lateinit var cbRemember : CheckBox
    private lateinit var sharedPreferences: SharedPreferences
    private var loginPresenter: LoginPresenter = LoginPresenter()

    companion object{
        private const val TAG = "AccountLoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_login)

        initView()

        loginPresenter.view = this

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE)

        edtEnterEmail.setText(sharedPreferences.getString("email", ""))
        edtEnterPassword.setText(sharedPreferences.getString("password", ""))
        cbRemember.isChecked = sharedPreferences.getBoolean("statusCheckbox", false)

        btLogin.setOnClickListener {
            val email : String = edtEnterEmail.text.toString().trim()
            val password : String = edtEnterPassword.text.toString().trim()
            if(cbRemember.isChecked){ // nếu click remember -> lưu
                val editor : SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.putBoolean("statusCheckbox", true) // lưu trạng thái của checkbox
                editor.apply()
            }else{
                val editor : SharedPreferences.Editor = sharedPreferences.edit()
                editor.remove("email")
                editor.remove("password")
                editor.remove("statusCheckbox")
                editor.apply()
            }
            loginPresenter.handleLogin(email, password)
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onLoginResult(state: LoginState, message: String) {
        when(state){
            LoginState.SUCCESS -> {
                val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.view?.setBackgroundColor(R.color.green)
                toast.show()
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
            }
            LoginState.EMPTY_EMAIL -> {
                val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.view?.setBackgroundColor(R.color.red)
                toast.show()
            }
            LoginState.INVALID_EMAIL_FORMAT -> {
                val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.view?.setBackgroundColor(R.color.red)
                toast.show()
            }
            LoginState.EMPTY_PASSWORD -> {
                val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.view?.setBackgroundColor(R.color.red)
                toast.show()
            }
            else -> {
                val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.view?.setBackgroundColor(R.color.red)
                toast.show()
            }
        }
    }

    private fun initView(){
        edtEnterEmail = findViewById(R.id.edtEnterEmail)
        edtEnterPassword = findViewById(R.id.edtEnterPassword)
        btLogin = findViewById(R.id.btLogin)
        cbRemember = findViewById(R.id.cbRemember)
    }
}
