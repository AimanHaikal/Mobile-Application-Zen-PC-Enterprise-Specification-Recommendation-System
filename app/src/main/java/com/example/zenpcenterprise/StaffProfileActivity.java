package com.example.zenpcenterprise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class StaffProfileActivity extends AppCompatActivity {
    TextView profileEmail, profileName, profilePhone, profileAddress;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_profile);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        profileEmail = findViewById(R.id.email);
        profileName = findViewById(R.id.name);
        profilePhone = findViewById(R.id.phone);
        profileAddress = findViewById(R.id.address);

        db.collection("Staff")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d("exist", document.getId() + " => " + document.getData());

                            profileName.setText(document.getString("staff_Name"));
                            profilePhone.setText(document.getString("staff_Phone"));
                            profileAddress.setText(document.getString("staff_Address"));
                        }
                    } else {
                        Log.w("noexist", "Error getting documents.", task.getException());
                    }
                });

        user = auth.getCurrentUser();
        assert user != null;
        profileEmail.setText(user.getEmail());

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
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