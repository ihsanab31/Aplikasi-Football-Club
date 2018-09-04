package com.ofal.ihsan.pelatihan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const  val JUDUL = "judul"
        const  val GAMBAR = "gambar"
        const  val DESKRIPSI = "deskripsi"
    }
    private var judul:String = ""
    private var logo: Int = 0
    private var deskripsi: String =""

    lateinit var  judulTextView: TextView
    lateinit var logoImageView: ImageView
    lateinit var deskripsiTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(14)

            logoImageView = imageView().
                    lparams(width =dip(100), height = wrapContent){
                        gravity = Gravity.CENTER
                    }
            judulTextView = textView().
                    lparams(width= wrapContent){
                        gravity= Gravity.CENTER
                        topMargin =dip(10)
                    }
            deskripsiTextView =textView().
                    lparams(width= wrapContent){
                        topMargin= dip(20)
                        leftMargin=dip(20)
                        rightMargin=dip(20)
                    }

        }
        logo = intent.getIntExtra(GAMBAR, 0)
        judul = intent.getStringExtra(JUDUL)
        deskripsi = intent.getStringExtra(DESKRIPSI)

        Glide.with(logoImageView).load(logo).into(logoImageView)
        judulTextView.text= judul
        deskripsiTextView.text = deskripsi
    }
}
