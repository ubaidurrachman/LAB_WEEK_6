package com.ubai.lab_week_6

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader(private val context: Context) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView): Unit { // <-- Tambahkan : Unit
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)
    }
}