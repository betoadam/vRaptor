/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.md.webapp.dao.CarroDAO;
import br.edu.utfpr.md.webapp.dao.MorphiaCarroDAO;
import br.edu.utfpr.md.webapp.model.Carro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@Path("/car")
public class CarroController {
    
    @Inject
    private Result result;
    
    @Inject
    private CarroDAO carDAO;
    
    @Inject Validator validator;
    
    @Inject MorphiaCarroDAO mCarroDAO;
   
    public void teste(){
        System.out.println("Oi cara!!!");
    }
    
    @Path("/new")
    @Get
    public void form(){
        
    }
    
    @Path(value = {"", "/"})
    @Get
    public List<Carro> list(){
        result.include("mensagem", "Uma mensagem qualquer");
        result.include("data", new Date());
        
        //Buscando os carros do banco de dados
        
        //return carDAO.getAll();   
        return mCarroDAO.find().asList();
    }
    
    @Post()
    public void save(@Valid @NotNull Carro carro){
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("Modelo: " + carro.getModelo());
        
        /*if(carro.getMarca() == null || carro.getMarca().isEmpty()){
            validator.add(new SimpleMessage("carro.Marca", "Marca está vazia!"));
        }
        
        if(carro.getModelo() == null || carro.getModelo().isEmpty()){
            validator.add(new SimpleMessage("carro.Modelo", "Marca está vazia!"));
        }*/
        
        validator.onErrorForwardTo(this).form();
        
        try{
            //this.carDAO.insert(carro);
            this.mCarroDAO.save(carro);
        }catch(Exception ex){
            ex.printStackTrace();
            validator.add(new SimpleMessage("dao", "Erro ao gravar carro"));
            validator.onErrorForwardTo(this).form();
        }
        
        //Cadastro no Banco de Dados
        
        // redirecionamento
        result.redirectTo(this).list();
    }
    
}
