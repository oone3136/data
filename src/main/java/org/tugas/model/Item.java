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
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String Name;

    @Column(name = "description", nullable = false, length = 10)
    private String description;

    @Column(name = "categori", nullable = false, length = 10)
    private String category;

    @Column(name = "price",nullable = false)
    private String price;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;

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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
}
