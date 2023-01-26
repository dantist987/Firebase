package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebase = FirebaseDatabase.getInstance().getReference("User")

        binding.buttonAuth.setOnClickListener {
            val id = firebase.key
            val name = binding.editTextFirstName.toString()
            val secondName = binding.editTextSecondName.toString()
            val email = binding.editTextEmail.toString()

            val user = id?.let { it1 -> User(it1, name, secondName, email) }

            firebase.push().setValue(user)
        }
    }
}