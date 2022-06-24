package com.example.zenpcenterprise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileEmail, profileName, profilePhone, profileAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        DocumentReference docRef = db.collection("Customer").document(Objects.requireNonNull(auth.getCurrentUser()).getUid());
        profileEmail = findViewById(R.id.email);
        profileName = findViewById(R.id.name);
        profilePhone = findViewById(R.id.phone);
        profileAddress = findViewById(R.id.address);

        docRef.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                            profileName.setText(document.getString("cust_Name"));
                            profilePhone.setText(document.getString("cust_Phone"));
                            profileAddress.setText(document.getString("cust_Address"));
                        }
                    } else {
                        Log.w("noexist", "Error getting documents.", task.getException());
                    }
                });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        user = auth.getCurrentUser();
        assert user != null;
        profileEmail.setText(user.getEmail());
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        switch (item.getItemId()) {
            case R.id.home:
                Intent j = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(j);
                return true;

            case R.id.profile:
                Intent k = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(k);
                return true;
        }
        return false;
    };

    public void update(View v){
        Intent i = new Intent(this,UpdateProfileActivity.class);
        startActivity(i);
    }
}