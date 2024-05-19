package pnj.uts.ti.andi_rizki_mahesa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val userCredentials = hashMapOf(
        "andi@gmail.com" to "andi123",
        "michael@gmail.com" to "michael123",
        "sarah@gmail.com" to "sarah123"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signInButton = findViewById<Button>(R.id.signInButton)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateLogin(email, password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Simpan data pengguna ke SharedPreferences
                val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", email)
                editor.putString("nim", "12345678")
                editor.putString("nama", "Andi Rizki Mahesa")
                editor.putString("kelas", "TI-4A")
                editor.apply()

                // Pindah ke ProfileActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        return userCredentials[email] == password
    }
}
