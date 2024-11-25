import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        try{
            String strClassName = "org.postgresql.Driver";
            String dbName = "Acces";
            String dbUser = "postgres";
            String dbPassword = "widad";
            String dbUrl = "jdbc:postgresql://localhost:5432/Acces";

            String sqlDelete = "UPDATE Acces SET statut = ? WHERE id = ?";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

            PreparedStatement prStmt = conn.prepareStatement(sqlDelete);

            prStmt.setString(1, "prof");
            prStmt.setInt(2, 3);

            prStmt.executeUpdate();

            conn.close();

        }catch(ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }
}
