package ServerConnections;

import MYSQLCONNECTIVITY.connector;
import ReturnTypes.recent_quizzes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class view_recent_quizzes_client {
    String username;
    ResultSet rs;

    public view_recent_quizzes_client(String username){
        this.username=username;
    }
    public recent_quizzes get_result() throws SQLException {
        Connection c= connector.create_connection();
        Statement smt=c.createStatement();
        String query="SELECT * FROM quiz_loc";
        rs=smt.executeQuery(query);
        ArrayList<String> now=new ArrayList<String>();
        while(rs.next()){
            String curr=rs.getString("topic");
            now.add(curr);

        }
        recent_quizzes r=new recent_quizzes(now);
        c.close();
        return r;

    }

}
