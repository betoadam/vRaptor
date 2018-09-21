package br.edu.utfpr.md.webapp.auth;

import br.edu.utfpr.md.webapp.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class LoggedUser implements Serializable {

    private Usuario usuario;

    public void login(Usuario usuario) {
        this.usuario = usuario;
    }

    public void logout() {
        this.usuario = null;
    }

    public boolean isLogged() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
