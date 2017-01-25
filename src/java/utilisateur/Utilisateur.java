
package utilisateur;
import connexion.ConnexionJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class Utilisateur {

		   private int idUtilisateur;
		   private String nomUtilisateur;
		   private String prenomUtilisateur;
		   private String emailUtilisateur;
		   private String contactUtilisateur;
		   private String passwordUtilisateur;
		   public Utilisateur(){}
		   public Utilisateur(String nomUtilisateur,String prenomUtilisateur,String emailUtilisateur,String contactUtilisateur,String passwordUtilisateur){
				this.setNomUtilisateur(nomUtilisateur);
                                this.setPrenomUtilisateur(prenomUtilisateur);
                                this.setEmailUtilisateur(emailUtilisateur);
                                this.setContactUtilisateur(contactUtilisateur);
                                this.setPasswordUtilisateur(passwordUtilisateur);
		   }
		   public void setNomUtilisateur(String nomUtilisateur){
                           this.nomUtilisateur = nomUtilisateur;
                   }
                   public void setPrenomUtilisateur(String prenomUtilisateur){
                           this.prenomUtilisateur = prenomUtilisateur;
                   }
                   public void setEmailUtilisateur(String emailUtilisateur){
                           this.emailUtilisateur = emailUtilisateur;
                   }
                   public void setContactUtilisateur(String contactUtilisateur){
                           this.contactUtilisateur = contactUtilisateur;
                   }
                   public void setPasswordUtilisateur(String passwordUtilisateur){
                           this.passwordUtilisateur = passwordUtilisateur;
                   }
                   public String getnomUtilisateur(){
                           return this.nomUtilisateur;
                   }
                   public String getprenomUtilisateur(){
                           return this.prenomUtilisateur;
                   }
                   public String getemailUtilisateur(){
                           return this.emailUtilisateur;
                   }
                   public String getcontactUtilisateur(){
                           return this.contactUtilisateur;
                   }
                   public String getPasswordUtilisateur(){
                           return this.passwordUtilisateur;
                   }
                   public Utilisateur getUtilisateur(int idUtilisateur)throws Exception{
                            Utilisateur u = new Utilisateur();
                            ConnexionJDBC conn = new ConnexionJDBC();
                            Connection con = conn.getConnPostgre(); 
                            String req = "select * from utilisateur where idutilisateur ="+idUtilisateur+""; 
                            Statement stmt = con.createStatement();
                            stmt.executeQuery(req);
                            ResultSet res = stmt.executeQuery(req);
                            while(res.next()){
                                    u.nomUtilisateur = res.getString("nomUtilisateur");
                                    u.prenomUtilisateur = res.getString("prenomUtilisateur");
                                    u.emailUtilisateur = res.getString("emailUtilisateur");
                                    u.contactUtilisateur = res.getString("contactUtilisateur");
                                    u.passwordUtilisateur = res.getString("passwordUtilisateur");
                            }
                          return u;
                   }
}
