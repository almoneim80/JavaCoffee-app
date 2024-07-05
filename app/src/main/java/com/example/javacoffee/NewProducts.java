package com.example.javacoffee;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class NewProducts extends AppCompatActivity {

    ImageButton imgBTN;
    EditText Name_et,Price_et,Desc_et;
    Button add_btn;
    MyDataBase myDataBase;
    Uri imageUri;
    byte[] image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_products);

        Name_et = findViewById(R.id.NewProducts_Name);
        Price_et = findViewById(R.id.NewProducts_price);
        Desc_et = findViewById(R.id.NewProducts_desc);
        imgBTN = findViewById(R.id.NewProducts_imgbtn);
        add_btn = findViewById(R.id.NewProducts_BTN1);

        myDataBase = new MyDataBase(this);

        imgBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name_et.getText().toString();
                String price = Price_et.getText().toString();
                String desc = Desc_et.getText().toString();


                BitmapDrawable drawable = (BitmapDrawable) imgBTN.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                image = getBytes(bitmap);


                Products1_table pt = new Products1_table(name,price,desc,image);

                Boolean checkInsert = myDataBase.insert_product(pt);
                if(checkInsert == true)
                {
                    Toast.makeText(NewProducts.this,"تم أضافة صنف جديد بنجاح",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NewProducts.this , ProductsActivity.class));
                }
                else
                {
                    Toast.makeText(NewProducts.this,"لم يتم أضافة صنف جديد",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            if(data != null)
            {
                imageUri = data.getData();
                try{
                    InputStream inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    imgBTN.setImageBitmap(decodeStream);
                }
                catch (Exception ex)
                {
                    Log.e("ex" ,ex.getMessage());
                }

            }

        }
    }
}