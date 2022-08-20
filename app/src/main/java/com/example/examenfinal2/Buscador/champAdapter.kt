package com.example.examenfinal2.Buscador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal2.R

class champAdapter (val campeones:List<String>): RecyclerView.Adapter<champViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): champViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return champViewHolder(layoutInflater.inflate(R.layout.item_champ, parent, false))
    }

    override fun onBindViewHolder(holder: champViewHolder, position: Int) {
        val item: String = campeones[position]
        holder.bing(item)
    }

    override fun getItemCount(): Int = campeones.size

}