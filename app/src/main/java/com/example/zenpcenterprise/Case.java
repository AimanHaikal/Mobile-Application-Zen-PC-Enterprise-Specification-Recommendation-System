package com.example.zenpcenterprise;

public class Case extends Products{
    String motherboard_FormFactor, psu_FormFactor;

    public Case(){super();}

    public Case(String motherboard_FormFactor, String psu_FormFactor) {
        super();
        this.motherboard_FormFactor = motherboard_FormFactor;
        this.psu_FormFactor = psu_FormFactor;
    }

    public String getMotherboard_FormFactor() {
        return motherboard_FormFactor;
    }

    public String getPsu_FormFactor() {
        return psu_FormFactor;
    }
}
