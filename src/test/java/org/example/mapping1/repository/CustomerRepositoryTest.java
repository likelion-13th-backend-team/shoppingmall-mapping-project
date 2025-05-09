package org.example.mapping1.repository;
import jakarta.transaction.Transactional;
import org.example.mapping1.entity.Customer;
import org.example.mapping1.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void customerOrderMappingTest() {
        // 고객 생성
        Customer customer = new Customer("김고객");

        // 주문 생성
        Order order1 = new Order("노트북");
        Order order2 = new Order("마우스");

        // 고객에 주문 추가
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        // 저장
        customerRepository.save(customer);

        // 조회
        Customer found = customerRepository.findById(customer.getId()).orElseThrow();
        List<Order> orders = found.getOrders();

        for (Order o : orders) {
            System.out.println("주문 상품: " + o.getProductName());
        }
    }
}
