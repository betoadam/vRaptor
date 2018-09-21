package br.edu.utfpr.md.webapp.dao;
import br.edu.utfpr.md.webapp.model.Usuario;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class UsuarioDAO extends BasicDAO<Usuario, ObjectId>{
    @Inject
    public UsuarioDAO(MongoClient mongoClient) {
        super(Usuario.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Usuario getByUsername(String user, String pass) {
        return this.getDatastore().find(Usuario.class).field("usuario").equal(user).field("senha").equal(pass).get();
    }
}
