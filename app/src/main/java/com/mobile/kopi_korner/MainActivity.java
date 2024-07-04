package com.mobile.kopi_korner;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Intent intent;

    EditText etEmail, etPassword;

    List<String> email = Arrays.asList("test@test.com", "admin");
    List<String> password = Arrays.asList("test", "admin");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(v -> onClickLogin());
    }

    private boolean checkLogin(String email, String password) {
        return this.email.contains(email) && this.password.contains(password);
    }

    private void onClickLogin() {
        if (checkLogin(etEmail.getText().toString(), etPassword.getText().toString())) {
            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, PagesActivity.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Email or Password is incorrect");
            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.show();
        }
    }
}