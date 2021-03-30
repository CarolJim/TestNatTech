package com.example.testnat.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.testnat.R
import com.example.testnat.databinding.ActivityMainBinding
import com.example.testnat.ui.adapter.MyAdapter
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        binding.tabs.addTab(binding.tabs.newTab().setText("PROMOCIONES"))
        binding.tabs.addTab(binding.tabs.newTab().setText("RECARGAS"))
        binding.tabs.addTab(binding.tabs.newTab().setText("RECAUDACION"))
        binding.tabs.addTab(binding.tabs.newTab().setText("ADMINISTRACION"))
        binding.tabs.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
        binding.tabs.tabCount)
        binding.viewpager.adapter = adapter
        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))
        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })


    }
}