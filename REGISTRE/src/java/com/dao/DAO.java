package com.dao;

import java.sql.Connection;
import com.connection.Maconnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class DAO<T> {
    protected Connection connect = null ;
    
    /**
     *
     * @param conn
     */
    public DAO(Connection conn){
        this.connect = conn;
    }
    public abstract boolean create(T obj);
    
    public abstract boolean delete(T obj);
    
    public abstract boolean update(T obj);
    
    public abstract T find(int IDP);

    public abstract Set<T> findAll();
}

