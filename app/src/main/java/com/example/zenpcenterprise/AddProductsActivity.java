package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
    }

    public void addCPU(View v){
        Intent i = new Intent(this,AddCPUActivity.class);
        startActivity(i);
    }

    public void addCPUCooling(View v){
        Intent i = new Intent(this,AddCPUCoolingActivity.class);
        startActivity(i);
    }

    public void addMotherboard(View v){
        Intent i = new Intent(this,AddMotherboardActivity.class);
        startActivity(i);
    }

    public void addRAM(View v){
        Intent i = new Intent(this,AddRAMActivity.class);
        startActivity(i);
    }

    public void addGPU(View v){
        Intent i = new Intent(this,AddGPUActivity.class);
        startActivity(i);
    }

    public void addStorage(View v){
        Intent i = new Intent(this,AddStorageActivity.class);
        startActivity(i);
    }

    public void addPSU(View v){
        Intent i = new Intent(this,AddPSUActivity.class);
        startActivity(i);
    }

    public void addCase(View v){
        Intent i = new Intent(this,AddCaseActivity.class);
        startActivity(i);
    }

    public void backButton(View v){
        Intent i = new Intent(this,StaffHomeActivity.class);
        startActivity(i);
    }
}