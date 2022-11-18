package org.tugas.base;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Create extends PanacheEntityBase {

    @Column(name = "created_at")
    @CreationTimestamp
    public Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }
}
