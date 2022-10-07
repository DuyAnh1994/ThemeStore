package ai.ftech.themestore.login

import ai.ftech.themestore.R
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class AccountLoginActivity : AppCompatActivity() {
    private  lateinit var edtEnterEmail: EditText
    private lateinit var edtEnterPassword : EditText
    private lateinit var btLogin : Button
    private lateinit var cbRemember : CheckBox
    private lateinit var sharedPreferences: SharedPreferences

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
                Toast.makeText(this, "Dang nhap thanh cong", Toast.LENGTH_LONG).show()
                if(cbRemember.isChecked){ // nếu click remember -> lưu
                    val editor : SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.putBoolean("statusCheckbox", true) // lưu trạng thái của checkbox
                    editor.commit()
                }else{
                    val editor : SharedPreferences.Editor = sharedPreferences.edit()
                    editor.remove("email")
                    editor.remove("password")
                    editor.remove("statusCheckbox")
                    editor.commit()
                }
            }
            else{
                Toast.makeText(this, "Sai email hoac password", Toast.LENGTH_LONG).show()
            }
        }
    }


}
