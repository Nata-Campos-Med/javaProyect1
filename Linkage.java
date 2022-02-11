//package model;
import java.sql.*;


public class Linkage {
    
    private static final String URL = "jdbc:sqlite:bd_estudiantes.db";
    private Connection connection;
    
    public Linkage(String createDB) {
    try {
        this.connection = DriverManager.getConnection(URL);
        PreparedStatement call = this.connection.prepareStatement(createDB);
        call.execute();
        this.connection.close();
    } catch (SQLException exception ) {
        System.err.println(exception);
    }
    }
    
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
    }
    
    public void disconnect() {
    try{
        this.connection.close();
    } catch (SQLException sqlException) {
        System.err.println(sqlException);
    }
    }
    
    public int executeSentencesSQL(String sentence) throws SQLException {
        PreparedStatement temp = this.connection.prepareStatement(sentence);
        return temp.executeUpdate();
    }
    
    public ResultSet checkRecords(String sentence) throws SQLException {
        PreparedStatement temp = this.connection.prepareStatement(sentence);
        ResultSet answer = temp.executeQuery();
        return answer;
    }
}
