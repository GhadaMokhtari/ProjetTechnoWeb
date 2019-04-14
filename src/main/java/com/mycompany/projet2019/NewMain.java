/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet2019;

import java.sql.SQLException;
import javax.sql.DataSource;
import model.Customer;
import model.CustomerDAO;
import model.DAO;
import model.DataSourceFactory;
import simplejdbc.DAOException;

/**
 *
 * @author infoo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, DAOException {
        // TODO code application logic here
        
    
        
        CustomerDAO dao = new CustomerDAO( DataSourceFactory.getDataSource());
        
        String email = "jumboeagle@example.com";
        
        Customer user = dao.LoginCustomer(1,email);
        
        System.out.println("user "+user.getEmail());
        
        DAO daof = new DAO( DataSourceFactory.getDataSource());
        
       // System.out.println("order "+daof.allCommandes().size());
    }
    
}
