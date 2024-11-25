import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String strClassName = "org.postgresql.Driver";
    static String dbName = "Acces";
    static String dbUser = "postgres";
    static String dbPassword = "widad";
    static String dbUrl = "jdbc:postgresql://localhost:5432/Acces";


    static List<Acces> access = List.of(
            new Acces(1, "Tom", "tomahawk", "indien", "Etudiant", 22),
                    new Acces(2, "Pierre", "Pierrot", "delalune", "Prof", 44),
                    new Acces(3, "Michel", "lamere", "sonchat", "Admin", 69),
                    new Acces(4, "Robin", "Locksley", "desbois", "Etudiant", 23));

    static Acces acces = new Acces(5, "Widad", "Wika", "toto", "Alternante", 35);

    public static void main(String[] args) throws SQLException {


        Connection conn = DAOAcces.getConnection(strClassName,dbName,dbUser,dbPassword,dbUrl);

        DAOAcces.ajouterAcces(conn, access);
        DAOAcces.ajouter(conn, acces);
        DAOAcces.delete(conn, 4);
        DAOAcces.lister(conn);
        System.out.print("Entrez l'identifiant de l'utilisateur à modifier : ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le nouveau statut : ");
        String statut = scanner.nextLine();
        DAOAcces.modifier(conn, id, statut);
        scanner.close();
        DAOAcces.lister(conn);
        DAOAcces.closeConnection(conn);
    }

}
