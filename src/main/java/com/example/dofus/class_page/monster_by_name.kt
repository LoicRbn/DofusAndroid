package com.example.dofus.class_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofus.API.Api
import com.example.dofus.R
import com.example.dofus.RecyclerAdapterMonster
import com.example.dofus.`object`.monster
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class monster_by_name : AppCompatActivity() {

    lateinit var recyclerAdapter: RecyclerAdapterMonster
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_by_name)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val monster : ArrayList<monster> = ArrayList()
        var minHP : Double = 0.0
        var maxHP : Double = 0.0
        var minPA : Double = 0.0
        var maxPA : Double = 0.0
        var minPM : Double = 0.0
        var maxPM : Double = 0.0

        recyclerAdapter = RecyclerAdapterMonster(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = Api.create().getListMonsters()
        apiInterface.enqueue(object : Callback<List<monster>> {
            override fun onResponse(call: Call<List<monster>>, response: Response<List<monster>>) {
                if (response.body() != null) {
                    val name = response.body()!!.sortedBy { it.name }
                    if (name != null) {
                        for (monstre in name){
                            val stats = monstre.stat
                            //Log.e("Test", stats.toString())
                            for (stat in stats){
                                val pv = stat.pv
                                val pa = stat.pa
                                val pm = stat.pm
                                if(pv !=null){
                                    minHP = pv.min
                                    maxHP = pv.max
                                }
                                if(pa !=null){
                                    minPA = pa.min
                                    maxPA = pa.max
                                }
                                if(pm !=null){
                                    minPM = pm.min
                                    maxPM = pm.max
                                }
                            }
                            monster.add(monster("",monstre.name,monstre.imgUrl,monstre.stat
                                ,minHP,maxHP,minPA,maxPA,minPM,maxPM))
                            //Log.e("Test", monster.toString())
                        }
                        }
                    recyclerAdapter.setNameMonsters(monster)
                }
            }
            override fun onFailure(call: Call<List<monster>>, t: Throwable) {
            }
        })
    }
}