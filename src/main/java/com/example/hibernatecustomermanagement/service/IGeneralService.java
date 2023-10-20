package com.example.hibernatecustomermanagement.service;

import java.util.Optional;

//Interface su dung generic de mo ta cac phuong thuc chung ma tat ca cac service cap cho cac loai CSDL khac nhau nhu
//SQL, MySQL, MongoDB,....
//Voi muc dich dung 1 loai CSDL duy nhat thi viec tao mo hinh interface nay ko can thiet
public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
