package rc.demo.app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment-transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
public class PaymentTransaction extends Transaction {

	@Id
	@XmlElement(name = "amount")
	private String id;
	
	@XmlElement(name = "entity")
	private String entity;
	
	@XmlElement(name = "amount")
	private int amount;
	
	@XmlElement(name = "currency")
	private String currency;
	
	@XmlElement(name = "status")
	private String status;
	
	@XmlElement(name = "method")
	private String method;
	
	@XmlElement(name = "order_id")
	private String orderId;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "amount_refunded")
	private int amountRefunded;
	
	@XmlElement(name = "refund_status")
	private String refundStatus;
	
	@XmlElement(name = "email")
	private String email;
	
	@XmlElement(name = "contact")
	private String contact;
	
	@XmlElement(name = "notes")
	@Transient
	private Object notes;
	
	@XmlElement(name = "fee")
	private int fee;
	
	@XmlElement(name = "tax")
	private int tax;
	
	@XmlElement(name = "error_code")
	private String errorCode;
	
	@XmlElement(name = "error_description")
	private String errorDescription;

	@XmlElement(name = "created_at")
	private long createdAt;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmountRefunded() {
		return amountRefunded;
	}

	public void setAmountRefunded(int amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Object getNotes() {
		return notes;
	}

	public void setNotes(Object notes) {
		this.notes = notes;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
}