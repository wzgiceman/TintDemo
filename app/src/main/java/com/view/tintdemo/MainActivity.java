package com.view.tintdemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ImageButton img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.img_normal);
        img2 = (ImageButton) findViewById(R.id.img_click);

        final Drawable originBitmapDrawable = getResources().getDrawable(R.drawable.electric).mutate();
        img1.setImageDrawable(tintDrawable(originBitmapDrawable, ColorStateList.valueOf(Color.GREEN)));

        final Drawable originBitmapDrawable2 = getResources().getDrawable(R.drawable.electric).mutate();
        img2.setImageDrawable(tintDrawable(originBitmapDrawable2, getResources().getColorStateList(R.color.select_click)));
    }


    /**
     * tint着色方法
     *
     * @param drawable
     * @param color
     * @return
     */
    public Drawable tintDrawable(Drawable drawable, ColorStateList color) {
        final Drawable tempDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(tempDrawable, color);
        return tempDrawable;
    }
}
