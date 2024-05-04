package com.example.e_comerceApp.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

@BindingAdapter("imageFromUrl")

fun setImageFromUrl(imageView: ImageView, url: String?){
    if (url.isNullOrEmpty()) return

    val shimmer = Shimmer.AlphaHighlightBuilder()
        .setDuration(1000) // time to do one full sweep
        .setBaseAlpha(0.9f) // the alpha of the underlying children
        .setHighlightAlpha(0.6f) // the shimmer alpha amount
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()

    val shimmerDrawable = ShimmerDrawable()
    shimmerDrawable.setShimmer(shimmer)

    Glide
        .with(imageView)
        .load(url)
        .placeholder(shimmerDrawable)
        .into(imageView)
}