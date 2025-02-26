package lk.ijse.gdse.supermarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/20/2025 3:05 PM
 * Project: Relationship
 * --------------------------------------------
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
// owning side (Order - Customer)
public class Order implements SuperEntity {

    @Id
    @Column(name = "order_id")
    private String id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;
}
