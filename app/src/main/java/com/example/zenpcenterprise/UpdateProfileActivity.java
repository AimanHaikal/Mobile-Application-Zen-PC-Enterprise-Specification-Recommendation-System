package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class UpdateProfileActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileEmail, profileName, profilePhone, profileAddress, profilePassword;
    String customerEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        profileEmail = (TextView)findViewById(R.id.email);
        profileName = (TextView)findViewById(R.id.name);
        profilePhone = (TextView)findViewById(R.id.phone);
        profileAddress = (TextView)findViewById(R.id.address);
        profilePassword = (TextView)findViewById(R.id.password);

        db.collection("Customer")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d("exist", document.getId() + " => " + document.getData());

                            profileName.setText(document.getString("cust_Name"));
                            profilePhone.setText(document.getString("cust_Phone"));
                            profileAddress.setText(document.getString("cust_Address"));
                            profilePassword.setText(document.getString("cust_Password"));
                        }
                    } else {
                        Log.w("noexist", "Error getting documents.", task.getException());
                    }
                });

        user = auth.getCurrentUser();
        assert user != null;
        profileEmail.setText(user.getEmail());
    }

    private void changePassword() {

        if (profilePassword.getText().toString().equals("") && profileAddress.getText().toString().equals("") && profilePhone.getText().toString().equals("")){
            Toast.makeText(this, "Please enter all the fields.", Toast.LENGTH_SHORT).show();
        }
        else {
            user = auth.getCurrentUser();
            if (user != null && user.getEmail() != null) {
                                    user.updatePassword(profilePassword.getText().toString())
                                            .addOnCompleteListener(task -> {
                                                if (task.isSuccessful()) {
                                                    Log.d(TAG, "User password updated.");
                                                    Intent i = new Intent(UpdateProfileActivity.this,ProfileActivity.class);
                                                    startActivity(i);
                                                    finish();
                                                }
                                            });
            } else {
                Intent i = new Intent(this,ProfileActivity.class);
                startActivity(i);
                finish();
            }
        }
    }

    public void updateUser(View v){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        changePassword();

        String address = profileAddress.getText().toString();
        String phone = profilePhone.getText().toString();
        String password = profilePassword.getText().toString();

        customerEmail = Objects.requireNonNull(auth.getCurrentUser()).getUid();
        db.collection("Customer").document(customerEmail)
                .update(
                        "cust_Address", address,
                        "cust_Phone", phone,
                        "cust_Password", password
                );
    }

    public void cancelUpdate(View v){
        Intent i = new Intent(this,ProfileActivity.class);
        startActivity(i);
    }
}