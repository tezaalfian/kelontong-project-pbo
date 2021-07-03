/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author user
 */
public class Session {
    private static String userId,nama,statusLogin,role;
    public static void setUserId(String userId){
        Session.userId = userId;
    }
    public static String getUserId(){
        return userId;
    }
    public static void setNama(String nama){
        Session.nama = nama;
    }
    public static String getNama(){
        return nama;
    }
    public static void setStatusLogin(String statusLogin){
        Session.statusLogin = statusLogin;
    }
    public static String getStatusLogin(){
        return statusLogin;
    }
    public static void setRole(String role){
        Session.role = role;
    }
    public static String getRole(){
        return role;
    }
}
