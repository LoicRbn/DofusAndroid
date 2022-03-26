package com.example.dofus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dofus.`object`.monster
import kotlin.math.roundToInt

class RecyclerAdapterMonster(val context: Context) : RecyclerView.Adapter<RecyclerAdapterMonster.ViewHolderMonster>() {


    var monster : List<monster> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterMonster.ViewHolderMonster {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_monster,parent,false)
        return ViewHolderMonster(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerAdapterMonster.ViewHolderMonster, position: Int) {
        holder.item_monsterName.text = monster[position].name
        if (monster[position].pvMax.roundToInt() == 0){
            holder.item_PV.text = "PV : ${monster[position].pvMin.roundToInt()}"
        }
        else{
            holder.item_PV.text = "PV : ${monster[position].pvMin.roundToInt()}  - ${monster[position].pvMax.roundToInt()}"
        }
        holder.item_PA.text = "PA : ${monster[position].paMin.roundToInt()} "
        holder.item_PM.text = "PM : ${monster[position].pmMin.roundToInt()} "


        val image = monster[position].imgUrl
        val holderTest = holder.itemImage
        Glide.with(context)
            .load(image)
            .into(holderTest)
    }

    fun setMonsters(monster: List<monster>){
        this.monster = monster
        notifyDataSetChanged()
    }

    fun setNameMonsters(monster: List<monster>){
        this.monster = monster
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return monster.size
    }

    inner class ViewHolderMonster(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var item_monsterName: TextView
        var item_PV :TextView
        var item_PA :TextView
        var item_PM :TextView
        init {

            itemImage = itemView.findViewById(R.id.item_monsterImage)
            item_monsterName = itemView.findViewById(R.id.item_monsterName)
            item_PV = itemView.findViewById(R.id.item_monsterPV)
            item_PA = itemView.findViewById(R.id.item_monsterPA)
            item_PM = itemView.findViewById(R.id.item_monsterPM)

        }
    }
}