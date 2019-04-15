/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import model.DAOException;

/**
 *
 * @author infoo
 */
public class CustomerDAO {
    
    
    
     private final DataSource myDataSource;

    /**
     * @param dataSource la source de données à utiliser
     */
    public CustomerDAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }
    
    
	public Customer LoginCustomer(int customerID, String email) throws DAOException {
		Customer result = null;

		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ? AND EMAIL = ?";
		try (Connection connection = myDataSource.getConnection(); 
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, customerID);
                        stmt.setString(2, email);
                        
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String name = rs.getString("NAME");
					String address = rs.getString("ADDRESSLINE1");
					
					result = new Customer();
                                        result.setCustomerID(customerID);
                                        result.setEmail(email);
				} 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result;
	}
}
