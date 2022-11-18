package org.tugas.model;

import org.hibernate.annotations.GenericGenerators;
import org.tugas.base.Create;

import javax.persistence.*;

@Entity
@Table(name = "last_education")
public class LastEdukasi extends Create{
    @Id
    @GenericGenerators(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "nama", nullable = false, length = 30)
    private String nama;

    public LastEdukasi() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
