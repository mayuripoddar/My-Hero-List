package com.example.myherolist.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.myherolist.R
import com.example.myherolist.models.Hero

class HeroesAdaptor(internal var mCtx: Context, internal var heroList: List<Hero>) : RecyclerView.Adapter<HeroesAdaptor.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]

        Glide.with(mCtx)
                .load(hero.imageurl)
                .into(holder.imageView)

        holder.textView.text = hero.name
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var imageView: ImageView
        internal var textView: TextView

        init {

            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
        }
    }
}
