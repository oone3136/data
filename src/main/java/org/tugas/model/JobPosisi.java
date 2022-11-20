package org.tugas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Create;

import javax.persistence.*;

@Entity
@Table(name = "job_posisi")
public class JobPosisi extends Create {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private double salary;

    public JobPosisi() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
