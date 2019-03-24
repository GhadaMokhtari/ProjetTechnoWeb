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
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;


public class DAO {
    
    private final DataSource myDataSource;

	/**
	 *@param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
       public void ajoutCommande() throws SQLException{
           String sql = "SELECT * FROM CUSTOMER WHERE STATE = ?";
		try (Connection connection  = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)){
                    
                }
       }
}
