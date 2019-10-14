package rc.demo.app.models;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@Table(name="USERS")
public class User {

    public static final String ADMIN_USER = "ADMIN-USER";
    public static final String APP_USER = "APP-USER";

    @Id
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "middle_initial")
    private String middleInitial;

    @XmlElement(name = "last_name")
    private String lastName;

    @Column(unique=true)
    @XmlElement(name = "email_id")
    private String emailId;

    @XmlElement(name = "password")
    private String password;

    @XmlElement(name = "type")
    private String type;

    /*@XmlElement(name = "orders")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();*/

    @XmlElement(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @XmlElement(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public User(){
        this.setId(UUID.randomUUID().toString());
        this.setType(User.APP_USER);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isAdiminUser(){
        return ADMIN_USER.equals(this.getType());
    }
}
