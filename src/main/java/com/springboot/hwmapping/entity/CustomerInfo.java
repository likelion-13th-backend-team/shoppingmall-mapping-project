package com.springboot.hwmapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customerInfo")
public class CustomerInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String customerName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerAddress;


    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
