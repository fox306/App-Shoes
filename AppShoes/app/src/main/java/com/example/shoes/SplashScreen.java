package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class SplashScreen extends AppCompatActivity {
    Button button;
    TextView text1, text2;
    Animation toptoBottom, bottomToTop;
    RoundedImageView roundedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        button = findViewById(R.id.startButton);
        text1 = findViewById(R.id.title1);
        text2 = findViewById(R.id.subTitle1);
        roundedImageView = findViewById(R.id.splashScreen);

        toptoBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom_anim);
        bottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top_anim);

        text1.setAnimation(bottomToTop);
        text2.setAnimation(bottomToTop);
        button.setAnimation(bottomToTop);
        roundedImageView.setAnimation(toptoBottom);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}