package com.demo.razorpay.models.products;

import com.demo.razorpay.models.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XiaomiMiPlay")
@XmlAccessorType(XmlAccessType.FIELD)
public class XiaomiMiPlay extends Product {

    public XiaomiMiPlay(){
        super();
        this.setRowId(1);
        this.setName("Xiaomi Mi Play");
        this.setPrice(1150000);
        this.setPerformance("MediaTek Helio P35");
        this.setDisplay("5.84-inch");
        this.setStorage("64GB");
        this.setCamera("12MP + 2MP");
        this.setBattery("3000mAh");
        this.setRam("4 GB");
        this.setLaunchDate("December 2018");
    }

    public XiaomiMiPlay(String id){
        super(id);
        this.setRowId(1);
        this.setName("Xiaomi Mi Play");
        this.setPrice(1150000);
        this.setPerformance("MediaTek Helio P35");
        this.setDisplay("5.84-inch");
        this.setStorage("64GB");
        this.setCamera("12MP + 2MP");
        this.setBattery("3000mAh");
        this.setRam("4 GB");
        this.setLaunchDate("December 2018");
    }
}
