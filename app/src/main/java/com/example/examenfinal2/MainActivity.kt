package com.example.examenfinal2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal2.Adapter.SuperRegionesAdapter
import com.example.examenfinal2.Buscador.ListaChamp
import com.example.examenfinal2.Regiones.SuperRegiones
import com.example.examenfinal2.Regiones.SuperRegionesProvider
import com.example.examenfinal2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        binding.legends.layoutManager = LinearLayoutManager(this)
        binding.legends.adapter= SuperRegionesAdapter(SuperRegionesProvider.SuperRegionesList) {
            onItemClick(
                it
            )
        }
    }

    private fun onItemClick(item: SuperRegiones) {
        val intent = Intent(this, ListaChamp::class.java).apply {
             putExtra("id", item.photo)
         }
         startActivity(intent)
    }


}