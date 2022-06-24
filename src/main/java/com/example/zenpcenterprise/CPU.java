package com.example.zenpcenterprise;

public class CPU extends Products{
    String cpu_Socket;
    double cpu_Frequency;
    long core;

    public CPU(){super();}

    public CPU(String cpu_Socket,double cpu_Frequency, long core) {
        super();
        this.cpu_Socket = cpu_Socket;
        this.cpu_Frequency = cpu_Frequency;
        this.core = core;
    }

    public String getCpu_Socket() {
        return cpu_Socket;
    }

    public double getCpu_Frequency() {
        return cpu_Frequency;
    }

    public long getCore() {
        return core;
    }
}
