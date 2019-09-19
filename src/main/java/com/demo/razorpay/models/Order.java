package com.demo.razorpay.models;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@Table(name="ORDERS")
public class Order {

    public static final String PAYMENT_PENDING = "PAYMENT-PENDING";
    public static final String CANCELLED = "CANCELLED";
    public static final String RETURNED = "RETURNED";

    @Id
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @XmlElement(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Order(){
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
