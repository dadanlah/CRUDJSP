/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fonction.implement;

import com.dao.DAO;
import com.bean.personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JORD DJR
 */
public class PersonneDAO extends DAO<personne>{
    public PersonneDAO(Connection conn){
     super(conn);
    }
    @Override
    public boolean create(personne obj) {
        
        
        try{
            PreparedStatement states = this.connect.prepareStatement("ISERT into personne values (?,?)");
            states.setInt(1, personne.getIDPersonne());
            states.setString(2 ,personne.getNOMPersonne());
            states.executeQuery();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }

    @Override
    public boolean delete(personne obj) {
        
         String uquery = "Delete from personne where IDP=? AND NOMF=? ";
           PreparedStatement states;
        try {
            states = this.connect.prepareStatement(uquery);
            states.setInt(1, personne.getIDPersonne());
            states.setString(2, personne.getNOMPersonne());
            states.executeQuery();
             uquery = "Delete from fonction where IDP=? ";
           states = this.connect.prepareStatement(uquery);
           states.setInt(1, personne.getIDPersonne());
           states.executeQuery();
           this.connect.close();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }
           
    }

    @Override
    public boolean update(personne obj) {
        try {
            String uquery = "UPDATE fonction set NOMF=?"+" where IDP=? ";
            PreparedStatement states = this.connect.prepareStatement(uquery);
            states.setString(1, personne.getNOMFonction());
            states.setInt(2, personne.getIDPersonne());
            states.executeQuery();
            uquery = "UPDATE personne set NOMP=?"+" where IDP=? ";
            states = this.connect.prepareStatement(uquery);
            states.setString(1, personne.getNOMPersonne());
            states.setInt(2, personne.getIDPersonne());
            states.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public personne find(int IDP) {
        
        try{
        String query = "select personne.NOMP as NOM , personne.IDP as ID, fonction.NomF as FONCTION from personne inner join fonction on personne.IDP = fonction.IDP where personne.IDP=?";
           PreparedStatement state = this.connect.prepareStatement(query);   
           state.setInt(1, IDP);
           ResultSet result = state.executeQuery();
        if(result.next()){
        personne personne0 = new personne(
                IDP,
                result.getString("NOM"),
                result.getString("FONCTION")
        );
         return personne0;   
        }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public Set<personne> findAll() {
        Set<personne> list = new HashSet<personne>();
        try{
        ResultSet result = this.connect.createStatement().executeQuery("SELECR * FROM personne ");
        if(result.next()){
            list.add(find(result.getInt("IDP")));
        }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


    
}
