/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelontongid;

import java.sql.ResultSet;
import app.Session;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class CrudTransaksi extends app.CRUD{
    public CrudTransaksi(){
        this.table = "transaksi";
//        this.field.add("jenis");
        this.field.add("barang.nama_barang");
        this.field.add("users.nama");
    }
    public ResultSet tampilData(String jenis) {
        CRUDquery = "SELECT transaksi.*,barang.nama_barang,users.nama from transaksi JOIN barang ON barang.id = transaksi.barang_id JOIN users ON users.id = transaksi.created_by WHERE transaksi.jenis='"+jenis+"'";
        try {   
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }
    public ResultSet cariData(String str, String jenis) {
        CRUDquery = "SELECT transaksi.*,barang.nama_barang,users.nama from transaksi JOIN barang ON barang.id = transaksi.barang_id JOIN users ON users.id = transaksi.created_by WHERE jenis in('"+jenis+"') AND {where}";
        String strVal = "";
        for(int i=0; i<field.size(); i++){
            strVal += field.get(i) + " LIKE '%" + str + "%'";
            if(i+1 < field.size()){
                strVal += " OR ";
            }
        }
        CRUDquery = CRUDquery.replace("{where}", strVal);
        System.out.println(CRUDquery);
        try {
            CRUDstat = CRUDkoneksi.createStatement(); 
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil; 
    }
    
    public String simpanData(String[] key, ArrayList<String> value) {
        CRUDquery = "insert into "+table+"({key}) values({val})";
        String strKey = "";
        String strVal = "";
        for(int i=0; i<key.length; i++){
            strKey += key[i];
            strVal += "'" + value.get(i) + "'";
            if(i+1 < key.length){
                strKey += ",";
                strVal += ",";
            }
        }
        strKey += ", created_at, created_by";
        strVal += ", current_timestamp(), " + Session.getUserId();
        CRUDquery = CRUDquery.replace("{key}", strKey);
        CRUDquery = CRUDquery.replace("{val}", strVal);
        try{ 
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery); 
            CRUDpsmt.executeUpdate(); 
            CRUDpsmt.close(); 
            return "Data berhasil disimpan!";
        } catch(Exception e){ 
            return e.getMessage();
        } 
    }
    
//    public ResultSet getById(String id) {
//        CRUDquery = "SELECT transaksi.*,barang.nama_barang from transaksi JOIN barang ON barang.id = transaksi.barang_id  WHERE id = '"+id+"'";
//        try {
//            CRUDstat = CRUDkoneksi.createStatement(); 
//            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        } 
//        return CRUDhasil;
//    }
}
