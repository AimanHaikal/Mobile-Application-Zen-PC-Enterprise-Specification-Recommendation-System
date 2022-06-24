package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddRamactivityBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddRAMActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, frequency, size, price;
    FirebaseFirestore fStore;
    ActivityAddRamactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRamactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editRAMName);
        frequency = findViewById(R.id.editRAMFrequency);
        size = findViewById(R.id.editRAMSize);
        price = findViewById(R.id.editRAMPrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitRAMButton.setOnClickListener(v -> submitRAM());
    }

    public void submitRAM(){
        if(name.getText().toString().equals("") && frequency.getText().toString().equals("") && size.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String ramName = name.getText().toString();
            long ramFrequency = Long.parseLong(frequency.getText().toString());
            long ramSize = Long.parseLong(size.getText().toString());
            double ramPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("RAM").document();
            Map<String,Object> ram = new HashMap<>();
            ram.put("product_Name",ramName);
            ram.put("product_Price",ramPrice);
            ram.put("ram_Frequency",ramFrequency);
            ram.put("ram_Size",ramSize);
            documentReference.set(ram).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void RAMCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}