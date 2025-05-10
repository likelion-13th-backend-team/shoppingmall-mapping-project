package com.springboot.hwmapping.repository;

import com.springboot.hwmapping.entity.Customer;
import com.springboot.hwmapping.entity.CustomerInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Test
    void relationshipTest() {

        Customer customer = new Customer();
        customer.setName("홍길동");
        customerRepository.save(customer);

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName("홍길동");
        customerInfo.setCustomerPhoneNumber("010-1234-5678");
        customerInfo.setCustomerEmail("hong@example.com");
        customerInfo.setCustomerAddress("서울시 강남구");
        customerInfo.setCustomer(customer);

        customerInfoRepository.save(customerInfo);

        System.out.println("check 1");
        Customer findCustomer = customerRepository.findById(customer.getId()).get();
        System.out.println(findCustomer.getCustomerInfo());
    }
}

