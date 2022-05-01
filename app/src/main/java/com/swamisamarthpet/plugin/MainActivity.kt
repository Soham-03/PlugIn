package com.swamisamarthpet.plugin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.swamisamarthpet.plugin.adapter.ViewpagerAdapter
import com.swamisamarthpet.plugin.databinding.ActivityMainBinding
import com.swamisamarthpet.plugin.fragment.HomeFragment
import com.swamisamarthpet.plugin.fragment.LyricsFragment
import com.swamisamarthpet.plugin.fragment.UpNextFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: ViewpagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val fragmentsList = arrayListOf<Fragment>(
            HomeFragment(),
            UpNextFragment(),
            LyricsFragment()
        )
        adapter = ViewpagerAdapter(fragmentsList,supportFragmentManager,lifecycle)
        binding.apply {
            navigationBarMainActivity.selectedItemId = R.id.home
            viewPagerMainActivity.adapter = adapter
            viewPagerMainActivity.isUserInputEnabled = false
            navigationBarMainActivity.setOnItemSelectedListener { item->
                when(item.itemId){
                    R.id.home-> viewPagerMainActivity.currentItem = 0
                    R.id.search-> viewPagerMainActivity.currentItem = 1
                    R.id.library -> viewPagerMainActivity.currentItem = 2
                }
                true
            }
        }

        setContentView(binding.root)
    }
}