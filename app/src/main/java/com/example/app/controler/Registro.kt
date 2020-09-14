package com.example.app.controler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.app.R
import com.example.app.iu.MainActivity
import kotlinx.android.synthetic.main.activity_registro.*


class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //val binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)


        val btRegistro = findViewById<Button>(R.id.btRegistro)
        val oIntent = Intent(this, MainActivity::class.java)

        btRegistro.setOnClickListener( View.OnClickListener {
            if (ValidarCampos(etNombre) && ValidarCampos(etCorreo) && ValidarCampos(etContraseña)) {
            startActivity(oIntent)
            }else{
              Toast.makeText(this, "Los datos son obligatorios", Toast.LENGTH_LONG).show()
             }
        })

    }
    fun ValidarCampos(dato: EditText):Boolean{
        if (dato.text.isNullOrEmpty()){
            return false
        }else{
            return true
        }

    }
}