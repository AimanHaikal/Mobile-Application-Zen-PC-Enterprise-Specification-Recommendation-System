package com.example.zenpcenterprise;

public class Products {
    String product_ID, product_Name, product_Type;
    double product_Price;

    public Products(){}

    public Products(String product_ID, String product_Name, String product_Type, double product_Price) {
        this.product_ID = product_ID;
        this.product_Name = product_Name;
        this.product_Type = product_Type;
        this.product_Price = product_Price;
    }

    public String getProduct_ID() {
        return product_ID;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public String getProduct_Type() {
        return product_Type;
    }

    public double getProduct_Price() {
        return product_Price;
    }
}
