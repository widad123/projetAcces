import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        List<Acces> access = new ArrayList<>();
        try{
            String strClassName = "org.postgresql.Driver";
            String dbName = "Acces";
            String dbUser = "postgres";
            String dbPassword = "widad";
            String dbUrl = "jdbc:postgresql://localhost:5432/Acces";

            String sqlSelect = "SELECT prenom, login, statut, age FROM Access ORDER BY prenom";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSelect);

            while (rs.next()) {
                Acces acces = new Acces(
                rs.getString("prenom"),
                rs.getString("login"),
                rs.getString("statut"),
                rs.getInt("age")
                );
                access.add(acces);
            }

            for (Acces acces : access) {
                System.out.println(acces.toString());
            }

            conn.close();

        }catch(ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }
}
