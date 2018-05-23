package com.product.register.service;

import java.util.List;


public interface RegisterService {
    public boolean registerCustomer(List<Object> params);
    public boolean checkCustomer(List<Object> params);
    public boolean registerAdmin(List<Object> params);
    public boolean checkAdmin(List<Object> params);
}