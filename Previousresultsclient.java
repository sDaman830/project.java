package ServerConnections;

import MYSQLCONNECTIVITY.connector;
import ReturnTypes.result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Previousresultsclient {
    String username;
    public Previousresultsclient(String username){
        this.username=username;
    }

    ResultSet rs;
    public result get_result() throws SQLException {
        Connection c = connector.create_connection();
        Statement smt = c.createStatement();
        String query = "SELECT * FROM Submissons where student_id='"+ username +"'";
        rs = smt.executeQuery(query);
        ArrayList<Integer> score = new ArrayList<Integer>();
        ArrayList<Integer> quiz_id=new ArrayList<Integer>();
        while (rs.next()) {
            int marks = rs.getInt("marks");
            int quizid=rs.getInt("quiz_id");
            score.add(marks);
            quiz_id.add(quizid);
        }
        result r=new result(score,quiz_id);
        c.close();
        return r;

    }

}
