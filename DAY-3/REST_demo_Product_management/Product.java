package com.example.REST_demo;

public class Product
{
    private int P_id;
    private String P_name;
    private int P_quantity;
    private double P_price;

    public Product(int p_id, String p_name, int p_quantity, double p_price) {
        P_id = p_id;
        P_name = p_name;
        P_quantity = p_quantity;
        P_price = p_price;
    }

    public int getP_id() {
        return P_id;
    }

    public String getP_name() {
        return P_name;
    }

    public int getP_quantity() {
        return P_quantity;
    }

    public double getP_price() {
        return P_price;
    }

    public void setP_id(int p_id) {
        P_id = p_id;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public void setP_quantity(int p_quantity) {
        P_quantity = p_quantity;
    }

    public void setP_price(double p_price) {
        P_price = p_price;
    }

}
