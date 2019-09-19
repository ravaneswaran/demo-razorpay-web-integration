package com.demo.razorpay.models;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "OrderProductJoin")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@Table(name="ORDER_PRODUCT_JOIN")
public class OrderProductJoin {

    @Id
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "order")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Order order;

    @XmlElement(name = "product")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    @XmlElement(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @XmlElement(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public OrderProductJoin(){
        this.setId(UUID.randomUUID().toString());

        Date date = new Date();
        this.setCreatedDate(date);
        this.setModifiedDate(date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
