package com.dzaki_aryavega.wisata_jepang

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterGambar (
    private val wisataList : List<ModelGambar>,
    private val onItemClick : (ModelGambar) -> Unit
) : RecyclerView.Adapter<AdapterGambar.WisataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gambar,parent,false)
        return WisataViewHolder(view)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisata = wisataList[position]
        holder.bind(wisata, onItemClick)
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }

    inner class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaTextView : TextView = itemView.findViewById(R.id.tv_nama)
        val lokasiTextView : TextView = itemView.findViewById(R.id.tv_lokasi)
        val gambarImageView : ImageView = itemView.findViewById(R.id.iv_gambar)

        fun bind(wisata: ModelGambar, onItemClick: (ModelGambar) -> Unit){
            namaTextView.text = wisata.nama
            lokasiTextView.text = wisata.lokasi
            gambarImageView.setImageResource(wisata.gambar)

            itemView.setOnClickListener{
                onItemClick(wisata)
            }
        }
    }
}