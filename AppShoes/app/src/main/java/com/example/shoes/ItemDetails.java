package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

public class ItemDetails extends AppCompatActivity {
    ImageView itemImage;
    TextView category, name, text, price;
    TabLayout tabSize;
    EditText size;
    String mId, mImage, mCategory, mName, mText, mPrice, mSize;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        itemImage = findViewById(R.id.imageDetails);
        category = findViewById(R.id.category_details);
        name = findViewById(R.id.titleDetail);
        text = findViewById(R.id.textDetails);
        price = findViewById(R.id.price);
        btnBuy = findViewById(R.id.btnBuy);
        size = findViewById(R.id.textSize);
        tabSize = findViewById(R.id.tabLayout);

        mId = getIntent().getStringExtra("itemId");
        mImage = getIntent().getStringExtra("imageId");
        mCategory = getIntent().getStringExtra("categoryId");
        mName = getIntent().getStringExtra("nameId");
        mText = getIntent().getStringExtra("textId");
        mPrice = getIntent().getStringExtra("priceId");

        Glide.with(this).load(mImage).into(itemImage);
        category.setText(mCategory);
        name.setText(mName);
        text.setText(mText);
        price.setText(mPrice);

        tabSize.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        size.setText("37");
                        return;
                    case 2:
                        size.setText("38");
                        return;
                    case 3:
                        size.setText("39");
                        return;
                    case 4:
                        size.setText("40");
                        return;
                    default:
                        size.setText("36");
                        return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSize = size.getText().toString();
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                i.putExtra("name", mName);
                i.putExtra("price", mPrice);
                i.putExtra("mSize", mSize);
                startActivity(i);
            }
        });
    }
}