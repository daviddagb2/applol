package com.example.examenfinal2.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal2.R
import com.example.examenfinal2.Regiones.SuperRegiones

class SuperRegionesAdapter (private val SuperRegionalism:List<SuperRegiones>,
                            private val onClickListener: (SuperRegiones) -> Unit,
    ): RecyclerView.Adapter<SuperRegionesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperRegionesViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return SuperRegionesViewHolder(layoutInflater.inflate(R.layout.item_superregiones,parent,false))
    }

    override fun onBindViewHolder(holder: SuperRegionesViewHolder, position: Int) {
        val item= SuperRegionalism[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int= SuperRegionalism.size
}
