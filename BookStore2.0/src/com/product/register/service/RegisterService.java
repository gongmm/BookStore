package com.product.register.service;

import domain.Admin;
import domain.Customer;

import java.util.List;


public interface RegisterService {
    public boolean registerCustomer(List<Object> params);
    public Customer checkCustomer(List<Object> params);
    public boolean registerAdmin(List<Object> params);
    public Admin checkAdmin(List<Object> params);
}