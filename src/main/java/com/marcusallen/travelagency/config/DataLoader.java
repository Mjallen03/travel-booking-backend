package com.marcusallen.travelagency.config;

import com.marcusallen.travelagency.dao.CustomerRepository;
import com.marcusallen.travelagency.dao.DivisionRepository;
import com.marcusallen.travelagency.entities.Customer;
import com.marcusallen.travelagency.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public DataLoader(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {
        if (customerRepository.count() < 5) {
            Division division1 = divisionRepository.findById(1L).orElse(null);
            Division division2 = divisionRepository.findById(2L).orElse(null);
            Division division3 = divisionRepository.findById(3L).orElse(null);
            Division division4 = divisionRepository.findById(4L).orElse(null);
            Division division5 = divisionRepository.findById(5L).orElse(null);

            Customer c1 = new Customer();
            c1.setFirstName("Marcus");
            c1.setLastName("Allen");
            c1.setAddress("123 Main St");
            c1.setPostalCode("90210");
            c1.setPhone("555-1234");
            c1.setDivision(division1);

            Customer c2 = new Customer();
            c2.setFirstName("Emily");
            c2.setLastName("Stone");
            c2.setAddress("456 Oak Ave");
            c2.setPostalCode("94103");
            c2.setPhone("555-5678");
            c2.setDivision(division2);

            Customer c3 = new Customer();
            c3.setFirstName("John");
            c3.setLastName("Carter");
            c3.setAddress("789 Pine Rd");
            c3.setPostalCode("33101");
            c3.setPhone("555-9999");
            c3.setDivision(division3);

            Customer c4 = new Customer();
            c4.setFirstName("Sophia");
            c4.setLastName("Nguyen");
            c4.setAddress("321 Elm Blvd");
            c4.setPostalCode("60614");
            c4.setPhone("555-4321");
            c4.setDivision(division4);

            Customer c5 = new Customer();
            c5.setFirstName("David");
            c5.setLastName("Wright");
            c5.setAddress("654 Cedar Ct");
            c5.setPostalCode("30309");
            c5.setPhone("555-6789");
            c5.setDivision(division5);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);

            System.out.println("✅ 5 customers successfully added!");
        } else {
            System.out.println("✅ Customers already exist. Skipping data load.");
        }
    }
}
