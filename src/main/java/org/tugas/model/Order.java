package org.tugas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.tugas.base.Create;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends Create {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @ManyToOne(targetEntity = Employe.class)
    @JsonIgnore
    @JoinColumn(name = "cashir", nullable = false)
    private Employe employe;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @Column(name = "tax")
    private Double tax;

    @ManyToOne(targetEntity = PaymentType.class)
    @JsonIgnore
    @JoinColumn(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    public Order() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
