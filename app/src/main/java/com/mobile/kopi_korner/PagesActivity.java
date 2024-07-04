package com.mobile.kopi_korner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PagesActivity extends AppCompatActivity {
    LinearLayout llProfile, llPurchase, llHistory, llMenu;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pages);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        llProfile = findViewById(R.id.llProfilePage);
        llPurchase = findViewById(R.id.llPurchasePage);
        llHistory = findViewById(R.id.llHistoryPage);
        llMenu = findViewById(R.id.llMenuPage);

        llProfile.setOnClickListener(v -> goToPage("profile"));
        llPurchase.setOnClickListener(v -> goToPage("purchase"));
        llHistory.setOnClickListener(v -> goToPage("history"));
        llMenu.setOnClickListener(v -> goToPage("menu"));

        getWindow().setNavigationBarColor(getResources().getColor(R.color.c_very_light_brown));
        getWindow().setStatusBarColor(getResources().getColor(R.color.c_light_brown));
    }

    public void goToPage(String page) {
        switch (page) {
            case "profile":
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            case "purchase":
                intent = new Intent(this, PurchaseActivity.class);
                startActivity(intent);
                break;
            case "history":
                intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case "menu":
                intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}