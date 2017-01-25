/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.*;
import java.lang.reflect.Method;
// import maping.MapingArbre;

public class ConnexionJDBC{
        public ConnexionJDBC(){}
	public Connection getConnPostgre() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/Vente","postgres", "itu");
		return conn;
	}
}