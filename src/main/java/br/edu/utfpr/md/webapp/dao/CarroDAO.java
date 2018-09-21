/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.webapp.model.Carro;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author utfpr
 */
public class CarroDAO extends GenericDAO<Carro, ObjectId>{
    
    @Inject
    private MongoDatabase db;
    
    private MongoCollection carCollection;
    
    @PostConstruct
    public void init(){
        this.carCollection = db.getCollection("Carro");
    }

    @Override
    public void insert(Carro obj) {
        Document car = new Document()
                .append("marca", obj.getMarca())
                .append("modelo", obj.getModelo());
        carCollection.insertOne(car);
    }

    @Override
    public void update(Carro obj) {
        
    } 

    @Override
    public void delete(Carro obj) {

    }

    @Override
    public List<Carro> getAll() {
        List<Carro> ls = new ArrayList<Carro>();
        MongoCursor cursor = carCollection.find().iterator();
        while(cursor.hasNext()){
            Document doc = (Document) cursor.next();
            Carro car = new Carro(doc.getString("marca"), doc.getString("modelo"));
            car.setId(doc.getObjectId("_id"));
            ls.add(car);
        }
        
        return ls;
    }

    @Override
    public Carro getById(ObjectId id) {
        return null;
    }
    
}
