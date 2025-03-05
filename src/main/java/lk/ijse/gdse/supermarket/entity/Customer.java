package lk.ijse.gdse.supermarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/20/2025 2:55 PM
 * Project: Relationship
 * --------------------------------------------
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
// inverse side (Order - Customer)
public class Customer implements SuperEntity {
    @Id
    @Column(name = "customer_id")
    private String id;

    private String name;
    private String nic;
    private String email;
    private String phone;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Order> orders;
}
