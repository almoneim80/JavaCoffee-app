package com.example.javacoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CustomCoffeeProduct extends AppCompatActivity {

    Button add_coffee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_coffee_product);

        add_coffee = findViewById(R.id.custom_add_coffee_btn);

        add_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomCoffeeProduct.this , Login.class));
            }
        });
    }
}
