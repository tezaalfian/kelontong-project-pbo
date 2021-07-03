package app;


import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public interface CrudInterface {
    public ResultSet cariData(String str);
    
    public ResultSet tampilData();

    public String simpanData(String[] key, String[] value);
    
    public String ubahData(String[] key, String[] value, String id);

    public String hapusData(String id);
    
    public ResultSet getById(String str);
    
    public ResultSet getById(String id,String key);
}
