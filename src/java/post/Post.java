package post;



import connexion.ConnexionJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Post {

            private int idPost;
            private String descriptionPost;
            private String url;
            private double prixPost;
            private String datePost;
            private String dateLimitePost;
            private String heureLimitePost;
            public Post(){}
            public Post(String descriptionPost,String url,double prixPost,String datePost,String dateLimitePost){
                    this.setDescriptionPost(descriptionPost);
                    this.setUrl(url);
                    this.setPrixPost(prixPost);
                    this.setDatePost(datePost);
                    this.setDateLimitePost(dateLimitePost);
            }
            public void setDescriptionPost(String descriptionPost){
                    this.descriptionPost = descriptionPost;
            }
            public void setUrl(String url){
                    this.url = url;
            }
            public void setPrixPost(double prixPost){
                    this.prixPost = prixPost;
            }
            public void setDatePost(String datePost){
                    this.datePost = datePost;
            }
            public void setDateLimitePost(String dateLimitePost){
                    this.dateLimitePost= dateLimitePost;
            }
            public String getDescriptionpost(){
                return this.descriptionPost;
            }
            public String getUrl(){
                return this.url;
            }
            public double getPrixPost(){
                return this.prixPost;
            }
            public String getDatePost(){
                return this.datePost;
            }
            public String getDateLimitePost(){
                return this.dateLimitePost;
            }
            public Post getPost(int idPost)throws Exception{ 
                        Post p = new Post();
                        ConnexionJDBC conn  = new ConnexionJDBC();
                        Connection c = conn.getConnPostgre();
                        String req = "select * from post where  idpost ='"+idPost+"'";
                        Statement stmt1 = c.createStatement();
                        ResultSet res = stmt1.executeQuery(req);
                        while(res.next()){
                                    p.idPost = res.getInt("idpost");                                 
                                    p.descriptionPost = res.getString("descriptionpost");
                                    p.prixPost = res.getDouble("prixpost");
                                    p.datePost = res.getString("datepost");
                                    p.dateLimitePost = res.getString("datelimitepost");
                                    p.heureLimitePost = res.getString("heurelimitepost");
                        }
                        c.close();
                        return p;
            }
            public void setPost(Post p)throws Exception{
                     ConnexionJDBC conn = new ConnexionJDBC();
                     Connection con = conn.getConnPostgre();
                     String req = "insert into demandeconge (idemploye,datedemande,datedebut,heuredebut,";
                     Statement stmt = con.createStatement();
                     stmt.executeUpdate(req);
                     con.close();
                
            } 
            public int getIdUtilisateur(int idPost)throws Exception{
                        int id = 0;
                        ConnexionJDBC conn  = new ConnexionJDBC();
                        Connection c = conn.getConnPostgre();
                        String req = "select idutilisateur from post where  idpost ='"+idPost+"'";
                        Statement stmt1 = c.createStatement();
                        ResultSet res = stmt1.executeQuery(req); 
                        while(res.next()){
                            id = res.getInt(1);
                        }
                        return id;
            }
            public static void main(String[] arg){
                        Post p = new Post();
                        try{
                            p = p.getPost(1);
                            System.out.println(p.idPost);
                            System.out.println(p.descriptionPost);
                            System.out.println(p.prixPost);
                            System.out.println(p.datePost);
                            System.out.println(p.dateLimitePost);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
            }
}