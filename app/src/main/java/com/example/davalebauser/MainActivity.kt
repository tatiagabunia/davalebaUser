package com.example.createuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.davalebauser.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var EmailAddress: EditText
    private lateinit var Password: EditText
    private lateinit var button: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EmailAddress = findViewById(R.id.EmailAddress)
        Password = findViewById(R.id.textPassword)
        button = findViewById(R.id.button)
        auth = FirebaseAuth.getInstance()

        button.setOnClickListener {

            auth.createUserWithEmailAndPassword(EmailAddress.text.toString(), Password.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this,"successfully created", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "failed to create", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

}