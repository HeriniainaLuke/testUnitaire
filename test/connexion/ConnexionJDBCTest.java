/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author itu
 */
public class ConnexionJDBCTest {
    
    public ConnexionJDBCTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnPostgre method, of class ConnexionJDBC.
     */
    @Test
    public void testGetConnPostgre() throws Exception {
        System.out.println("getConnPostgre");
        ConnexionJDBC instance = new ConnexionJDBC();
        Connection expResult = null;
        Connection result = instance.getConnPostgre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
