package com.example.zenpcenterprise;

public class Motherboard extends Products{
    String cpu_Socket, motherboard_FormFactor;

    public Motherboard(){super();}

    public Motherboard(String cpu_Socket, String motherboard_FormFactor) {
        super();
        this.cpu_Socket = cpu_Socket;
        this.motherboard_FormFactor = motherboard_FormFactor;
    }

    public String getCpu_Socket() {
        return cpu_Socket;
    }

    public String getMotherboard_FormFactor() {
        return motherboard_FormFactor;
    }
}
