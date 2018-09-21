package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.auth.Public;
import br.edu.utfpr.md.webapp.dao.UsuarioDAO;
import br.edu.utfpr.md.webapp.model.Usuario;
import javax.inject.Inject;

@Controller
@Path("/auth")
public class AuthController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private LoggedUser loggedUser;
    @Inject
    private UsuarioDAO usuarioDAO;

    @Get(value = {"", "/"})
    public void login() { // CARREGA PAGINA DE LOGIN
    }

    @Post
    @Public
    public void autenticar(Usuario usuario) { // EFETUA LOGIN DO USUARIO
        try {
            // VERIFICA SE USUARIO EXISTE NO BANCO DE DADOS;
            Usuario dbUser = this.usuarioDAO.getByUsername(usuario.getUsuario(), usuario.getSenha());
            if (usuario.getUsuario().equals(dbUser.getUsuario()) && usuario.getSenha().equals(dbUser.getSenha())) {
                usuario.setNome(dbUser.getNome());
                usuario.setAdministrator(dbUser.isAdministrator());
                this.loggedUser.login(usuario);
                this.result.redirectTo("/document");
            } else {
                validator.add(new SimpleMessage("invalid", "Login e/ou Senha Invalidos!"));
            }
        } catch (NullPointerException e) {
            validator.add(new SimpleMessage("invalid", "Login e/ou Senha Invalidos!"));
        }
        validator.onErrorForwardTo(this).login();
    }

    @Post
    @Public
    public void registrar(Usuario usuario) { //EFETUA CADASTRO DO USUARIO
        validator.onErrorForwardTo(this).login();
        try {
            this.usuarioDAO.save(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Usuario!"));
        }
        result.redirectTo("/document");
    }

}
