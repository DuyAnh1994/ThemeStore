package ai.ftech.themestore

import ai.ftech.themestore.login.AccountLoginActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignUpAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_account)

        var tvLoginNow : TextView = findViewById(R.id.tvLoginNow)
        tvLoginNow.setOnClickListener{
            val intent: Intent = Intent(this, AccountLoginActivity::class.java)
            startActivity(intent)
        }
    }
}
