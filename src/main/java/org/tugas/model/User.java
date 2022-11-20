package org.tugas.model;

import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Update;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;


@Entity
@Table(name = "users")
public class User extends Update {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mobile_phone_number",nullable = false, length = 20)
    private String mobilePhoneNumber;

    @Column(name = "work_phone_number",nullable = false, length = 20)
    private String workPhoneNumber;

    @Column(name = "login_name",nullable = false, length = 20)
    private String loginName;

    @Column(name = "password",nullable = false, length = 20)
    private String password;

    @Column(name = "address",columnDefinition = "text")
    private String adress;


    public User() {
        super();
    }

    public static boolean isEmptyByLoginName(String loginName){
        return User.find("login_name = ?1", loginName).firstResultOptional().isEmpty();
    }

    public static Optional<User> findByLoginName(String loginName){
        return User.find("login_name = ?1", loginName).firstResultOptional();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
