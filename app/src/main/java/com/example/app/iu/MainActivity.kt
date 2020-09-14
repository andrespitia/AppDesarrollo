package com.example.app.iu

import android.app.AlertDialog
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.Adapter.MyCiudadAdapter
import com.example.app.Common.Common
import com.example.app.Interface.RetrofitServicio
import com.example.app.Model.Ciudad
import com.example.app.P_Fragment
import com.example.app.R
import com.example.app.S_Fragment
import com.example.app.Adapter.adaptador
import com.google.android.material.tabs.TabLayoutMediator
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private val adapter1 by lazy{ adaptador(this) }

    lateinit var p_Fragment: P_Fragment
    lateinit var s_Fragment: S_Fragment
    lateinit var cService: RetrofitServicio
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyCiudadAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Menu lateral

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    Toast.makeText(this, "Inicio click", Toast.LENGTH_LONG).show()
                }

                R.id.procesos ->
                    Toast.makeText(this, "Procesos click", Toast.LENGTH_LONG).show()

                R.id.notificaciones ->
                    Toast.makeText(this, "Notificaciones click", Toast.LENGTH_LONG).show()

                R.id.serrarsecion ->
                    Toast.makeText(this, "Salir click", Toast.LENGTH_LONG).show()

                }
            true

            }
        //Menu superior

        pager2.adapter = adapter1
        //estos son los atribitos que tenemos en el xml para ver el menu
        val tabLayoutMediator = TabLayoutMediator(tab_layout, pager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 ->{
                       tab.text ="PROCESOS"

                    }
                    1-> {
                       tab.text ="NOTIFICACIONES"

                    }
                }
            })
        tabLayoutMediator.attach()

        //llamdo Api

        cService = Common.retrofitServicio

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllCiudadList()



        }

    private fun getAllCiudadList() {

        cService.getListaCiudades().enqueue(object : Callback<MutableList<Ciudad>> {
            override fun onResponse(call: Call<MutableList<Ciudad>>, response: Response<MutableList<Ciudad>>) {
                adapter = MyCiudadAdapter(baseContext, response.body() as MutableList<Ciudad>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }

            override fun onFailure(call: Call<MutableList<Ciudad>>, t: Throwable) {

            }


        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (toggle.onOptionsItemSelected(item)){

        return true
    }

        return super.onOptionsItemSelected(item)
    }

}

private fun FragmentTransaction.replace(frameLayout: Int) {

}
