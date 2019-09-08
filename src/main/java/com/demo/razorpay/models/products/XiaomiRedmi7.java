package com.demo.razorpay.models.products;

import com.demo.razorpay.models.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XiaomiRedmi7")
@XmlAccessorType(XmlAccessType.FIELD)
public class XiaomiRedmi7 extends Product {

    public XiaomiRedmi7(){
        super();
        this.setRowId(1);
        this.setName("Xiaomi Readmi 7");
        this.setPrice(1250000);
        this.setPerformance("Octa core");
        this.setDisplay("6.26\" (15.9 cm)");
        this.setStorage("32 GB");
        this.setCamera("12 MP + 2 MP");
        this.setBattery("4000 mAh");
        this.setRam("2 GB");
        this.setLaunchDate("April 29, 2019 (Official)");
    }

    public XiaomiRedmi7(String id){
        super(id);
        this.setRowId(1);
        this.setName("Xiaomi Readmi 7");
        this.setPrice(1250000);
        this.setPerformance("Octa core");
        this.setDisplay("6.26\" (15.9 cm)");
        this.setStorage("32 GB");
        this.setCamera("12 MP + 2 MP");
        this.setBattery("4000 mAh");
        this.setRam("2 GB");
        this.setLaunchDate("April 29, 2019 (Official)");
    }
}
