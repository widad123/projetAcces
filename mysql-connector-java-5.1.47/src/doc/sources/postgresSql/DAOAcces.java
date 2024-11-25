import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAcces {
    private String strClassName;
    private String dbName;
    private String dbUser;
    private String dbPassword;
    private String dbUrl;

    public static Connection getConnection(String strClassName, String dbName, String dbUser, String dbPassword, String dbUrl){
        Connection conn = null;
        try{
            strClassName = strClassName;
            dbName = dbName;
            dbUser = dbUser;
            dbPassword = dbPassword;
            dbUrl = dbUrl;

            Class.forName(strClassName);
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        }catch(ClassNotFoundException e){
            System.err.println("Driver not found: " + e.getMessage());
        }catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return conn;
    }
    
    public static void closeConnection(Connection conn) throws SQLException {
        if(conn != null){
            conn.close();
        }
    }

    public static void ajouterAcces(Connection conn, List<Acces> Acceses) throws SQLException {
        String sqlInsert = "INSERT INTO Acces (id, prenom, login, password, statut, age)" +
                " VALUES (?, ?, ?, ?, ?, ?)"+
                "ON CONFLICT (id) DO NOTHING";

        PreparedStatement prStmt = conn.prepareStatement(sqlInsert);

        for (Acces Acces : Acceses) {
            prStmt.setInt(1, Acces.id);
            prStmt.setString(2, Acces.prenom);
            prStmt.setString(3, Acces.login);
            prStmt.setString(4, Acces.password);
            prStmt.setString(5, Acces.statut);
            prStmt.setInt(6, Acces.age);
            prStmt.addBatch();
        }
        prStmt.executeBatch();
    }

    public static void ajouter(Connection conn, Acces Acces) throws SQLException {
        String sqlInsert = "INSERT INTO Acces (id, prenom, login, password, statut, age)" +
                " VALUES (?, ?, ?, ?, ?, ?)"+
                "ON CONFLICT (id) DO NOTHING";

        PreparedStatement prStmt = conn.prepareStatement(sqlInsert);

            prStmt.setInt(1, Acces.id);
            prStmt.setString(2, Acces.prenom);
            prStmt.setString(3, Acces.login);
            prStmt.setString(4, Acces.password);
            prStmt.setString(5, Acces.statut);
            prStmt.setInt(6, Acces.age);
            prStmt.addBatch();

        prStmt.executeBatch();
    }

    public static void delete(Connection conn, Integer id) throws SQLException {
        String sqlDelete = "DELETE FROM Acces WHERE id = ?";

        PreparedStatement prStmt = conn.prepareStatement(sqlDelete);

        prStmt.setInt(1, id);

        prStmt.executeUpdate();
    }

    public static void lister(Connection conn) throws SQLException {
        List<Acces> Acceses = new ArrayList<>();
        String sqlSelect = "SELECT prenom, login, statut, age FROM Acces ORDER BY prenom";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);

        while (rs.next()) {
            Acces Acces = new Acces(
                    rs.getString("prenom"),
                    rs.getString("login"),
                    rs.getString("statut"),
                    rs.getInt("age")
            );
            Acceses.add(Acces);
        }

        for (Acces Acces : Acceses) {
            System.out.println(Acces.toString());
        }
    }

    public static void modifier(Connection conn, Integer id, String statut) throws SQLException {
        String sqlDelete = "UPDATE Acces SET statut = ? WHERE id = ?";
        PreparedStatement prStmt = conn.prepareStatement(sqlDelete);

        prStmt.setString(1, statut);
        prStmt.setInt(2, id);

        prStmt.executeUpdate();
    }

}
