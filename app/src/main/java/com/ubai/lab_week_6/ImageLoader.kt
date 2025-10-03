package com.ubai.lab_week_6

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView): Unit // <-- Tambahkan : Unit
}