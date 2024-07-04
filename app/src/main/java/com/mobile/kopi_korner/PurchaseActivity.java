package com.mobile.kopi_korner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PurchaseActivity extends AppCompatActivity {
    EditText customerName, totalOrder, price;
    Spinner typeOfOrder;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_purchase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setNavigationBarColor(getResources().getColor(R.color.c_very_light_brown));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c_light_brown));

        customerName = findViewById(R.id.etCustomerName);
        totalOrder = findViewById(R.id.etTotalOrder);
        price = findViewById(R.id.etPrice);
        typeOfOrder = findViewById(R.id.spTypeOrder);
        submit = findViewById(R.id.btnOrder);

        submit.setOnClickListener(v -> handleSubmit());
    }
    private void handleSubmit() {
        String name = customerName.getText().toString();
        String order = typeOfOrder.getSelectedItem().toString();
        String totalOrder = this.totalOrder.getText().toString();
        String totalPrice = price.getText().toString();

        if (name.isEmpty() || order.isEmpty() || totalOrder.isEmpty() || totalPrice.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }

        DatabaseHelper db = new DatabaseHelper(this);
        db.createOrder(name, order, totalOrder, totalPrice);
        Toast.makeText(this, "Order added successfully", Toast.LENGTH_SHORT).show();
    }
}