package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> modelList;
    ItemAdapter itemAdapter;
    RecyclerView gridView;

    Animation topToBottom, bottomToTop;
    LinearLayout linearLayout;
    TextView title;
    ImageView loveMenu, barMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.searchBar);
        title = findViewById(R.id.titleTop);
        loveMenu = findViewById(R.id.favorite);
        barMenu = findViewById(R.id.menuBurger);

        topToBottom = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom_anim);
        bottomToTop = AnimationUtils.loadAnimation(this, R.anim.bottom_to_top_anim);

        linearLayout.setAnimation(topToBottom);
        title.setAnimation(topToBottom);
        loveMenu.setAnimation(topToBottom);
        barMenu.setAnimation(topToBottom);

        modelList = new ArrayList<>();
        //restAPi
        String resourceName = getResources().getResourceName(R.drawable.shoes);
        modelList.add(new ItemModel(1, resourceName, "Hi", "Jorden", "149$","giày vip pro"));
        modelList.add(new ItemModel(2, resourceName, "Hi", "Jorden", "149$","giày vip pro"));

        checkRun(modelList);
    }

    private void checkRun(List<ItemModel> modelList) {
        gridView = findViewById(R.id.gridView);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridView.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter(this, modelList);
        gridView.setAdapter(itemAdapter);
    }
}