package com.example.db

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import com.example.db.databinding.ActivityMainBinding
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var sp:SharedPreferences
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.saveBtn.setOnClickListener {
            startActivity(
                Intent(this,ShowDataActivity::class.java)
            )
            sp = getSharedPreferences("my_sp" , MODE_PRIVATE)
            val name = binding.name.text.toString()
            val age = binding.age.text.toString().toInt()
            val editor = sp.edit() //edit parmission
            editor.apply{
                putString("sp_name",name)
                putInt("sp_age",age)
                commit()
            }

        }
    }

}