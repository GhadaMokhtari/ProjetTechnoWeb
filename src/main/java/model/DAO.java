/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

public class DAO {

    private final DataSource myDataSource;

    /**
     * @param dataSource la source de données à utiliser
     */
    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }
    
    
    /**
	 * Contenu de la table PURCHASE_ORDER
	 * @return Liste des commandes
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<PurchaseOrder> allCommandes() throws SQLException {

		List<PurchaseOrder> result = new LinkedList<>();

		String sql = "SELECT * FROM PURCHASE_ORDER ORDER BY ORDER_NUM";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int num=rs.getInt("ORDER_NUM");
                                int idclient=rs.getInt("CUSTOMER_ID");
                                int idproduit=rs.getInt("PRODUCT_ID");
                                int quantity=rs.getInt("QUANTITY");
                                int shippingcost=rs.getInt("SHIPPING_COST");
                                Date salesdate=rs.getDate("SALES_DATE");
                                Date shippingdate=rs.getDate("SHIPPING_DATE");
                                String company=rs.getString("FREIGHT_COMPANY");

				PurchaseOrder c = new PurchaseOrder(num, idclient, idproduit, quantity, shippingcost, salesdate, shippingdate, company);
				result.add(c);
			}
		}
		return result;
	}
    

    public int ajoutCommande(int Qte) throws SQLException {
        int result = 0;
        String sql = "INSERT INTO PURCHASE_ORDER VALUES=(?) ";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, Qte);
            result = stmt.executeUpdate();
        }
        return result;
    }

    public int supprimeCommande(int OrderNum) throws SQLException {
        int result = 0;
        String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, OrderNum);
            result = stmt.executeUpdate();
        }
        return result;
    }

    public int modifierCommande(int Qte, int ProductID) throws SQLException {
        int result=0;
        String sql = "UPDATE PURCHASE_ORDER SET QUANTITY = ? , PRODUCT_CODE = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, Qte);
            stmt.setInt(2, ProductID);
            result=stmt.executeUpdate();
        }
        return result;
    }
}
