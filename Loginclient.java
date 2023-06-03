package ServerConnections;

import MYSQLCONNECTIVITY.connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Loginclient {
    String username;
    String password;
    ResultSet rs;
   public Loginclient(String username, String password){
       this.username=username;
       this.password=password;
   }
   public String get_result() throws SQLException {
       Connection c= connector.create_connection();
       Statement smt=c.createStatement();
       String query="SELECT * FROM Users where username='"+username +"'";
       rs=smt.executeQuery(query);
       String actual = null;
       while(rs.next()){
           actual=rs.getString("access_key");
       }
       if(actual!=null && actual.equals(password)){
           c.close();
           return "1";
       }
       else{
           c.close();
           return "0";
       }


   }


}
