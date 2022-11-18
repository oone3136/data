package org.tugas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Update;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class Item extends Update {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String Name;

    @Column(name = "description", nullable = false, length = 10)
    private String description;

    @Column(name = "kategori", nullable = false, length = 10)
    private String category;

    @Column(name = "price",nullable = false)
    private String price;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "created_by", nullable = false)
    private JobPosisi createdBy;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "updated_by", nullable = false)
    private LastEdukasi updatedBy;

    public Item() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
