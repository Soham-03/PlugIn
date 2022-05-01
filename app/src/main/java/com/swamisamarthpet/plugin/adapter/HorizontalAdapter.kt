package com.swamisamarthpet.plugin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.util.Song

class HorizontalAdapter(private val songList:ArrayList<Song>):
    RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_single_row, parent, false))
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtSongName: TextView = itemView.findViewById(R.id.txtSongName)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSong = songList[position]
        holder.txtSongName.text = currentSong.songName
    }

}