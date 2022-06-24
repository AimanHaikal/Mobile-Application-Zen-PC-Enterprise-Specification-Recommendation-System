package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddCpucoolingBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCPUCoolingActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, socket, airflow, price;
    FirebaseFirestore fStore;
    ActivityAddCpucoolingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCpucoolingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.editCPUCoolingName);
        socket = findViewById(R.id.editCPUCoolingSocket);
        airflow = findViewById(R.id.editAirFlow);
        price = findViewById(R.id.editCPUCoolingPrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitCPUCoolingButton.setOnClickListener(v -> submitCPUCooling());
    }

    public void submitCPUCooling(){
        if(name.getText().toString().equals("") && socket.getText().toString().equals("") && airflow.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{

            String cpuCoolingName = name.getText().toString();
            String cpuCoolingSocket = socket.getText().toString();
            double cpuCoolingAirFLow = Double.parseDouble(airflow.getText().toString());
            double cpuCoolingPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("CPUCooling").document();
            Map<String,Object> cpuCooling = new HashMap<>();
            cpuCooling.put("product_Name",cpuCoolingName);
            cpuCooling.put("cpu_Socket",cpuCoolingSocket);
            cpuCooling.put("air_Flow",cpuCoolingAirFLow);
            cpuCooling.put("product_Price",cpuCoolingPrice);
            documentReference.set(cpuCooling).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void CPUCoolingCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}