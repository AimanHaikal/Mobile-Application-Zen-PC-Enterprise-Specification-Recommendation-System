package com.example.zenpcenterprise;

public class Storage extends Products{
    long storage_Size, transfer_Speed;

    public Storage(){super();}

    public Storage(long storage_Size, long transfer_Speed) {
        super();
        this.storage_Size = storage_Size;
        this.transfer_Speed = transfer_Speed;
    }

    public long getStorage_Size() {
        return storage_Size;
    }

    public long getTransfer_Speed() {
        return transfer_Speed;
    }
}
