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
