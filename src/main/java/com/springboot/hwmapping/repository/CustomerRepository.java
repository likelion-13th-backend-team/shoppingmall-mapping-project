package com.springboot.hwmapping.repository;

import com.springboot.hwmapping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
