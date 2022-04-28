package com.swamisamarthpet.plugin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.adapter.SongListAdapter
import com.swamisamarthpet.plugin.databinding.FragmentUpNextBinding
import com.swamisamarthpet.plugin.util.Song

class UpNextFragment : Fragment() {
   private lateinit var binding:FragmentUpNextBinding
    private lateinit var adapter:SongListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpNextBinding.inflate(inflater,container,false)
        val songList = ArrayList<Song>().apply {
            for(i in 0..17){
                add(Song("A thousand years","Cristina perri"))
            }
        }
        binding.apply {
            recyclerViewUpNextFrag.layoutManager = LinearLayoutManager(activity)
            adapter = SongListAdapter(songList)
            recyclerViewUpNextFrag.adapter = adapter
        }


        return binding.root
    }

}