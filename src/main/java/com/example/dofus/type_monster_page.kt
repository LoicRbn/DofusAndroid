package com.example.dofus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofus.API.Api
import com.example.dofus.`object`.monster
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Type_monster_page : AppCompatActivity() {

    lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_monster_page)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = Api.create().getListMonsters()
        apiInterface.enqueue(object : Callback<List<monster>> {
            override fun onResponse(call: Call<List<monster>>, response: Response<List<monster>>) {
                if (response.body() != null) {
                    Log.e("response Json", "${response.body()}")
                    val jack = response.body()!!.distinctBy { it.type }

                    recyclerAdapter.setTypeMonsters(jack)
                    //recyclerAdapter.setTypeMonsters(response.body()!!)
                }
            }
            override fun onFailure(call: Call<List<monster>>, t: Throwable) {
                Log.e("Yo","FailureTypeMonsterActivity")
            }
        })
    }
}