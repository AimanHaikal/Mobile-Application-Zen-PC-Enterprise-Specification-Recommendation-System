package com.example.zenpcenterprise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class generateBuildPCActivity extends AppCompatActivity {
    double budget;
    TextView CPUCoolingName, AirFlow, CPUCoolingPrice, CaseName, CasePrice, PSUName, Wattage, PSUPrice, MotherboardName, MotherboardPrice, StorageName, StorageSize, TransferSpeed, StoragePrice, RAMName, RAMSize, RAMFrequency, RAMPrice, CPUName, Core, CPUFrequency, CPUPrice, GPUName, VRAM, CoreFrequency, MemoryFrequency, GPUPrice, TotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_build_pcactivity);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent receiveIntent = this.getIntent();
        budget = receiveIntent.getDoubleExtra("budget", 0);
        CPUCoolingName = findViewById(R.id.generateCPUCoolingName);
        AirFlow = findViewById(R.id.generateAirFlow);
        CPUCoolingPrice = findViewById(R.id.generateCPUCoolingPrice);
        CaseName = findViewById(R.id.generateCaseName);
        CasePrice = findViewById(R.id.generateCasePrice);
        PSUName = findViewById(R.id.generatePSUName);
        Wattage = findViewById(R.id.generateWattage);
        PSUPrice = findViewById(R.id.generatePSUPrice);
        MotherboardName = findViewById(R.id.generateMotherboardName);
        MotherboardPrice = findViewById(R.id.generateMotherboardPrice);
        StorageName = findViewById(R.id.generateStorageName);
        StorageSize = findViewById(R.id.generateStorageSize);
        TransferSpeed = findViewById(R.id.generateTransferSpeed);
        StoragePrice = findViewById(R.id.generateStoragePrice);
        RAMName = findViewById(R.id.generateRAMName);
        RAMSize = findViewById(R.id.generateRAMSize);
        RAMFrequency = findViewById(R.id.generateRAMFrequency);
        RAMPrice = findViewById(R.id.generateRAMPrice);
        CPUName = findViewById(R.id.generateCPUName);
        Core = findViewById(R.id.generateCore);
        CPUFrequency = findViewById(R.id.generateCPUFrequency);
        CPUPrice = findViewById(R.id.generateCPUPrice);
        GPUName = findViewById(R.id.generateGPUName);
        VRAM = findViewById(R.id.generateVRAM);
        CoreFrequency = findViewById(R.id.generateCoreFrequency);
        MemoryFrequency = findViewById(R.id.generateMemoryFrequency);
        GPUPrice = findViewById(R.id.generateGPUPrice);
        TotalPrice = findViewById(R.id.generateTotalPrice);

        double budgetPart = budget/8;
        db.collection("CPUCooling").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                .whereLessThan("product_Price", budgetPart)
                .get()
                .addOnCompleteListener(taskCPUCooling -> {
                    if (taskCPUCooling.isSuccessful()) {
                        for (QueryDocumentSnapshot documentCPUCooling : taskCPUCooling.getResult()) {
                            Log.d("TAG", documentCPUCooling.getId() + " => " + documentCPUCooling.getData());

                            CPUCoolingName.setText(documentCPUCooling.getString("product_Name"));
                            AirFlow.setText(String.valueOf(documentCPUCooling.getDouble("air_Flow")));
                            CPUCoolingPrice.setText(String.valueOf(documentCPUCooling.getDouble("product_Price")));

                            double cpuCoolingPrice = documentCPUCooling.getDouble("product_Price");
                            double extraBudgetPart1 = budgetPart - cpuCoolingPrice;
                            double budgetPart2 = budgetPart + extraBudgetPart1;

                            db.collection("Case").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                    .whereLessThan("product_Price", budgetPart2)
                                    .get()
                                    .addOnCompleteListener(taskCase -> {
                                        if (taskCase.isSuccessful()) {
                                            for (QueryDocumentSnapshot documentCase : taskCase.getResult()) {
                                                Log.d("TAG", documentCase.getId() + " => " + documentCase.getData());

                                                CaseName.setText(documentCase.getString("product_Name"));
                                                CasePrice.setText(String.valueOf(documentCase.getDouble("product_Price")));

                                                double casePrice = documentCase.getDouble("product_Price");
                                                double extraBudgetPart2 = budgetPart2 - casePrice;
                                                double budgetPart3 = budgetPart + extraBudgetPart2;

                                                db.collection("PSU").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                        .whereLessThan("product_Price", budgetPart3)
                                                        .get()
                                                        .addOnCompleteListener(taskPSU -> {
                                                            if (taskPSU.isSuccessful()) {
                                                                for (QueryDocumentSnapshot documentPSU : taskPSU.getResult()) {
                                                                    Log.d("TAG", documentPSU.getId() + " => " + documentPSU.getData());

                                                                    PSUName.setText(documentPSU.getString("product_Name"));
                                                                    Wattage.setText(String.valueOf(documentPSU.getLong("wattage")));
                                                                    PSUPrice.setText(String.valueOf(documentPSU.getDouble("product_Price")));

                                                                    double psuPrice = documentPSU.getDouble("product_Price");
                                                                    double extraBudgetPart3 = budgetPart3 - psuPrice;
                                                                    double budgetPart4 = budgetPart + extraBudgetPart3;

                                                                    db.collection("Motherboard").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                                            .whereLessThan("product_Price", budgetPart4)
                                                                            .whereEqualTo("cpu_Socket", documentCPUCooling.getString("cpu_Socket"))
                                                                            .get()
                                                                            .addOnCompleteListener(taskMotherboard -> {
                                                                                if (taskMotherboard.isSuccessful()) {
                                                                                    for (QueryDocumentSnapshot documentMotherboard : taskMotherboard.getResult()) {
                                                                                        Log.d("TAG", documentMotherboard.getId() + " => " + documentMotherboard.getData());

                                                                                        MotherboardName.setText(documentMotherboard.getString("product_Name"));
                                                                                        MotherboardPrice.setText(String.valueOf(documentMotherboard.getDouble("product_Price")));

                                                                                        double motherboardPrice = documentMotherboard.getDouble("product_Price");
                                                                                        double extraBudgetPart4 = budgetPart4 - motherboardPrice;
                                                                                        double budgetPart5 = budgetPart + extraBudgetPart4;

                                                                                        db.collection("Storage").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                                                                .whereLessThan("product_Price", budgetPart5)
                                                                                                .get()
                                                                                                .addOnCompleteListener(taskStorage -> {
                                                                                                    if (taskStorage.isSuccessful()) {
                                                                                                        for (QueryDocumentSnapshot documentStorage : taskStorage.getResult()) {
                                                                                                            Log.d("TAG", documentStorage.getId() + " => " + documentStorage.getData());

                                                                                                            StorageName.setText(documentStorage.getString("product_Name"));
                                                                                                            StorageSize.setText(String.valueOf(documentStorage.getLong("storage_Size")));
                                                                                                            TransferSpeed.setText(String.valueOf(documentStorage.getLong("transfer_Speed")));
                                                                                                            StoragePrice.setText(String.valueOf(documentStorage.getDouble("product_Price")));

                                                                                                            double storagePrice = documentStorage.getDouble("product_Price");
                                                                                                            double extraBudgetPart5 = budgetPart5 - storagePrice;
                                                                                                            double budgetPart6 = budgetPart + extraBudgetPart5;

                                                                                                            db.collection("RAM").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                                                                                    .whereLessThan("product_Price", budgetPart6)
                                                                                                                    .get()
                                                                                                                    .addOnCompleteListener(taskRAM -> {
                                                                                                                        if (taskRAM.isSuccessful()) {
                                                                                                                            for (QueryDocumentSnapshot documentRAM : taskRAM.getResult()) {
                                                                                                                                Log.d("TAG", documentRAM.getId() + " => " + documentRAM.getData());

                                                                                                                                RAMName.setText(documentRAM.getString("product_Name"));
                                                                                                                                RAMSize.setText(String.valueOf(documentRAM.getLong("ram_Size")));
                                                                                                                                RAMFrequency.setText(String.valueOf(documentRAM.getLong("ram_Frequency")));
                                                                                                                                RAMPrice.setText(String.valueOf(documentRAM.getDouble("product_Price")));

                                                                                                                                double ramPrice = documentRAM.getDouble("product_Price");
                                                                                                                                double extraBudgetPart6 = budgetPart6 - ramPrice;
                                                                                                                                double budgetPart7 = budgetPart + extraBudgetPart6;

                                                                                                                                db.collection("CPU").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                                                                                                        .whereLessThan("product_Price", budgetPart7)
                                                                                                                                        .whereEqualTo("cpu_Socket", documentCPUCooling.getString("cpu_Socket"))
                                                                                                                                        .get()
                                                                                                                                        .addOnCompleteListener(taskCPU -> {
                                                                                                                                            if (taskCPU.isSuccessful()) {
                                                                                                                                                for (QueryDocumentSnapshot documentCPU : taskCPU.getResult()) {
                                                                                                                                                    Log.d("TAG", documentCPU.getId() + " => " + documentCPU.getData());

                                                                                                                                                    CPUName.setText(documentCPU.getString("product_Name"));
                                                                                                                                                    Core.setText(String.valueOf(documentCPU.getLong("core")));
                                                                                                                                                    CPUFrequency.setText(String.valueOf(documentCPU.getDouble("cpu_Frequency")));
                                                                                                                                                    CPUPrice.setText(String.valueOf(documentCPU.getDouble("product_Price")));

                                                                                                                                                    double cpuPrice = documentCPU.getDouble("product_Price");
                                                                                                                                                    double extraBudgetPart7 = budgetPart7 - cpuPrice;
                                                                                                                                                    double budgetPart8 = budgetPart + extraBudgetPart7;

                                                                                                                                                    db.collection("GPU").orderBy("product_Price", Query.Direction.ASCENDING).limit(1)
                                                                                                                                                            .whereLessThan("product_Price", budgetPart8)
                                                                                                                                                            .get()
                                                                                                                                                            .addOnCompleteListener(taskGPU -> {
                                                                                                                                                                if (taskGPU.isSuccessful()) {
                                                                                                                                                                    for (QueryDocumentSnapshot documentGPU : taskGPU.getResult()) {
                                                                                                                                                                        Log.d("TAG", documentGPU.getId() + " => " + documentGPU.getData());

                                                                                                                                                                        GPUName.setText(documentGPU.getString("product_Name"));
                                                                                                                                                                        VRAM.setText(String.valueOf(documentGPU.getLong("vram")));
                                                                                                                                                                        CoreFrequency.setText(String.valueOf(documentGPU.getLong("core_Frequency")));
                                                                                                                                                                        MemoryFrequency.setText(String.valueOf(documentGPU.getLong("memory_Frequency")));
                                                                                                                                                                        GPUPrice.setText(String.valueOf(documentGPU.getDouble("product_Price")));

                                                                                                                                                                        double gpuPrice = documentGPU.getDouble("product_Price");
                                                                                                                                                                        double totalPrice = cpuPrice + cpuCoolingPrice + motherboardPrice + ramPrice + storagePrice + gpuPrice + casePrice + psuPrice;
                                                                                                                                                                        TotalPrice.setText(String.valueOf(totalPrice));
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    Log.d("TAG", "Error getting documents: ", taskGPU.getException());
                                                                                                                                                                }
                                                                                                                                                            });
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                Log.d("TAG", "Error getting documents: ", taskCPU.getException());
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            Log.d("TAG", "Error getting documents: ", taskRAM.getException());
                                                                                                                        }
                                                                                                                    });
                                                                                                        }
                                                                                                    } else {
                                                                                                        Log.d("TAG", "Error getting documents: ", taskStorage.getException());
                                                                                                    }
                                                                                                });
                                                                                    }
                                                                                } else {
                                                                                    Log.d("TAG", "Error getting documents: ", taskMotherboard.getException());
                                                                                }
                                                                            });
                                                                }
                                                            } else {
                                                                Log.d("TAG", "Error getting documents: ", taskPSU.getException());
                                                            }
                                                        });
                                            }
                                        } else {
                                            Log.d("TAG", "Error getting documents: ", taskCase.getException());
                                        }
                                    });
                        }
                    } else {
                        Log.d("TAG", "Error getting documents: ", taskCPUCooling.getException());
                    }
                });
    }
}