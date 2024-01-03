package com.example.db

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.db.databinding.ActivityMainBinding
import com.example.db.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDataBinding
    private lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        sp = getSharedPreferences("my_sp" , MODE_PRIVATE)
        setContentView(binding.root)


        val name = sp.getString("sp_name",null)
        val age = sp.getInt("sp_age",0)

        binding.name.setText(name)

        if(age!=0){
            binding.age.setText(age.toString())
        }
    }
}