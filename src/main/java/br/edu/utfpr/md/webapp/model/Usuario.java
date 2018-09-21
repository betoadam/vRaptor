package br.edu.utfpr.md.webapp.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Usuario {

    @Id
    private int id;
    private String nome;
    @NotNull
    private String usuario;
    @NotNull
    @Size(min = 6)
    private String senha;
    private boolean Administrator;

    public Usuario() {
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean isAdministrator() {
        return Administrator;
    }

    public void setAdministrator(boolean Administrator) {
        this.Administrator = Administrator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
