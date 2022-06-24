package com.example.zenpcenterprise;

public class Customer {
    String cust_ID, cust_Name, cust_Address, cust_Phone, cust_Password;

    public Customer(){}

    public Customer(String cust_ID, String cust_Name, String cust_Address, String cust_Phone, String cust_Password) {
        this.cust_ID = cust_ID;
        this.cust_Name = cust_Name;
        this.cust_Address = cust_Address;
        this.cust_Phone = cust_Phone;
        this.cust_Password = cust_Password;
    }

    public String getCust_ID() {
        return cust_ID;
    }

    public String getCust_Name() {
        return cust_Name;
    }

    public String getCust_Address() {
        return cust_Address;
    }

    public String getCust_Phone() {
        return cust_Phone;
    }

    public String getCust_Password() {
        return cust_Password;
    }
}
