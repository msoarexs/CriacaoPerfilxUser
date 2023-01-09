import java.io.Serializable;

//User x Perfil

public class UserxPerfil extends Throwable implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;
    private String role;
    private String uid;
    private String nome_ges;
    private String matricula;
    private String neg;


    public UserxPerfil(String login, String role) {
        this.login = login;
        this.role = role;

    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String nome) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserxPerfil{" +
                "login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
