package com.truongtd.orderfood.dto;

/**
 * Created by Truong_it on 7/7/2017.
 */

public class Dish {
    private int idDish;
    private String foodName;
    private float price;
    private String typeCode;

    public Dish(int idDish, String foodName, float price, String typeCode) {
        this.idDish = idDish;
        this.foodName = foodName;
        this.price = price;
        this.typeCode = typeCode;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
