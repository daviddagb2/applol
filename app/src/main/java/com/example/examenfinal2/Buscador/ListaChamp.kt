package com.example.examenfinal2.Buscador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenfinal2.R
import com.example.examenfinal2.databinding.ActivityListaChampBinding
import com.example.examenfinal2.databinding.ActivityMainBinding
import com.example.examenfinal2.databinding.ItemChampBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.temporal.TemporalQueries
import kotlin.contracts.Returns

class ListaChamp : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityListaChampBinding
    private lateinit var adapter: champAdapter
    private val champimages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.listChamp.setOnQueryTextListener(this)
        IniReciclerView()

    }
    private fun IniReciclerView() {
        adapter = champAdapter(champimages)
        binding.legend2.layoutManager = LinearLayoutManager(this)
        binding.legend2.adapter = adapter
    }

    // con esto estamos haciedo la peticion a la api
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/cdn")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //setOn

    private fun searbyname(query:String){
      CoroutineScope(Dispatchers.IO).launch {
          val call = getRetrofit().create(ApiServisLOL::class.java).getChamps("$query/img/champion/loading/")
          val campiones = call.body()
          runOnUiThread{

              if(call.isSuccessful){
                  //Show ReciclerView
                  val imag = campiones?.data?:emptyList()
                  champimages.clear()
                  champimages.addAll(champimages)
                  adapter.notifyDataSetChanged()

              }else{
                  ShowError()
              }
          }
      }
    }

    private fun ShowError() {
        Toast.makeText(this, "ah ocurrido un error" , Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
        if(!query.isNullOrEmpty()){
            searbyname(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
        return true
    }

}