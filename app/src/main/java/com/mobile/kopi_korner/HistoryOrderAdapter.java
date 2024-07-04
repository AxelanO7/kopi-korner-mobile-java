package com.mobile.kopi_korner;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HistoryOrderAdapter extends ArrayAdapter {
    private final Activity context;
    private final Order[] orders;

    public HistoryOrderAdapter(Activity context, Order[] item) {
        super(context, R.layout.history_order_lv_layout, item);
        this.context = context;
        this.orders = item;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View testSingleView = inflater.inflate(R.layout.history_order_lv_layout, null, true);

        TextView customerNameText = testSingleView.findViewById(R.id.tvCustomerName);
        TextView typeDrinkText = testSingleView.findViewById(R.id.tvOrderItem);
        TextView totalOrderText = testSingleView.findViewById(R.id.tvTotalTypeOrder);
        TextView priceText = testSingleView.findViewById(R.id.tvPrice);
        TextView totalPriceText = testSingleView.findViewById(R.id.tvTotalPrice);

        customerNameText.setText("Nama Pembeli : " + orders[position].getCustomerName());
        typeDrinkText.setText("- " + orders[position].getTypeDrink());
        totalOrderText.setText("Jumlah Order : " + orders[position].getTotalOrder());
        priceText.setText("Harga : " + orders[position].getPrice());
        totalPriceText.setText("Total Harga : " + orders[position].getTotalPrice());

        return testSingleView;
    }
}
