package com.example.hibernatecustomermanagement.service.implement;

import com.example.hibernatecustomermanagement.model.Customer;
import com.example.hibernatecustomermanagement.repository.CustomerRepository;
import com.example.hibernatecustomermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service    //Khi viet ServiceImpl thi phai danh dau @Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired  //-> de lay repository trong Spring container ra,  @Autowired tuong ung Singeton
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    //Khong co cac ham add, update ma chi co duy nhat ham save de them moi hoac update
    //Neu 1 id chua co trong bang CSDL thi save co chuc nang la them moi
    //Neu 1 id da co trong bang CSDL thi save co chuc nang la cap nhat
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
