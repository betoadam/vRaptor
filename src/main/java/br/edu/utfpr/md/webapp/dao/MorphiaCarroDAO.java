/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.webapp.model.Carro;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public class MorphiaCarroDAO extends BasicDAO<Carro, ObjectId>{
    
    @Inject
    public MorphiaCarroDAO(MongoClient mongoClient) {
        super(Carro.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
}
