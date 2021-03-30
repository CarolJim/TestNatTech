package com.example.testnat.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testnat.ui.fragment.Administracion
import com.example.testnat.ui.fragment.Promociones
import com.example.testnat.ui.fragment.Recargas
import com.example.testnat.ui.fragment.Recaudaciones

@Suppress("DEPRECATION")
internal class MyAdapter (
    var context : Context,
    fm : FragmentManager,
    var totalTabs : Int
        ):
    FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 ->{
                Promociones()
            }
            1 ->{
                Recargas()
            }
            3 ->{
                Recaudaciones()
            }
            4 ->{
                Administracion()
            }

            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return  totalTabs
    }


}