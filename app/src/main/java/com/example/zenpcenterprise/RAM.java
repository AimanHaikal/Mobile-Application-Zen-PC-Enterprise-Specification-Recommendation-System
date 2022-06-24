package com.example.zenpcenterprise;

public class RAM extends Products{
    long ram_Frequency, ram_Size;

    public RAM(){super();}

    public RAM(long ram_Frequency, long ram_Size) {
        super();
        this.ram_Frequency = ram_Frequency;
        this.ram_Size = ram_Size;
    }

    public long getRam_Frequency() {
        return ram_Frequency;
    }

    public long getRam_Size() {
        return ram_Size;
    }
}
