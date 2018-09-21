package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.webapp.auth.LoggedUser;
import br.edu.utfpr.md.webapp.dao.CategoriaDAO;
import br.edu.utfpr.md.webapp.dao.DocumentoDAO;
import br.edu.utfpr.md.webapp.dao.TagDAO;
import br.edu.utfpr.md.webapp.model.Categoria;
import br.edu.utfpr.md.webapp.model.Documento;
import br.edu.utfpr.md.webapp.model.Tag;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;


@Controller
@Path("/documento")
public class DocumentoController {

    @Inject
    private Result result;
    @Inject
    private Validator validator;
    @Inject
    private DocumentoDAO documentoDAO;
    @Inject
    private TagDAO tagDAO;
    @Inject
    private CategoriaDAO categoriaDAO;
    @Inject
    private LoggedUser loggedUser;

    @Path("/new")
    @Get
    public void form() {
        result.include("categorias", categoriaDAO.find().asList());
        result.include("tags", tagDAO.find().asList());
    }

    @Path(value = {"", "/"})
    @Get
    public List<Documento> list() {
        result.include("mensagem", "esta é uma mensagem");
        result.include("data", new Date());
        return documentoDAO.find().asList();
    }

    @Post
    public void save(String description, String fileName, String date, String lastUpdate, String selectedCategoriaName, String[] tags) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Tag> TagList = new ArrayList<>();
        Categoria categoriaSelecionada = this.categoriaDAO.getByName(selectedCategoriaName);
        
        for (String keyword : tags) {
            Tag key = this.tagDAO.getByName(keyword);
            if (key != null) {
                TagList.add(key);
            }
        }
        Documento documento = new Documento(date, description, sdf.parse(date), sdf.parse(lastUpdate), categoriaSelecionada, TagList, loggedUser.getUsuario());
        validator.onErrorForwardTo(this).form();
        try {
            this.documentoDAO.save(documento);
        } catch (Exception e) {
            validator.add(new SimpleMessage("dao", "Falha ao Inserir Documento!"));
        }
        result.redirectTo(this).list();
    }
    // ADICIONAR PATH /UPDATE/ ID
    public void update(String id){
        System.out.println("btn editar clicado " + id);
        // ENVIAR OBJETO COM O ID ENVIADO PARA A PAGINA DE UPDATE
        // result.include("objeto", OBJ);
    }
    // ADICIONAR PATH /DELETE/ ID
    public void delete(String id){
        // DELETAR O OBJETO COM ID ENVIADO
        // REDIRECIONAR PARA PAGINA DE LISTAGEM 
    }
}
