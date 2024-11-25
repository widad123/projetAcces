import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {

        try{
            String strClassName = "org.postgresql.Driver";
            String dbName = "Acces";
            String dbUser = "postgres";
            String dbPassword = "widad";
            String dbUrl = "jdbc:postgresql://localhost:5432/Acces";

            String sqlInsert = "INSERT INTO Access (id, prenom, login, password, statut, age)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

            PreparedStatement prStmt = conn.prepareStatement(sqlInsert);

            List<Acces> access = new ArrayList<>();
            access = List.of(
                    new Acces(1, "Tom", "tomahawk", "indien", "Etudiant", 22),
                    new Acces(2, "Pierre", "Pierrot", "delalune", "Prof", 44),
                    new Acces(3, "Michel", "lamere", "sonchat", "Admin", 69),
                    new Acces(4, "Robin", "Locksley", "desbois", "Etudiant", 23));

            for (Acces acces : access) {
                prStmt.setInt(1, acces.id);
                prStmt.setString(2, acces.prenom);
                prStmt.setString(3, acces.login);
                prStmt.setString(4, acces.password);
                prStmt.setString(5, acces.statut);
                prStmt.setInt(6, acces.age);
                prStmt.addBatch();
            }
            prStmt.executeBatch();

            conn.close();

        }catch(ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
