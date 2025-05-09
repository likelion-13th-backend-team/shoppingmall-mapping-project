package org.example.mapping1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }
}
