/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bonneviale
 */
public class Product {
    
    private int idproduct;
    private int idmanufacturer;
    private String productcode;
    private int purchasecost;
    private int quantityonhand;
    private int markup;
    private String available;
    private String description;
    
    public Product(int idproduct, int idmanufacturer, String productcode, int purchasecost, int quantityonhand, int markup, String available, String description){
        this.idproduct=idproduct;
        this.idmanufacturer=idmanufacturer;
        this.productcode=productcode;
        this.purchasecost=purchasecost;
        this.quantityonhand=quantityonhand;
        this.markup=markup;
        this.available=available;
        this.description=description;
    }
    
    //GETTER
    
    public int getIdProduct() {
        return idproduct;
    }
    
    public int getIdManufacturer(){
        return idmanufacturer;
    }
    
    public String getProductCode(){
        return productcode;
    }
    
    public int getPurchaseCost(){
        return purchasecost;
    }
    
    public int getQuantityOnHand(){
        return quantityonhand;
    }
    
    public int getMarkup(){
        return markup;
    }
    
    public String getAvailable(){
        return available;
    }
    
    public String getDescription(){
        return description;
    }
}
