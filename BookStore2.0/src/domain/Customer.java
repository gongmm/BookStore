package domain;

import java.io.Serializable;

public class Customer implements Serializable{


    private static final long serialVersionUID = 1L;
    int customerId;
     String customerName;
     String customerTrueName;
     String customerSex;
     int customerTel;
     String customerEmail;
     String customerAddr;



    public Customer() {
        // TODO Auto-generated constructor stub
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerTrueName() {
        return customerTrueName;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public int getCustomerTel() {
        return customerTel;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerTrueName(String customerTrueName) {
        this.customerTrueName = customerTrueName;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public void setCustomerTel(int customerTel) {
        this.customerTel = customerTel;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerName, String customerTrueName, String customerSex, int customerTel, String customerEmail, String customerAddr) {
        this.customerName = customerName;
        this.customerTrueName = customerTrueName;
        this.customerSex = customerSex;
        this.customerTel = customerTel;
        this.customerEmail = customerEmail;
        this.customerAddr = customerAddr;
    }
}
