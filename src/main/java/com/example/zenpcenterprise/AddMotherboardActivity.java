package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddMotherboardBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddMotherboardActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, socket, formfactor, price;
    FirebaseFirestore fStore;
    ActivityAddMotherboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMotherboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editMotherboardName);
        socket = findViewById(R.id.editMotherboardCPUSocket);
        formfactor = findViewById(R.id.editMotherboardFormFactor);
        price = findViewById(R.id.editMotherboardPrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitMotherboardButton.setOnClickListener(v -> submitMotherboard());
    }

    public void submitMotherboard(){
        if(name.getText().toString().equals("") && socket.getText().toString().equals("") && formfactor.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String motherboardName = name.getText().toString();
            String motherboardCPUSocket = socket.getText().toString();
            String motherboardFormFactor = formfactor.getText().toString();
            double motherboardPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("Motherboard").document();
            Map<String,Object> motherboard = new HashMap<>();
            motherboard.put("product_Name",motherboardName);
            motherboard.put("product_Price",motherboardPrice);
            motherboard.put("cpu_Socket",motherboardCPUSocket);
            motherboard.put("motherboard_FormFactor",motherboardFormFactor);
            documentReference.set(motherboard).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void MotherboardCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}