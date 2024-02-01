package com.android.android_widgetes;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toolbar;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class home2Activity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button btn_imageSwitcher;
    int imageSwitcherImages[] = {R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8};
    int switcherImageLength = imageSwitcherImages.length;
    int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        btn_imageSwitcher = findViewById(R.id.btn_imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));

                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.image2);

                return switcherImageView;
            }
        });

        // adding some animation to the image sliding process.
        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        imageSwitcher.setOutAnimation(aniOut);
        imageSwitcher.setInAnimation(aniIn);

        btn_imageSwitcher.setOnClickListener(v ->{
            counter++;
            if (counter == switcherImageLength) {
                counter = 0;
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);
            } else {
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);
            }
        });

    }

}