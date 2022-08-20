package com.example.examenfinal2.Buscador

import android.media.Image
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal2.databinding.ItemChampBinding
import com.squareup.picasso.Picasso

class champViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val binding = ItemChampBinding.bind(view)

    fun bing(image: String){
        Picasso.get().load(image).into(binding.ivcampeon)
    }
}