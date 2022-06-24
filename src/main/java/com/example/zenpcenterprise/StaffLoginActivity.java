package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class StaffLoginActivity extends AppCompatActivity {
    EditText e1, e2;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        e1 = findViewById(R.id.editTextTextEmailAddress);
        e2 = findViewById(R.id.editTextTextPassword);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
    }

    public void loginUser(View v){
        if(e1.getText().toString().equals("") && e2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Blank not allowed", Toast.LENGTH_SHORT).show();

        }else{
            mAuth.signInWithEmailAndPassword(e1.getText().toString(),e2.getText().toString())
                    .addOnSuccessListener(authResult -> checkUserAccessLevel(Objects.requireNonNull(authResult.getUser()).getUid())).addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"User could not be login",Toast.LENGTH_SHORT).show());
        }
    }

    private void checkUserAccessLevel(String uid){
        DocumentReference df = fstore.collection("Staff").document(uid);
        df.get().addOnSuccessListener(documentSnapshot -> {
            Log.d("TAG", "onSuccess: " + documentSnapshot.getData());
            if(documentSnapshot.getString("staff_ID") != null){
                Toast.makeText(getApplicationContext(), "User logged in successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), StaffHomeActivity.class));
                finish();
            }
            else
                Toast.makeText(getApplicationContext(),"User could not be login",Toast.LENGTH_SHORT).show();
        });
    }

    public void back(View v){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}