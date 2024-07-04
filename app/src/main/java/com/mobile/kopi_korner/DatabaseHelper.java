package com.mobile.kopi_korner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_kopi_korner";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ORDER = "tb_order";
    private static final String KEY_ID = "id";
    private static final String KEY_CUSTOMER_NAME = "customer_name";
    private static final String KEY_TYPE_DRINK = "type_drink";
    private static final String KEY_TOTAL_ORDER = "total_order";
    private static final String KEY_PRICE = "price";

    private static final String CREATE_TABLE_ORDERS =
            "CREATE TABLE "
                    + TABLE_ORDER + "(" + KEY_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CUSTOMER_NAME + " TEXT, " + KEY_TYPE_DRINK + " TEXT, " + KEY_TOTAL_ORDER + " INTEGER, " + KEY_PRICE + " INTEGER );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ORDER + "'");
        onCreate(db);
    }

    public long createOrder(String name, String typeDrink, String totalOrder, String price) {
        Integer totalOrderInt = Integer.parseInt(totalOrder);
        Integer priceInt = Integer.parseInt(price);

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSTOMER_NAME, name);
        values.put(KEY_TYPE_DRINK, typeDrink);
        values.put(KEY_TOTAL_ORDER, totalOrderInt);
        values.put(KEY_PRICE, priceInt);

        long insert = db.insert(TABLE_ORDER, null, values);

        return insert;
    }


    public ArrayList<Order> retrieveOrders() {
        ArrayList<Order> orderModelArrayList = new ArrayList<Order>();

        String selectQuery = "SELECT * FROM " + TABLE_ORDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Order order = new Order();
                order.setId(c.getInt(c.getColumnIndexOrThrow(KEY_ID)));
                order.setCustomerName(c.getString(c.getColumnIndexOrThrow(KEY_CUSTOMER_NAME)));
                order.setTypeDrink(c.getString(c.getColumnIndexOrThrow(KEY_TYPE_DRINK)));
                order.setTotalOrder(c.getInt(c.getColumnIndexOrThrow(KEY_TOTAL_ORDER)));
                order.setPrice(c.getInt(c.getColumnIndexOrThrow(KEY_PRICE)));
                orderModelArrayList.add(order);
            } while (c.moveToNext());
        }
        return orderModelArrayList;
    }

    public void deleteOrder(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public int updateOrder(Integer id, String name, String typeDrink, Integer totalOrder, Integer price) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSTOMER_NAME, name);
        values.put(KEY_TYPE_DRINK, typeDrink);
        values.put(KEY_TOTAL_ORDER, totalOrder);
        values.put(KEY_PRICE, price);

        return db.update(TABLE_ORDER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}
