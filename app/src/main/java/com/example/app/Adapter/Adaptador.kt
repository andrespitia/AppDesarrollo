package com.example.app.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.app.P_Fragment
import com.example.app.S_Fragment

class adaptador(fa: FragmentActivity): FragmentStateAdapter(fa) {

    companion object {
        private const val ARG_OBJECT = "object"
    }

    //cantidad de fragmens que vamos a colocarl
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        //intercambio de fragmen
        return when(position){
           0-> {
               P_Fragment()
           }
           1-> {
               S_Fragment()
           }
          2-> {
              P_Fragment()
          }
          else -> P_Fragment()
        }

    }

}
