package org.tugas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Update;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employe")
public class Employe extends Update {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "dob", nullable = false)
    private LocalDateTime dob;

    @Column(name = "pob",nullable = false, length = 50)
    private String pob;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mobile_phone_number",nullable = false, length = 20)
    private String mobilePhoneNumber;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(targetEntity = JobPosisi.class)
    @JsonIgnore
    @JoinColumn(name = "job_posisi_id", nullable = false)
    private JobPosisi jobPosisi;

    @ManyToOne(targetEntity = LastEdukasi.class)
    @JsonIgnore
    @JoinColumn(name = "last_education_id", nullable = false)
    private LastEdukasi lastEdukasi;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "created_by", nullable = false)
    private JobPosisi createdBy;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "updated_by", nullable = false)
    private LastEdukasi updatedBy;

    public Employe() {
        super();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public JobPosisi getJobPosisi() {
        return jobPosisi;
    }

    public void setJobPosisi(JobPosisi jobPosisi) {
        this.jobPosisi = jobPosisi;
    }

    public LastEdukasi getLastEdukasi() {
        return lastEdukasi;
    }

    public void setLastEdukasi(LastEdukasi lastEdukasi) {
        this.lastEdukasi = lastEdukasi;
    }

    public JobPosisi getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(JobPosisi createdBy) {
        this.createdBy = createdBy;
    }

    public LastEdukasi getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(LastEdukasi updatedBy) {
        this.updatedBy = updatedBy;
    }
}
