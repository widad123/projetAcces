public class Acces {

    Integer id;
    String prenom;
    String login;
    String password;
    String statut;
    Integer age;

    public Acces(Integer id, String prenom, String login, String password, String statut, Integer age) {
        this.id = id;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.statut = statut;
        this.age = age;
    }

    public Acces(String prenom, String login, String statut, Integer age) {
        this.prenom = prenom;
        this.login = login;
        this.statut = statut;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Acces{" +
                "prenom='" + prenom + '\'' +
                ", login='" + login + '\'' +
                ", statut='" + statut + '\'' +
                ", age=" + age +
                '}';
    }

}
