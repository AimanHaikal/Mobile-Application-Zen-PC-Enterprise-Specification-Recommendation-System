package com.example.zenpcenterprise;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class StaffViewCPUActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<CPU> cpuArrayList;
    CPUAdapter cpuAdapter;
    FirebaseFirestore fstore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_view_cpuactivity);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.cpuList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fstore = FirebaseFirestore.getInstance();
        cpuArrayList = new ArrayList<>();
        cpuAdapter = new CPUAdapter(StaffViewCPUActivity.this,cpuArrayList);

        recyclerView.setAdapter(cpuAdapter);

        EventChangeListener();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void EventChangeListener() {
        fstore.collection("CPU").orderBy("product_Name", Query.Direction.ASCENDING).addSnapshotListener((value, error) -> {
            if(error != null){
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Log.e("Firestore Error", error.getMessage());
                return;
            }
            assert value != null;
            for(DocumentChange dc: value.getDocumentChanges()){
                if(dc.getType() == DocumentChange.Type.ADDED){
                    cpuArrayList.add(dc.getDocument().toObject(CPU.class));
                }

                cpuAdapter.notifyDataSetChanged();
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });
    }
}