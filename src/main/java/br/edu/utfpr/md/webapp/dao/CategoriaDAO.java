package br.edu.utfpr.md.webapp.dao;
import br.edu.utfpr.md.webapp.model.Categoria;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class CategoriaDAO extends BasicDAO<Categoria, ObjectId>{
    @Inject
    public CategoriaDAO(MongoClient mongoClient) {
        super(Categoria.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Categoria getByName(String name) {
        return this.getDatastore().find(Categoria.class).field("name").equal(name).get();
    }
}
