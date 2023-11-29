package com.ra.model.entity;

public class Category {
    private int categoryId;
    private String categoryName;
    private boolean status;
    private int quantity_product;

    public Category() {
    }

    public Category(int categoryId, String categoryName, boolean status, int quantity_product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
        this.quantity_product = quantity_product;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }
}
