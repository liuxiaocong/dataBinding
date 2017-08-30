package com.example.evanliu.databinder;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by xiaoconglau on 30/08/2017.
 */

public class Binder {
    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrlText(TextView textView, String url) {
        textView.setText(url);
    }
}
