package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zenpcenterprise.databinding.ActivityAddGpuactivityBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddGPUActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText name, vram, core, memory, price;
    FirebaseFirestore fStore;
    ActivityAddGpuactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddGpuactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        name = findViewById(R.id.editGPUName);
        vram = findViewById(R.id.editVRAM);
        core = findViewById(R.id.editCoreFrequency);
        memory = findViewById(R.id.editMemoryFrequency);
        price = findViewById(R.id.editGPUPrice);

        fStore = FirebaseFirestore.getInstance();

        binding.submitGPUButton.setOnClickListener(v -> submitGPU());
    }

    public void submitGPU(){
        if(name.getText().toString().equals("") && vram.getText().toString().equals("") && core.getText().toString().equals("") && memory.getText().toString().equals("") && price.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),"Please fill in the blank", Toast.LENGTH_SHORT).show();
        else{
            String gpuName = name.getText().toString();
            long gpuVRAM = Long.parseLong(vram.getText().toString());
            long gpuCoreFrequency = Long.parseLong(core.getText().toString());
            long gpuMemoryFrequency = Long.parseLong(memory.getText().toString());
            double gpuPrice = Double.parseDouble(price.getText().toString());

            DocumentReference documentReference = fStore.collection("GPU").document();
            Map<String,Object> gpu = new HashMap<>();
            gpu.put("product_Name",gpuName);
            gpu.put("product_Price",gpuPrice);
            gpu.put("vram",gpuVRAM);
            gpu.put("core_Frequency",gpuCoreFrequency);
            gpu.put("memory_Frequency",gpuMemoryFrequency);
            documentReference.set(gpu).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: Product is created")).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e));

            Toast.makeText(getApplicationContext(),"Product created successfully",Toast.LENGTH_SHORT).show();
            finish();
            Intent i = new Intent(getApplicationContext(),AddProductsActivity.class);
            startActivity(i);
        }
    }

    public void GPUCancelButton(View v){
        Intent i = new Intent(this,AddProductsActivity.class);
        startActivity(i);
    }
}