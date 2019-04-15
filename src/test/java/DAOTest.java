/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static model.DataSourceFactory.getDataSource;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import model.DAO;
import model.DAOException;
//import model.DAOException;
//import model.DAO;
//import model.DataSourceFactory;

/**
 *
 * @author RBarbara
 */
public class DAOTest {

    private DAO myDAO;
    private DataSource myDataSource;
    private static Connection myConnection;

    /**
     * Test for the data base
     */
    @Before
    //Test la création de la BDD.
    public void createBDD() throws SQLException {
        myDataSource = getDataSource();
        myConnection = myDataSource.getConnection();
        myDAO = new DAO(myDataSource);
    }

    @After
    //Test la destruction de la BDD.
    public void deleteBDD() throws SQLException {
        myConnection.close();
        myDAO = null;
    }

    /**
     * Test for the class DAO
     */
    @Test
    //Test l'ajout de commande.
    public void addOrder() throws DAOException {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    @Test
    //Test la suppression de commande.
    public void deleteOrder() throws DAOException {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    @Test
    //Test la modification de la commande.
    public void changeOrder() throws DAOException {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Test for the class CustomerDAO
     */
    @Test
    //Test si le login fonctionne
    public void logIN() throws DAOException {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Test for the class ???
     */
    @Test
    //Test le calcule du prix du produit.
    public void finalPrice() {
        float price = 10;
        int quantity = 1;
        float discountRate = 0;
        float shippingcost = 10;
        float markup = 0;
        assertEquals(price * quantity * 0.01 * (1 - discountRate) + shippingcost, "Méthode qui calcule le prix final");
    }
}
