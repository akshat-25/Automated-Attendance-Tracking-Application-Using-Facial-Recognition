package com.example.attendancetracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login1.*

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()

        val loginButton : Button = findViewById(R.id.loginBtn)
        loginButton.setOnClickListener {
            val pwd = inputPassword.text.toString().trim()
            val email = inputUsername.text.toString().trim()

            if(email.isNotEmpty() && pwd.isNotEmpty())
            {
                firebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener{

                    if(it.isSuccessful){

                        val intent = Intent(this,Home::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this,"Unable to login", Toast.LENGTH_SHORT).show()

                    }
                }
            }else{
                Toast.makeText(this,"Empty Fields  is not allowed", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null)
        {
            val intent = Intent(this,Home::class.java)
            startActivity(intent)
        }
    }
}