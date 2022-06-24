package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddCpuactivityBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCPUActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, socket, frequency, core, price;
    FirebaseFirestore fStore;
    ActivityAddCpuactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCpuactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name = findViewById(R.id.editCPUName);
        socket = findViewById(R.id.editCPUSocket);
        frequency = findViewById(R.id.editCPUFrequency);
        core = findViewById(R.id.editCore);
        price = findViewById(R.id.editCPUPrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitCPUButton.setOnClickListener(v -> submitCPU());
    }

    public void submitCPU(){
        if(name.getText().toString().equals("") && socket.getText().toString().equals("") && frequency.getText().toString().equals("") && core.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String cpuName = name.getText().toString();
            String cpuSocket = socket.getText().toString();
            double cpuFrequency = Double.parseDouble(frequency.getText().toString());
            long cpuCore = Long.parseLong(core.getText().toString());
            double cpuPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("CPU").document();
            Map<String,Object> cpu = new HashMap<>();
            cpu.put("product_Name",cpuName);
            cpu.put("cpu_Socket",cpuSocket);
            cpu.put("cpu_Frequency",cpuFrequency);
            cpu.put("core",cpuCore);
            cpu.put("product_Price",cpuPrice);
            documentReference.set(cpu).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: CPU is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"CPU created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void CPUCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}