package com.example.app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.Model.Ciudad
import com.example.app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_first.view.*


class MyCiudadAdapter(private val context: Context, private val ciudadList: MutableList<Ciudad>): RecyclerView.Adapter<MyCiudadAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.fragment_first, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //Picasso.get().load(ciudadList[position].nombre).into(holder.image)
        //if (ciudadList[position].Nombre == "Bogotá" || ciudadList[position].Nombre == "Medellin"
            //|| ciudadList[position].Nombre == "Ibague"|| ciudadList[position].Nombre == "Tunja"){
            holder.txt_name.text = ciudadList[position].Nombre


       // }


    }

    override fun getItemCount(): Int {
        return ciudadList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var txt_name: TextView

        init {
            image = itemView.image_ciudad
            txt_name = itemView.txt_name
        }

    }
}