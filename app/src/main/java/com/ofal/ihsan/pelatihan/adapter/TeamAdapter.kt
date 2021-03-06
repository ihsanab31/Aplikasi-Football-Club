package com.ofal.ihsan.pelatihan.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ofal.ihsan.pelatihan.R.layout.item_list
import com.ofal.ihsan.pelatihan.model.Team
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * on       : 04, September, 2018
 * ------------------------------
 * This class for list item
 */
class TeamAdapter(private val context: Context, private val items: List<Team>, private val listener: (Team)-> Unit)
    : RecyclerView.Adapter<TeamAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size



    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer{

        fun bindItem(items: Team, listener: (Team) -> Unit) {
            name.text = items.name
            Glide.with(containerView).load(items.image).into(image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}