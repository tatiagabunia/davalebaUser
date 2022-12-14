package com.example.davalebauser

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var button: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailAddress = findViewById(R.id.EmailAddress)
        password = findViewById(R.id.textPassword)
        button = findViewById(R.id.button)
        auth = FirebaseAuth.getInstance()

        button.setOnClickListener {

            auth.createUserWithEmailAndPassword(emailAddress.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this,"წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "ვერ შეიქმნა", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

}