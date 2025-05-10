package com.springboot.hwmapping.repository;

import com.springboot.hwmapping.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}
