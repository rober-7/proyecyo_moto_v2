package com.example.proyectocascosmoto.adaptadores

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.proyectocascosmoto.R
import com.example.proyectocascosmoto.actividades.Modelos
import com.example.proyectocascosmoto.clasesdatos.Tipo




class AdaptadorTipos(private var lista: ArrayList<Tipo>, private var contexto: Context) :
    RecyclerView.Adapter<AdaptadorTipos.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.elementos_lista_tipos, parent, false))
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    inner class ViewHolder(private var vista: View) : RecyclerView.ViewHolder(vista) {
        fun bind(tipo: Tipo) {
            vista.findViewById<TextView>(R.id.eltTvTipo).text = tipo.nombre
            vista.setOnClickListener{
                contexto.startActivity(Intent(contexto, Modelos::class.java).putExtra("tip", tipo))
            }
        }
    }
}