package com.example.examenfinal2.Adapter

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenfinal2.Regiones.SuperRegiones
import com.example.examenfinal2.databinding.ItemSuperregionesBinding

class SuperRegionesViewHolder(view: View):RecyclerView.ViewHolder(view){
    val binding = ItemSuperregionesBinding.bind(view)

    fun render(item: SuperRegiones,
               onClickListener: (SuperRegiones) -> Unit,){
        binding.texname.text=item.superregiones
        Glide.with(binding.ivsuperreig.context).load(item.photo).into(binding.ivsuperreig)

        binding.ivsuperreig.setOnClickListener{
            onClickListener(item)
        }

    }
}