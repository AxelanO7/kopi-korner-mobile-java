package com.mobile.kopi_korner;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView listHistory;
    private ArrayList<Order> orderList = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setNavigationBarColor(getResources().getColor(R.color.c_very_light_brown));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c_light_brown));

        listHistory = findViewById(R.id.lvHistory);
        getOrders();
    }

    private void getOrders() {
        db = new DatabaseHelper(this);
        orderList = db.retrieveOrders();
        HistoryOrderAdapter adapter = new HistoryOrderAdapter(this, orderList.toArray(new Order[orderList.size()]));
        listHistory.setAdapter(adapter);
    }
}