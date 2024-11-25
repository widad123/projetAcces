import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Delete {
    public static void main(String[] args) {
        try{
            String strClassName = "org.postgresql.Driver";
            String dbName = "Acces";
            String dbUser = "postgres";
            String dbPassword = "widad";
            String dbUrl = "jdbc:postgresql://localhost:5432/Acces";

            String sqlDelete = "DELETE FROM Access WHERE id = ?";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

            PreparedStatement prStmt = conn.prepareStatement(sqlDelete);

            prStmt.setInt(1, 1);

            prStmt.executeUpdate();

            conn.close();

        }catch(ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }
}
