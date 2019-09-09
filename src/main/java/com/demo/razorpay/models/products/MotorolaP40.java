package com.demo.razorpay.models.products;

import com.demo.razorpay.models.Product;

public class MotorolaP40 extends Product {

    public MotorolaP40(){
        super();
        this.setRowId(2);
        this.setName("Motorola P40");
        this.setPrice(3000000);
        this.setPerformance("Qualcomm Snapdragon 710");
        this.setDisplay("6.2 inches (15.75 cm)");
        this.setStorage("128 GB");
        this.setCamera("48MP + 5MP");
        this.setBattery("4030 MAH");
        this.setRam("6 GB");
        this.setLaunchDate("30th September 2019");
    }
}
