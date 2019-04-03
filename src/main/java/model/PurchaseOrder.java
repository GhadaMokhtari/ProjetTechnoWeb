/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author infoo
 */
public class PurchaseOrder {

    private int ordernum;
    private int idcustomer;
    private int idproduct;
    private int quantity;
    private int shippingcost;
    private Date salesDate;
    private Date shippingDate;
    private String company;

    public PurchaseOrder(int ordernum, int idcustomer, int idproduct, int quantity, int shippingcost, Date salesDate, Date shippingDate, String company) {
        this.ordernum=ordernum;
        this.idcustomer=idcustomer;
        this.idproduct=idproduct;
        this.quantity=quantity;
        this.shippingcost=shippingcost;
        this.salesDate=salesDate;
        this.shippingDate=shippingDate;
        this.company=company;
    }

    //GETTER
    
    public int getOrderNumber() {
        return ordernum;
    }

    public int getIdCustomer() {
        return idcustomer;
    }
    
    public int getIdProduct(){
        return idproduct;
    }
    
    public int getShippingCost(){
        return shippingcost;
    }
    
    
    public Date getSalesDate() {
        return salesDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }
    
    public String getCompany() {
        return company;
    }


    
}


