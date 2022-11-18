package org.tugas.model;

import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Create;

import javax.persistence.*;

@Entity
@Table(name = "payment_tipe")
public class PaymentType extends Create {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "nama", nullable = false, length = 30)
    private String nama;

    @Column(name = "code", nullable = false, length = 5)
    private String code;

    public PaymentType() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
