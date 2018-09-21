/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp.model;

import java.util.Date;
import java.util.List;
import javafx.scene.chart.PieChart.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author utfpr
 */
public class Documento {
    @Id
    private ObjectId id;
    private String nome;
    private String descricao;
    private Date dataEnvio;
    private Date dataModificacao;
    @Reference
    private Categoria categoria;
    @Reference
    private List<Tag> tag;
    @Reference
    private Usuario usuario;

    public Documento() {
    }

    public Documento(String nome, String descricao, Date dataEnvio, Date dataModificacao, Categoria categoria, List<Tag> tag, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEnvio = dataEnvio;
        this.dataModificacao = dataModificacao;
        this.categoria = categoria;
        this.tag = tag;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Tag> getKeywords() {
        return tag;
    }

    public void setKeywords(List<Tag> keywords) {
        this.tag = keywords;
    }
    
}
