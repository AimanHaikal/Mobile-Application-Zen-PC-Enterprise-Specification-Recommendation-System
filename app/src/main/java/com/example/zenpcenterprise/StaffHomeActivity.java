package com.example.zenpcenterprise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StaffHomeActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        auth = FirebaseAuth.getInstance();
        profileText = findViewById(R.id.textView);

        user = auth.getCurrentUser();
        assert user != null;
        profileText.setText(user.getEmail());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    public void signout(View v){
        auth.signOut();
        finish();
        Intent i = new Intent(this,StaffLoginActivity.class);
        startActivity(i);
    }

    public void addProducts(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }

    public void viewProducts(View v){
        Intent i = new Intent(this,StaffViewProductsActivity.class);
        startActivity(i);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        switch (item.getItemId()) {
            case R.id.home:
                Intent j = new Intent(getApplicationContext(), StaffHomeActivity.class);
                startActivity(j);
                return true;

            case R.id.profile:
                Intent k = new Intent(getApplicationContext(), StaffProfileActivity.class);
                startActivity(k);
                return true;
        }
        return false;
    };
}