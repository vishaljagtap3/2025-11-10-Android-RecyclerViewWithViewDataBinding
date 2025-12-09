package com.aavidsoft.recyclerview02.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("image_resource")
fun setImageResourceToImageView(imageView: ImageView, imageResourceId : Int) {
    imageView.setImageResource(imageResourceId)
}

@BindingAdapter("uppercase_text")
fun setTextInUppercase(txt : TextView, text : String) {
    txt.text = text.uppercase()
}