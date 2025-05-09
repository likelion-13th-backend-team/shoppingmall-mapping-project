package org.example.mapping1;

import org.example.mapping1.entity.Customer;
import org.example.mapping1.entity.Order;
import org.example.mapping1.repository.CustomerRepository;
import org.example.mapping1.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }


    @PostMapping
    public Customer createCustomerWithOrders(@RequestBody CustomerRequest request) {
        Customer customer = new Customer(request.name);

        for (String productName : request.orders) {
            Order order = new Order(productName);
            customer.getOrders().add(order);
        }

        return customerRepository.save(customer);
    }

  
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

  
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }


    public static class CustomerRequest {
        public String name;
        public List<String> orders;
    }
}
