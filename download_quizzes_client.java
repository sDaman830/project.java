package ServerConnections;
import MYSQLCONNECTIVITY.connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class download_quizzes_client {
    String username;
    String topic;
    ResultSet rs;
    public download_quizzes_client(String username, String topic)  {
        this.username=username;
        this.topic=topic;
    }
    public String get_result() throws SQLException {
        Connection c= connector.create_connection();
        Statement smt=c.createStatement();
        String query = "SELECT * FROM quiz_loc where topic='"+ topic +"'";
        rs=smt.executeQuery(query);
        String ans="";
        while(rs.next()){
            ans=rs.getString("location");
        }
        return ans;
    }
}
