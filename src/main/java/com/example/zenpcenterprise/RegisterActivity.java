package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = "TAG";

    EditText e1, e2, e3, e4, e5;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String customerEmail;

    //Database reference object
    DatabaseReference databaseCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = findViewById(R.id.editTextEmail);
        e2 = findViewById(R.id.editTextName);
        e3 = findViewById(R.id.editTextAddress);
        e4 = findViewById(R.id.editTextPhone);
        e5 = findViewById(R.id.editTextPassword);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        FirebaseApp.initializeApp(this);

        //Create database reference
        databaseCustomer = FirebaseDatabase.getInstance() .getReference("Customer");
    }

    public void registerUser(View v){
        if(e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals("") && e4.getText().toString().equals("") && e5.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Blank not allowed", Toast.LENGTH_SHORT).show();
        }else{
            String email = e1.getText().toString();
            String name = e2.getText().toString();
            String address = e3.getText().toString();
            String phone = e4.getText().toString();
            String password = e5.getText().toString();

            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){

                            Toast.makeText(RegisterActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            customerEmail = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                            DocumentReference documentReference = fStore.collection("Customer").document(customerEmail);
                            Map<String,Object> customer = new HashMap<>();
                            customer.put("cust_ID",email);
                            customer.put("cust_Name",name);
                            customer.put("cust_Address",address);
                            customer.put("cust_Phone",phone);
                            customer.put("cust_Password",password);
                            documentReference.set(customer).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: user Profile is created for "+ customerEmail)).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

                            Toast.makeText(getApplicationContext(),"User created successfully",Toast.LENGTH_SHORT).show();
                            finish();
                            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(i);
                        }else{
                            if(e5.getText().toString().length()<8)
                                Toast.makeText(getApplicationContext(),"Password not enough length",Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"Check your details",Toast.LENGTH_SHORT).show();
                        }
                    });

        }
    }
}
