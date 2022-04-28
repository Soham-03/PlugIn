package com.swamisamarthpet.plugin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.databinding.FragmentLyricsBinding

class LyricsFragment : Fragment() {
    private lateinit var binding: FragmentLyricsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLyricsBinding.inflate(inflater,container,false)

        return binding.root
    }

}