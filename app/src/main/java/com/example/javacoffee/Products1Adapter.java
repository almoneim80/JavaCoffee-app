package com.example.javacoffee;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class Products1Adapter extends RecyclerView.Adapter<Products1Adapter.ViewHolder> {
    MyDataBase myDataBase;
    Products1_table pt;
    private Context context;
    private ArrayList<Products1_table> products = null;

    public Products1Adapter(Context context, ArrayList<Products1_table> products) {
        this.context = context;
        this.products = products;
    }


    @NonNull
    @Override
    public Products1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_coffee_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Products1Adapter.ViewHolder holder, int position) {
        pt = products.get(position);

        holder.name_id.setText(String.valueOf(pt.getName()));
        holder.price_id.setText(String.valueOf(pt.getPrice()));
        holder.desc_id.setText(String.valueOf(pt.getDescription()));
        holder.name_id.setTag(pt.getName());

        Bitmap bitmap = BitmapFactory.decodeByteArray(pt.getImage(), 0, pt.getImage().length);
        holder.img_id.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_id;
        TextView name_id, price_id, desc_id;
        Button AddToCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.name_tv);
            price_id = itemView.findViewById(R.id.price_tv);
            desc_id = itemView.findViewById(R.id.desc_tv);
            img_id = itemView.findViewById(R.id.product_img);
            AddToCard = itemView.findViewById(R.id.custom_add_coffee_btn);
        }
    }
}
