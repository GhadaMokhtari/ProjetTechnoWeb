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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import model.DAOException;

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
	public List<PurchaseOrder> allCommandesByCustomer(int customerId) throws SQLException {

		List<PurchaseOrder> result = new LinkedList<>();

		String sql = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID = ?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                           stmt.setInt(1, customerId);		
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
        
    /**
	 * Contenu de la table PRODUCT
	 * @return Liste des produits
	 * @throws SQLException renvoyées par JDBC
	 */
        public List<Product> allProduct() throws SQLException {

		List<Product> result = new LinkedList<>();

		String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_ID";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                                int idproduct=rs.getInt("PRODUCT_ID");
                                int idmanufacturer=rs.getInt("MANUFACTURER_ID");
                                String productcode=rs.getString("PRODUCT_CODE");
                                int purchasecost=rs.getInt("PURCHASE_COST");
                                int quantityonhand=rs.getInt("QUANTITY_ON_HAND");
                                int markup=rs.getInt("MARKUP");
                                String available=rs.getString("AVAILABLE");
                                String description=rs.getString("DESCRIPTION");

				Product p = new Product(idproduct, idmanufacturer, productcode, purchasecost, quantityonhand, markup, available, description);
				result.add(p);
			}
		}
		return result;
	}

    public int ajoutCommande(int ordernum, int idcustomer, int idproduct, int quantity, int shippingcost, Date salesDate, Date shippingDate, String company) throws SQLException {
        int result = 0;
        String sql = "INSERT INTO PURCHASE_ORDER VALUES=(?,?,?,?,?,?,?,?) ";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ordernum);
            stmt.setInt(2, idcustomer);
            stmt.setInt(3, idproduct);
            stmt.setInt(4, quantity);
            stmt.setInt(5, shippingcost);
            stmt.setDate(6, (java.sql.Date) salesDate);
            stmt.setDate(7, (java.sql.Date) shippingDate);
            stmt.setString(8, company);
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

    public int modifierCommande(int Qte, int ordernum) throws SQLException {
        int result=0;
        String sql = "UPDATE PURCHASE_ORDER SET QUANTITY = ? WHERE ORDER_NUM=?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, Qte);
            stmt.setInt(2, ordernum);
            result=stmt.executeUpdate();
        }
        return result;
    }
    public List<Float> CAClient(int CustomerID, Date Date_D, Date Date_F) throws DAOException {
        float result=0;
        List<Float> mList = new ArrayList();
        String sql ="SELECT * FROM PURCHASE_ORDER INNER JOIN PRODUCT USING(PRODUCT_ID) WHERE CUSTOMER_ID=? and Sales_date BETWEen '?' and '?'";
        try (Connection connection = myDataSource.getConnection(); 
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, CustomerID);
                        stmt.setDate(2, (java.sql.Date) Date_D);
                        stmt.setDate(3, (java.sql.Date) Date_F);
                        
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					float purchase_cost = rs.getFloat("PURCHASE_COST");
					float shipping_cost = rs.getFloat("SHIPPING_COST");
					
					result = purchase_cost+shipping_cost;
                                mList.add(result);
                                        } 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        return mList;
    }
    public List<Float> CAProduct(int ProductID, Date date_D, Date date_F) throws DAOException {
        float result=0;
        List<Float> mList = new ArrayList();
        String sql ="SELECT * FROM PURCHASE_ORDER INNER JOIN PRODUCT USING(PRODUCT_ID) WHERE PRODUCT_ID=? and Sales_date BETWEen '?' and '?'";
        try (Connection connection = myDataSource.getConnection(); 
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, ProductID);
                        stmt.setDate(2, (java.sql.Date) date_D);
                        stmt.setDate(3, (java.sql.Date) date_F);
                        
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					float purchase_cost = rs.getFloat("PURCHASE_COST");
					float shipping_cost = rs.getFloat("SHIPPING_COST");
					
					result = purchase_cost+shipping_cost;
                                mList.add(result);
                                        } 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        return mList;
    }
    public List<Float> CA_ZoneGéo(String ZIP, Date D_Debut, Date D_Fin) throws DAOException{
        float result=0;
        List<Float> mList = new ArrayList();
        String sql ="SELECT * FROM PURCHASE_ORDER INNER JOIN CUSTOMER USING(Customer_ID) INNER JOIN MICRO_MARKET ON MICRO_MARKET.ZIP_CODE=CUSTOMER.ZIP WHERE ZIP_CODE='?' AND SALES_DATE BETWEEN '?' AND '?'";
        try (Connection connection = myDataSource.getConnection(); 
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, ZIP);
                        stmt.setDate(2, (java.sql.Date) D_Debut);
                        stmt.setDate(3, (java.sql.Date) D_Fin);
                        
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					float purchase_cost = rs.getFloat("PURCHASE_COST");
					float shipping_cost = rs.getFloat("SHIPPING_COST");
					
					result = purchase_cost+shipping_cost;
                                mList.add(result);
                                        } 
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
        return mList;
    }
}
