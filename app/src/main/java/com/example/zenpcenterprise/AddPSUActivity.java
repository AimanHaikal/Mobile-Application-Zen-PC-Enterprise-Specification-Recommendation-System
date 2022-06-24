package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddPsuactivityBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddPSUActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, wattage, formfactor, price;
    FirebaseFirestore fStore;
    ActivityAddPsuactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPsuactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editPSUName);
        wattage = findViewById(R.id.editWattage);
        formfactor = findViewById(R.id.editPSUFormFactor);
        price = findViewById(R.id.editPSUPrice);
        fStore = FirebaseFirestore.getInstance();

        binding.submitPSUButton.setOnClickListener(v -> submitPSU());
    }

    public void submitPSU(){
        if(name.getText().toString().equals("") && wattage.getText().toString().equals("") && formfactor.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String psuName = name.getText().toString();
            long psuWattage = Long.parseLong(wattage.getText().toString());
            String psuFormFactor = formfactor.getText().toString();
            double psuPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("PSU").document();
            Map<String,Object> psu = new HashMap<>();
            psu.put("product_Name",psuName);
            psu.put("product_Price",psuPrice);
            psu.put("wattage",psuWattage);
            psu.put("psu_FormFactor",psuFormFactor);
            documentReference.set(psu).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void PSUCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}