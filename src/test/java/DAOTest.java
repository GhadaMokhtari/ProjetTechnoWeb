/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import static JDBC.DataSourceFactory.getDataSource;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.hsqldb.jdbc.JDBCDataSource;
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
import simplejdbc.DAOException;

/**
 *
 * @author RBarbara
 */
/*public class DAOTest {
    //L'objet qu'on va testé.

    private DAO myDAO;
    //La source de donnée.
    private DataSource myDataSource;
    //La connexion de la BDD.
    private static Connection myConnection;
    //Le prix du produit.
  //  private product purchaseCost;

    /**
     * Test for the data base
     */
//    @Before
    //Test la création de la BDD.
   /* public void createBDD() throws IOException, SQLException, SqlToolError {
        myDataSource = getDataSource();
        myConnection = myDataSource.getConnection();
        myDAO = new DAO(myDataSource);
    }

    @After
    //Test la destruction de la BDD.
    public void deleteBDD() throws IOException, SQLException, SqlToolError {
        myConnection.close();
        myDAO = null;
    }

    @Test
    //Test le remplissage de la BDD à partir d'un fichier sql.
    private void fillBDD(String file, Connection myConnection) throws IOException, SQLException, SqlToolError {
        String path = DAOTest.class.getResource(file).getFile();
        SqlFile fileSQL = new SqlFile(new File(path));
        fileSQL.setConnection(myConnection);
        fileSQL.execute();
        fileSQL.closeReader();
    }

    /**
     * Test for the class dataSourceFactory
     */
    //Test l'acquisition de la source de donnée.
//	@Test
    /*public void getDataSource() throws DAOException {
        org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
        ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
        ds.setUser("username");
        ds.setPassword("password");
        return ds;
    }

    /**
     * Test for the class DAO
     */
    /*@Test
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
    public void deleteOrder() throws DAOException {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Test for the class CustomerDAO
     */
    /*@Test
    // Test si le login fonctionne
    public void logIN() throws DAOException {
        int customerID = 1;
        String email = "test@example.com";
        assertEquals(id, myDAO.identification(email));
    }

    /**
     * Test for the class ???
     */
    /*@Test
    //Test le calcule du prix du produit.
    //"Méthode à implémenter"
    public void finalPrice() {
        float price = 10;
        int quantity = 1;
        float discountRate = 0;
        float shippingcost = 10;
        float markup = 0;
        assertEquals(price * quantity * 0.01 * (1 - discountRate) + shippingcost, "Méthode qui calcule le prix final");
    }
}*/
    

