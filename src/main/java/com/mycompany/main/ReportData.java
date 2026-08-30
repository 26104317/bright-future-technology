/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * 26104317
 * @author Mudau Adaho
 */
public class ReportData {

    private String productCode;
    private String productName;
    private double warranty; 
    private int category; 
    private double price;
    private int stockLevels;
    private String supplier;


    public ReportData(String productCode, String productName, double warranty,
            int category, double price, int stockLevels, String supplier) {
        this.productCode = productCode;
        this.productName = productName;
        this.warranty = warranty;
        this.category = category;
        this.price = price;
        this.stockLevels = stockLevels;
        this.supplier = supplier;
    }

  
    public String getProductCode() {
        return this.productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getWarranty() {
        return this.warranty;
    }

    public int getCategory() {
        return this.category;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStockLevels() {
        return this.stockLevels;
    }

    public String getSupplier() {
        return this.supplier;
    }

  
    public void setProductCode(String code) {
        this.productCode = code;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockLevels(int stockLevel) {
        this.stockLevels = stockLevel;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

}