package com.example.myherolist

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myherolist.adaptor.HeroesAdaptor
import com.example.myherolist.viewmodels.HeroViewModel


internal class MainActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HeroesAdaptor

    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this).get<HeroViewModel>(HeroViewModel::class.java)

        model.heroes.observe(this, Observer { heroList ->
            adapter = HeroesAdaptor(this@MainActivity, heroList)
            recyclerView.adapter = adapter
        })
    }


}
