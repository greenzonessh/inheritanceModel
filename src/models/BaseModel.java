/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;

/**
 *
 * @author ANGGAA
 */
public class BaseModel {
    
    private Koneksi kon;

    public BaseModel() throws SQLException {
        this.kon = new Koneksi("root", "", "dbmahasiswa");
    }
    
    public boolean save(String query) throws SQLException{
        try {
            kon.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(String query) throws SQLException{
        try {
            kon.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean delete(String query) throws SQLException{
        try {
            kon.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
