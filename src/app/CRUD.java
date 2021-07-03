package app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUD implements CrudInterface{
    protected Connection CRUDkoneksi; 
    protected PreparedStatement CRUDpsmt; 
    protected Statement CRUDstat; 
    protected ResultSet CRUDhasil; 
    protected String CRUDquery;
    protected String table;
    protected ArrayList<String> field = new ArrayList<String>();
    public CRUD(){
        try{ 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDkoneksi = connection.getKoneksi(); 
        } catch(SQLException ex){ 
            System.out.println(ex); 
        }
    } 
    @Override
    public ResultSet cariData(String str) {
//        SELECT * FROM siswa WHERE id LIKE '%"+str+"%' OR nama LIKE '%"+str+"%'
        CRUDquery = "SELECT * FROM "+table+" WHERE {where}";
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

    @Override
    public ResultSet tampilData() {
        CRUDquery = "select * from "+table;
        try {   CRUDstat = CRUDkoneksi.createStatement(); 
                CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }

    @Override
    public String simpanData(String[] key, String[] value) {
        CRUDquery = "insert into "+table+"({key}) values({val})";
        String strKey = "";
        String strVal = "";
        for(int i=0; i<key.length; i++){
            strKey += key[i];
            if(value[i].contains("md5")){
                strVal += value[i];
            }else{
                strVal += "'" + value[i] + "'";
            }
            if(i+1 < key.length){
                strKey += ",";
                strVal += ",";
            }
        }
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

    @Override
    public String ubahData(String[] key, String[] value, String id) {
        CRUDquery = "update "+table+" set {data} where id=?";
        String strVal = "";
        for(int i=0; i<key.length; i++){
            if(value[i].contains("md5")){
                strVal += key[i] + "=" + value[i];
            }else{
                strVal += key[i] + "='" + value[i] + "'";
            }
            if(i+1 < key.length){
                strVal += ",";
            }
        }
        CRUDquery = CRUDquery.replace("{data}", strVal);
        try{ 
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery); 
            CRUDpsmt.setString(1,id); 
//            System.out.println(CRUDpsmt);
            CRUDpsmt.executeUpdate(); 
            CRUDpsmt.close();
            return "Data berhasil diubah!";
        } catch(Exception e){ 
            return e.getMessage();
        } 
    }

    @Override
    public String hapusData(String id) {
        CRUDquery = "delete from "+table+" where id=?"; 
        try{ 
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery); 
            CRUDpsmt.setString(1,id); 
            CRUDpsmt.executeUpdate(); 
            CRUDpsmt.close(); 
            return "Data berhasil dihapus!";
        } catch(Exception e){ 
            return e.getMessage();
        } 
    }
    
    public String hapusData(String id, String field) {
        CRUDquery = "delete from "+table+" where "+field+"=?"; 
        try{ 
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery); 
            CRUDpsmt.setString(1,id); 
            CRUDpsmt.executeUpdate(); 
            CRUDpsmt.close(); 
            return "Data berhasil dihapus!";
        } catch(Exception e){ 
            return e.getMessage();
        } 
    }

    @Override
    public ResultSet getById(String id) {
        CRUDquery = "select * from "+table+" WHERE id = '"+id+"'";
        try {
            CRUDstat = CRUDkoneksi.createStatement(); 
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }
    
    public ResultSet getById(String id,String key) {
        CRUDquery = "select * from "+table+" WHERE "+key+" = '"+id+"'";
        try {
            CRUDstat = CRUDkoneksi.createStatement(); 
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }
    
    public ResultSet getWhere(String where) {
        CRUDquery = "select * from "+table+" WHERE "+ where;
        try {
            CRUDstat = CRUDkoneksi.createStatement(); 
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }
}
