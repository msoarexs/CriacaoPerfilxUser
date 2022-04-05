

import java.io.Serializable;

public class UserxPerfil extends Throwable implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String role;

    public UserxPerfil(){

    }

    public UserxPerfil(String nome, String role) {
        this.nome = nome;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  nome;
    }
}
