package com.example.hibernatecustomermanagement.repository;

import com.example.hibernatecustomermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     //Khi viet Repository thi phai danh dau @Repository
//Customer -> KDL can truy van
//Long -> KDL cua khoa chinh
//CustomerRepository <=> class CustomerDAO voi day du chuc nang CRUD, findByID chi viec viet dung ten phuong thuc
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Lay ra ds theo ten
    List<Customer> findAllByNameContaining(String name);
}
