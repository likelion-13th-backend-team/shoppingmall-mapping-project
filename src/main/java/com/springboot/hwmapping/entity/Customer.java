package com.springboot.hwmapping.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "customer")
    @ToString.Exclude // 순환참조 문제 해결
    private CustomerInfo customerInfo;
}