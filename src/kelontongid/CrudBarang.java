/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelontongid;

import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class CrudBarang extends app.CRUD {
    public CrudBarang(){
        this.table = "barang";
        this.field.add("nama_barang");
        this.field.add("id");
    }
    public ResultSet stokAda() {
        CRUDquery = "select * from "+table+" WHERE stok > 0";
        try {
            CRUDstat = CRUDkoneksi.createStatement(); 
            CRUDhasil = CRUDstat.executeQuery(CRUDquery); 
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
        return CRUDhasil;
    }
    public void editStok(String opt,String id,String val){
        CRUDquery = "UPDATE barang SET stok = stok" + opt + val + " WHERE id=?";
        try{ 
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery); 
            CRUDpsmt.setString(1,id);
            CRUDpsmt.executeUpdate(); 
            CRUDpsmt.close();
        } catch(Exception e){ 
            System.out.println(e.getMessage());
        } 
    }
}
