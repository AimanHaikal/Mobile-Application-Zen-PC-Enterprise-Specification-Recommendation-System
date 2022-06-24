package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddStorageBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddStorageActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, size, speed, price;
    FirebaseFirestore fStore;
    ActivityAddStorageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editStorageName);
        size = findViewById(R.id.editStorageSize);
        speed = findViewById(R.id.editTransferSpeed);
        price = findViewById(R.id.editStoragePrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitStorageButton.setOnClickListener(v -> submitStorage());
    }

    public void submitStorage(){
        if(name.getText().toString().equals("") && size.getText().toString().equals("") && speed.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String storageName = name.getText().toString();
            long storageSize = Long.parseLong(size.getText().toString());
            long storageTransferSpeed = Long.parseLong(speed.getText().toString());
            double storagePrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("Storage").document();
            Map<String,Object> storage = new HashMap<>();
            storage.put("product_Name",storageName);
            storage.put("product_Price",storagePrice);
            storage.put("storage_Size",storageSize);
            storage.put("transfer_Speed",storageTransferSpeed);
            documentReference.set(storage).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void StorageCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}