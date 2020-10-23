package io.office.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("url", "error")
    fun loadImage(imageView: ImageView, uri: String?, errorImage: Drawable) {
        Glide.with(imageView)
            .load(uri)
            .error(errorImage)
            .circleCrop()
            .into(imageView)
    }
}