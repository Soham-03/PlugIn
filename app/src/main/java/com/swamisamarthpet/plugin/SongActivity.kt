package com.swamisamarthpet.plugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.swamisamarthpet.plugin.adapter.ViewpagerAdapter
import com.swamisamarthpet.plugin.databinding.ActivitySongBinding
import com.swamisamarthpet.plugin.fragment.LyricsFragment
import com.swamisamarthpet.plugin.fragment.UpNextFragment

class SongActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySongBinding
    lateinit var adapter: ViewpagerAdapter
    lateinit var behavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentList = arrayListOf<Fragment>(
            UpNextFragment(),
            LyricsFragment(),
            UpNextFragment()
        )
        adapter = ViewpagerAdapter(fragmentList,this.supportFragmentManager,this.lifecycle)
        binding = ActivitySongBinding.inflate(layoutInflater)

        binding.apply {
            viewPagerBottomSheet.adapter = adapter

            TabLayoutMediator(tabLayoutBottomSheet,viewPagerBottomSheet){ tab, position ->
                viewPagerBottomSheet.setCurrentItem(tab.position, true)
                when(position){
                    0-> tab.text = "Up Next"
                    1-> tab.text = "Lyrics"
                    2-> tab.text = "Recommended"
                }
            }.attach()

            machineDetailsBottomFrameLayout.maxHeight = (resources.displayMetrics.heightPixels - 128).toInt()

            tabLayoutBottomSheet.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    BottomSheetBehavior.from(machineDetailsBottomFrameLayout)
                        .state = BottomSheetBehavior.STATE_EXPANDED
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    BottomSheetBehavior.from(machineDetailsBottomFrameLayout)
                        .state = BottomSheetBehavior.STATE_EXPANDED
                }
            })

            behavior = BottomSheetBehavior.from(machineDetailsBottomFrameLayout)

            behavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if(newState == BottomSheetBehavior.STATE_EXPANDED){
                        btnArrowUpBottomSheet.setImageDrawable(getDrawable(R.drawable.ic_arrow_down))
                    }
                    else if (newState == BottomSheetBehavior.STATE_COLLAPSED){
                        btnArrowUpBottomSheet.setImageDrawable(getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24))
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

            })

        }

        setContentView(binding.root)
    }
}