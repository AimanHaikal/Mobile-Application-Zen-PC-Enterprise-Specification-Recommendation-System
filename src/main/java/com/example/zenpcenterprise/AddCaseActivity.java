package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddCaseBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCaseActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, motherboard, psu, price;
    FirebaseFirestore fStore;
    ActivityAddCaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editCaseName);
        motherboard = findViewById(R.id.editCaseMotherboardFormFactor);
        psu = findViewById(R.id.editCasePSUFormFactor);
        price = findViewById(R.id.editCasePrice);
        fStore = FirebaseFirestore.getInstance();

        binding.submitCaseButton.setOnClickListener(v -> submitCase());
    }

    public void submitCase(){
        if(name.getText().toString().equals("") && motherboard.getText().toString().equals("") && psu.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String caseName = name.getText().toString();
            String caseMotherboard = motherboard.getText().toString();
            String casePSU = psu.getText().toString();
            double casePrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("Case").document();
            Map<String,Object> cases = new HashMap<>();
            cases.put("product_Name",caseName);
            cases.put("product_Price",casePrice);
            cases.put("motherboard_FormFactor",caseMotherboard);
            cases.put("psu_FormFactor",casePSU);
            documentReference.set(cases).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void CaseCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}