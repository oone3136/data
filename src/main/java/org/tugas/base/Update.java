package org.tugas.base;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Update extends Create{

    @Column(name = "created_at")
    @UpdateTimestamp
    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
