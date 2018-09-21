/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.md.webapp.dao;

import java.util.List;

/**
 *
 * @author utfpr
 */
public abstract class GenericDAO<T, PK> {
    public abstract void insert(T obj);
    public abstract void update(T obj);
    public abstract void delete(T obj);
    public abstract List<T> getAll();
    public abstract T getById(PK id);
}
