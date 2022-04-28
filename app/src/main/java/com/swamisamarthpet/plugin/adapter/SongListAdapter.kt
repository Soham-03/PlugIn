package com.swamisamarthpet.plugin.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.util.Song

class SongListAdapter(private val songList:ArrayList<Song>):
    RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.song_list_single_row, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val currentSong = songList[position]
        holder.txtSongName.text = currentSong.songName
        holder.txtArtistName.text = currentSong.songArtistName
        holder.itemView.setOnClickListener {
            it.setBackgroundResource(R.drawable.bg_song_selected_list)
        }
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class SongViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txtSongName: TextView = itemView.findViewById(R.id.txtSongName)
        val txtArtistName: TextView = itemView.findViewById(R.id.txtArtistName)
    }

}