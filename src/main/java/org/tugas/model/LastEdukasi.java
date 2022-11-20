package org.tugas.model;

import org.hibernate.annotations.GenericGenerator;

import org.tugas.base.Create;

import javax.persistence.*;

@Entity
@Table(name = "last_education")
public class LastEdukasi extends Create{
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "nama", nullable = false, length = 30)
    private String nama;

    public LastEdukasi() {

        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
