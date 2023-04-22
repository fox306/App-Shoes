package com.example.shoes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class OrderActivity extends AppCompatActivity {
    TextView name, price, size;

    String coba1, coba2, coba3;

    Button cancelOrder;

    AlertDialog alertDialog;

    TextView randomOrder;

    int randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        name = findViewById(R.id.nameOrder);
        price = findViewById(R.id.priceOrder);
        size = findViewById(R.id.sizeOrder);
        cancelOrder = findViewById(R.id.cancelButtonOrder);
        randomOrder = findViewById(R.id.numberOrder);

        coba1 = getIntent().getStringExtra("name");
        coba2 = getIntent().getStringExtra("price");
        size.setText(getIntent().getStringExtra("mSize"));

        name.setText(coba1);
        price.setText(coba2);

        Random random = new Random();
        randomNum = random.nextInt(1234567891 - 12345) + 123;

        randomOrder.setText(String.valueOf(randomNum));

        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOrderSuccessDialog();
            }
        });
    }
    private void showOrderSuccessDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(
                R.layout.success_alert_dialog,
                (ViewGroup) findViewById(R.id.alertDialogSuccess)
        );

        builder.setView(view);

        alertDialog = builder.create();

        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        view.findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        alertDialog.show();
    }
}