package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection(Connection connection) {
        SingletonConnection.connection = connection;
    }

    public static Connection getInstance(){
        if(connection == null){
            try{
                connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/java22",
                        "root", "java");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}
