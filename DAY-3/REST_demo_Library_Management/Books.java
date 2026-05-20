package com.example.REST_demo_library_management;

public class Books {
    private int B_id;
    private String B_name;
    private int B_quantity;
    private double B_price;

    public Books() {
    }

    public Books(int B_id, String B_name, int B_quantity, double B_price) {
        this.B_id = B_id;
        this.B_name = B_name;
        this.B_quantity = B_quantity;
        this.B_price = B_price;
    }

    public int getB_id() {
        return B_id;
    }

    public String getB_name() {
        return B_name;
    }

    public int getB_quantity() {
        return B_quantity;
    }

    public double getB_price() {
        return B_price;
    }

    public void setB_id(int b_id) {
        B_id = b_id;
    }

    public void setB_name(String b_name) {
        B_name = b_name;
    }

    public void setB_quantity(int b_quantity) {
        B_quantity = b_quantity;
    }

    public void setB_price(double b_price) {
        B_price = b_price;
    }

}
