package com.example.zenpcenterprise;

public class GPU extends Products{
    long vram, core_Frequency, memory_Frequency;

    public GPU(){super();}

    public GPU(long vram, long core_Frequency, long memory_Frequency) {
        super();
        this.vram = vram;
        this.core_Frequency = core_Frequency;
        this.memory_Frequency = memory_Frequency;
    }

    public long getVram() {
        return vram;
    }

    public long getCore_Frequency() {
        return core_Frequency;
    }

    public long getMemory_Frequency() {
        return memory_Frequency;
    }
}
