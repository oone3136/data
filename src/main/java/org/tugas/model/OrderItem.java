package org.tugas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem extends PanacheEntityBase {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @ManyToOne(targetEntity = Order.class)
    @JsonIgnore
    @Column(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(targetEntity = Item.class)
    @JsonIgnore
    @Column(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "quality", nullable = false)
    private Integer quality;

    @Column(name = "price_total", nullable = false)
    private Double priceTotal;

    @Column(name = "note", columnDefinition = "text")
    private String note;
}
