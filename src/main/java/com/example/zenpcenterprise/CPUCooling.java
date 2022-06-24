package com.example.zenpcenterprise;

public class CPUCooling extends Products{
    String cpu_Socket;
    double air_flow;

    public CPUCooling(){super();}

    public CPUCooling(String cpu_Socket, double air_flow) {
        super();
        this.cpu_Socket = cpu_Socket;
        this.air_flow = air_flow;
    }

    public String getCpu_Socket() {
        return cpu_Socket;
    }

    public double getAir_flow() {
        return air_flow;
    }
}
