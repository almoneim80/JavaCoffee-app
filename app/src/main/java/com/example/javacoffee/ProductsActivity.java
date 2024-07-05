package com.example.javacoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    ArrayList<String> name , price , desc,img;
    MyDataBase myDataBase;
    Products1Adapter products1Adapter;
    ArrayList<Products1_table> products;
    Button main_btn , add_btn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        main_btn = findViewById(R.id.home_main_btn);
        add_btn =findViewById(R.id.home_add_btn);
        recyclerView = findViewById(R.id.products_recyclerView);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductsActivity.this , NewProducts.class));
            }
        });

        myDataBase =new MyDataBase(this);
        recyclerView = findViewById(R.id.products_recyclerView);
        products1Adapter = new Products1Adapter(this,products);
        recyclerView.setAdapter(products1Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        ArrayList<Products1_table> products1_tables = myDataBase.getAllContacts();
        Products1Adapter productsAdapter1 = new Products1Adapter(this,products1_tables);
        recyclerView.setAdapter(productsAdapter1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
}