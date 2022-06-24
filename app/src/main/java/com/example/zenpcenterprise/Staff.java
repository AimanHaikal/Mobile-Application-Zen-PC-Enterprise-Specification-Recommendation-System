package com.example.zenpcenterprise;

public class Staff {
    String staff_ID, staff_Name, staff_Address, staff_Phone, staff_Password;

    public Staff(){}

    public Staff(String staff_ID, String staff_Name, String staff_Address, String staff_Phone, String staff_Password) {
        this.staff_ID = staff_ID;
        this.staff_Name = staff_Name;
        this.staff_Address = staff_Address;
        this.staff_Phone = staff_Phone;
        this.staff_Password = staff_Password;
    }

    public String getStaff_ID() {
        return staff_ID;
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public String getStaff_Address() {
        return staff_Address;
    }

    public String getStaff_Phone() {
        return staff_Phone;
    }

    public String getStaff_Password() {
        return staff_Password;
    }
}
