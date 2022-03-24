package com.example.dofus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofus.API.Api
import com.example.dofus.`object`.monster
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var typeSelect : String? = null

class MonsterActivity : AppCompatActivity() {

    lateinit var recyclerAdapter: RecyclerAdapterMonster

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster)

        val monster : ArrayList<monster> = ArrayList()
        var minHP : Double = 0.0
        var maxHP : Double = 0.0
        var minPA : Double = 0.0
        var maxPA : Double = 0.0
        var minPM : Double = 0.0
        var maxPM : Double = 0.0

        val extras = intent.extras
        if (extras != null) {
            typeSelect = extras.getString("type")
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMonster)

        recyclerAdapter= RecyclerAdapterMonster(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = Api.create().getListMonsters()
        apiInterface.enqueue(object : Callback<List<monster>> {
            override fun onResponse(call: Call<List<monster>>, response: Response<List<monster>>) {
                if (response.body() != null) {
                    val allMonster = response.body()
                    if (allMonster != null) {
                        for (monstreType in allMonster){
                            if(typeSelect == monstreType.type){
                                val stats = monstreType.stat
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
                                monster.add(monster("",monstreType.name,monstreType.imgUrl,
                                    monstreType.stat, minHP, maxHP,minPA, maxPA,minPM,maxPM))
                            }
                        }
                    }
                    recyclerAdapter.setMonsters(monster)
                }
            }
            override fun onFailure(call: Call<List<monster>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}