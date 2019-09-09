package com.demo.razorpay.models.products;

import com.demo.razorpay.models.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XiaomiMiA3")
@XmlAccessorType(XmlAccessType.FIELD)
public class XiaomiMiA3 extends Product {

    public XiaomiMiA3(){
        super();
        this.setRowId(1);
        this.setName("Xiaomi Mi A3");
        this.setPrice(750000);
        this.setPerformance("Octa core");
        this.setDisplay("6.01\" (720 X 1560)");
        this.setStorage("64 GB");
        this.setCamera("48 + 8 + 2 | 32 MP");
        this.setBattery("4030 MAH");
        this.setRam("4 GB");
        this.setLaunchDate("April 29, 2019 (Official)");
    }

    public XiaomiMiA3(String id){
        super(id);
        this.setRowId(1);
        this.setName("Xiaomi Mi A3");
        this.setPrice(750000);
        this.setPerformance("Octa core");
        this.setDisplay("6.01\" (720 X 1560)");
        this.setStorage("64 GB");
        this.setCamera("48 + 8 + 2 | 32 MP");
        this.setBattery("4030 MAH");
        this.setRam("4 GB");
        this.setLaunchDate("April 29, 2019 (Official)");
    }
}
