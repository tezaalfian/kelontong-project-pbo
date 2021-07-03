/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelontongid;

/**
 *
 * @author user
 */
public class CrudUsers extends app.CRUD{
    public CrudUsers(){
        this.table = "users";
        this.field.add("username");
        this.field.add("nama");
        this.field.add("role");
    }
}
