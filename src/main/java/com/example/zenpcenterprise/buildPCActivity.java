package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class buildPCActivity extends AppCompatActivity {
    EditText budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pcactivity);
        budget = findViewById(R.id.editTextNumberDecimalBudget);
    }

    public void generateBuildPC(View v){
        double custBudget = Double.parseDouble(budget.getText().toString());
        Intent sendingIntent = new Intent(this, generateBuildPCActivity.class);
        sendingIntent.putExtra("budget", custBudget);
        startActivity(sendingIntent);
    }
}