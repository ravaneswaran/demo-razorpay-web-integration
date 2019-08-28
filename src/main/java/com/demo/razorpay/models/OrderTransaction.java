package com.demo.razorpay.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "order-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderTransaction extends Transaction {

    @Id
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "amount")
    private int amount;

    @XmlElement(name = "amount_paid")
    private int amountPaid;

    @XmlElement(name = "notes", nillable = true)
    @Transient
    private Object notes;

    @XmlElement(name = "amount_due")
    private int amountDue;

    @XmlElement(name = "created_at")
    private long createdAt;

    @XmlElement(name = "currency")
    private String currency;

    @XmlElement(name = "receipt")
    private String receipt;

    @XmlElement(name = "entity")
    private String entity;

    @XmlElement(name = "offer_id", nillable = true)
    @Transient
    private Object offerId;

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "attempts")
    private int attempts;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Object getOfferId() {
        return offerId;
    }

    public void setOfferId(Object offerId) {
        this.offerId = offerId;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
