package com.example.zenpcenterprise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CPUAdapter extends RecyclerView.Adapter<CPUAdapter.CPUViewHolder> {
    Context context;
    ArrayList<CPU> cpuArrayList;

    public CPUAdapter(Context context, ArrayList<CPU> cpuArrayList) {
        this.context = context;
        this.cpuArrayList = cpuArrayList;
    }

    @NonNull
    @Override
    public CPUAdapter.CPUViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_cpu, parent, false);

        return new CPUViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CPUAdapter.CPUViewHolder holder, int position) {
        CPU cpu = cpuArrayList.get(position);

        holder.CPUName.setText(cpu.product_Name);
        holder.CPUSocket.setText(cpu.cpu_Socket);
        holder.CPUFrequency.setText(String.valueOf(cpu.cpu_Frequency));
        holder.core.setText(String.valueOf(cpu.core));
        holder.CPUPrice.setText(String.valueOf(cpu.product_Price));
    }

    @Override
    public int getItemCount() {
        return cpuArrayList.size();
    }

    public static class CPUViewHolder extends RecyclerView.ViewHolder{
        TextView CPUName, CPUPrice, CPUSocket, CPUFrequency, core;

        public CPUViewHolder(@NonNull View itemView) {
            super(itemView);
            CPUName = itemView.findViewById(R.id.listCPUNameTextView);
            CPUSocket = itemView.findViewById(R.id.listCPUSocketTextView);
            CPUFrequency = itemView.findViewById(R.id.listCPUFrequencyTextView);
            core = itemView.findViewById(R.id.listCoreTextView);
            CPUPrice = itemView.findViewById(R.id.listCPUPriceTextView);
        }
    }
}
