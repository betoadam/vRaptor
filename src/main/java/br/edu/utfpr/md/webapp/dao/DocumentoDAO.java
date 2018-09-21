/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.webapp.model.Documento;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public class DocumentoDAO extends BasicDAO<Documento, ObjectId>{
    @Inject
    public DocumentoDAO(MongoClient mongoClient) {
        super(Documento.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
}
