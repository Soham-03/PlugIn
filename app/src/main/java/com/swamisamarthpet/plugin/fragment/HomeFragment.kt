package com.swamisamarthpet.plugin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.adapter.HorizontalAdapter
import com.swamisamarthpet.plugin.databinding.FragmentHomeBinding
import com.swamisamarthpet.plugin.util.Song

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var horizontalAdapter:HorizontalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        val songList = ArrayList<Song>().apply {
            for(i in 0..17){
                add(Song("A thousand years","Cristina perri"))
            }
        }

        binding.apply {

            horizontalAdapter = HorizontalAdapter(songList)

            recyclerViewMadeForUser.layoutManager = LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,false)
            recyclerViewMadeForUser.adapter = horizontalAdapter

            recyclerViewBollywoodTrip.layoutManager = LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,false)
            recyclerViewBollywoodTrip.adapter = horizontalAdapter

            recyclerViewNewlyAdded.layoutManager = LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,false)
            recyclerViewNewlyAdded.adapter = horizontalAdapter
        }

        return binding.root
    }

}