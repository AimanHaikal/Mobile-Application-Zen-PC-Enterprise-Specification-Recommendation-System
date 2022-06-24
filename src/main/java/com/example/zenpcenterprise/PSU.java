package com.example.zenpcenterprise;

public class PSU extends Products{
    String psu_FormFactor;
    long wattage;

    public PSU(){super();}

    public PSU(String psu_FormFactor, long wattage) {
        super();
        this.psu_FormFactor = psu_FormFactor;
        this.wattage = wattage;
    }

    public String getPsu_FormFactor() {
        return psu_FormFactor;
    }

    public long getWattage() {
        return wattage;
    }
}
