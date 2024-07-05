package com.example.javacoffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {

    public static final String dbName = "JavaCoffeeDb.db";   //database name
    public static final int dbVersion = 3;         //database version
    byte[] imge = new byte[10000];

//#####################################################################################################################################
//    //users tabel
//    public static final String user_tabel_Name = "users";
//    public static final String Uclo_id_name = "id";
//    public static final String Uclo_Name_name = "username";
//    public static final String Uclo_PhoneNo_name = "phone_number";
//    public static final String Uclo_City_name = "city";
//    public static final String Uclo_Password_name = "password";
//   // public static final String Uclo_image_name = "Image";
//#####################################################################################################################################
    //products tabel
    public static final String products_tabel_Name = "products";

    public static final String Pclo_id_name = "Id";
    public static final String Pclo_Name_name = "Name";
    public static final String Pclo_Price_name = "Price";
    public static final String Pclo_Description_name = "Description";
     public static final String Pclo_image_name = "Image";

//#####################################################################################################################################
//Card tabel
public static final String card_tabel_Name = "Card";

    public static final String Cclo_id_name = "Id";
    public static final String Cclo_Name_name = "Name";
    public static final String Cclo_Price_name = "Price";

    //#####################################################################################################################################
    public MyDataBase(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }
    //create db.

//#####################################################################################################################################
//onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE "+user_tabel_Name+" ("+Uclo_id_name+" INTEGER PRIMARY KEY AUTOINCREMENT,"
//                +Uclo_Name_name+" Text, "+Uclo_PhoneNo_name+" INTEGER, "+Uclo_City_name+" Text , "+Uclo_Password_name+" Text)");


        db.execSQL("CREATE TABLE "+products_tabel_Name+" ("+Pclo_id_name+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Pclo_Name_name+" Text, "+Pclo_Price_name+" INTEGER,"+Pclo_Description_name+" Text , "+Pclo_image_name+" Text)");


        db.execSQL("CREATE TABLE "+card_tabel_Name+" ("+Cclo_id_name+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Cclo_Name_name+" Text, "+Cclo_Price_name+" INTEGER)");
    }
//#####################################################################################################################################
//onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists products_tabel_Name");
    }

//#####################################################################################################################################
     //insert_users
//    public boolean insert_users(users_tabel user)
//    {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Uclo_Name_name,user.getName());
//        contentValues.put(Uclo_PhoneNo_name,user.getPhoneNo());
//        contentValues.put(Uclo_City_name,user.getCity());
//        contentValues.put(Uclo_Password_name,user.getPassword());
//        //contentValues.put(clo_image_name ,user.getPassword());
//
//        //check if insert done or not
//        long result_insert = sqLiteDatabase.insert(user_tabel_Name,null,contentValues);
//        if(result_insert == -1)
//            return false;
//        return true;
//
//    }
//#####################################################################################################################################
    //insert_aqar
    public boolean insert_product(Products1_table product)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Pclo_Name_name,product.getName());
        contentValues.put(Pclo_Price_name,product.getPrice());
        contentValues.put(Pclo_Description_name,product.getDescription());
        contentValues.put(Pclo_image_name,product.getImage());

        //check if insert done or not
        long result_insert = sqLiteDatabase.insert(products_tabel_Name,null,contentValues);
        if(result_insert == -1)
            return false;
        return true;

    }
//#####################################################################################################################################
//insert_to_card
    public boolean insert_to_card(Card_table card)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Pclo_Name_name,card.getName());
        contentValues.put(Pclo_Price_name,card.getPrice());

        //check if insert done or not
        long result_insert = sqLiteDatabase.insert(card_tabel_Name,null,contentValues);
        if(result_insert == -1)
            return false;
        return true;

    }
//#####################################################################################################################################
////update_aqar
//
//    public boolean update_aqar(Aqar_table aqar_table,String var_condition)
//    {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Aclo_Title_name,aqar_table.getTitle());
//        contentValues.put(Aclo_Kind_name,aqar_table.getKind());
//        contentValues.put(Aclo_Price_name,aqar_table.getPrice());
//        contentValues.put(Uclo_City_name,aqar_table.getCity());
//        contentValues.put(Aclo_Description_name,aqar_table.getDescription());
//
//        int result_update = sqLiteDatabase.update(aqar_tabel_Name,contentValues,Aclo_Title_name+"=?",new String[]{var_condition});
//        if(result_update < 1)
//            return false;
//        return true;
//    }


//#####################################################################################################################################
//Select_aqar

//    public ArrayList<Products1_table > get_product()
//    {
//        ArrayList<Products1_table> ProductArray = new ArrayList<>();
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+products_tabel_Name,null);
//        if(cursor != null && cursor.moveToFirst())
//        do{
//            int id = cursor.getInt(cursor.getColumnIndex(Pclo_id_name));
//            String name = cursor.getString(cursor.getColumnIndex(Pclo_Name_name));
//            String price = cursor.getString(cursor.getColumnIndex(Pclo_Price_name));
//            String description = cursor.getString(cursor.getColumnIndex(Pclo_Description_name));
//            byte[] imge = cursor.getBlob(cursor.getColumnIndex(Pclo_image_name));
//
//            Products1_table products_table = new Products1_table(id,name,price,description,imge);
//            ProductArray.add(products_table);
//        }
//        while (cursor.moveToNext());
//            cursor.close();
//
//
//        return ProductArray;
//    }

//    public Cursor getproducts (){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+products_tabel_Name,null);
//        return cursor;
//    }

    public ArrayList<Products1_table> getAllContacts() {
        ArrayList<Products1_table> ProductArray = new ArrayList<>();

        String select_query = "select * from " + products_tabel_Name;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(Pclo_id_name));
            String name = cursor.getString(cursor.getColumnIndex(Pclo_Name_name));
            String price = cursor.getString(cursor.getColumnIndex(Pclo_Price_name));
            String description = cursor.getString(cursor.getColumnIndex(Pclo_Description_name));
             imge = cursor.getBlob(cursor.getColumnIndex(Pclo_image_name));

                Products1_table products_table = new Products1_table(id,name,price,description,imge);
                ProductArray.add(products_table);

            } while (cursor.moveToNext());

        }

        return ProductArray;
    }

//#####################################################################################################################################
    public ArrayList<Card_table> getAllCardItem() {
        ArrayList<Card_table> CardArray = new ArrayList<>();

        String select_query = "select * from " + card_tabel_Name;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(cursor.getColumnIndex(Cclo_id_name));
                String name = cursor.getString(cursor.getColumnIndex(Cclo_Name_name));
                String price = cursor.getString(cursor.getColumnIndex(Cclo_Price_name));

                Card_table card_table = new Card_table(id,name,price);
                CardArray.add(card_table);

            } while (cursor.moveToNext());

        }

        return CardArray;
    }


//#####################################################################################################################################
//    //Delete_aqar
//    public boolean drop_aqar(String aqar_title)
//    {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        int result  = sqLiteDatabase.delete(aqar_tabel_Name,Aclo_Title_name+ " = ?",new String[]{aqar_title});
//
//        return result > 0;
//    }
//#####################################################################################################################################
}
