package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StaffViewProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_view_products);
    }

    public void viewCPU(View v){
        Intent i = new Intent(this,StaffViewCPUActivity.class);
        startActivity(i);
    }

    public void viewCPUCooling(View v){
        Intent i = new Intent(this,StaffViewCPUCoolingActivity.class);
        startActivity(i);
    }

    public void viewMotherboard(View v){
        Intent i = new Intent(this,StaffViewMotherboardActivity.class);
        startActivity(i);
    }

    public void viewRAM(View v){
        Intent i = new Intent(this,StaffViewRAMActivity.class);
        startActivity(i);
    }

    public void viewGPU(View v){
        Intent i = new Intent(this,StaffViewGPUActivity.class);
        startActivity(i);
    }

    public void viewStorage(View v){
        Intent i = new Intent(this,StaffViewStorageActivity.class);
        startActivity(i);
    }

    public void viewPSU(View v){
        Intent i = new Intent(this,StaffViewPSUActivity.class);
        startActivity(i);
    }

    public void viewCase(View v){
        Intent i = new Intent(this,StaffViewCaseActivity.class);
        startActivity(i);
    }

    public void viewBackButton(View v){
        Intent i = new Intent(this,StaffHomeActivity.class);
        startActivity(i);
    }
}