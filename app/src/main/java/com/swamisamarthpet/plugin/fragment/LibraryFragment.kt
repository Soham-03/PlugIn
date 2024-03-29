package com.swamisamarthpet.plugin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swamisamarthpet.plugin.R
import com.swamisamarthpet.plugin.databinding.FragmentLibraryBinding

class LibraryFragment : Fragment() {
    private lateinit var binding: FragmentLibraryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLibraryBinding.inflate(inflater,container,false)
        return binding.root
    }

}