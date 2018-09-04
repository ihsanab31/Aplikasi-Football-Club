package com.ofal.ihsan.pelatihan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ofal.ihsan.pelatihan.R.array.*
import com.ofal.ihsan.pelatihan.adapter.RecyclerViewAdapter
import com.ofal.ihsan.pelatihan.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {itemClicked(it)}

    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_description)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
    private fun itemClicked(items: Item){
        startActivity<DetailActivity>(DetailActivity.JUDUL to items.name, DetailActivity.GAMBAR to items.image, DetailActivity.DESKRIPSI to items.description)
    }
}
