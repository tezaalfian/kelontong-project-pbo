package app;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private Connection koneksi; 
    private PreparedStatement psmt; 
    private ResultSet dataUser;
    private String query,username,password,pesan;
    public Login(){
        KoneksiMysql connection = new KoneksiMysql(); 
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    public String cekLogin(String userID, String password)
    { 
        query = "SELECT nama,id,role FROM users WHERE username=? AND password=md5(?)"; 
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID); 
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            if (dataUser.next()){ 
                Session.setUserId(dataUser.getString("id"));
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF");
                Session.setRole(dataUser.getString("role").trim());
//                Session.setRole("ADMIN");
                query = "INSERT INTO log_login (user_id) VALUES (?)"; 
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, dataUser.getString("id"));
                    psmt.executeUpdate(); 
                    psmt.close();
                } catch (Exception e) {
                    pesan = "Gagal Simpan Log Login";
                }
            } else {
                pesan = "Gagal Login";
            }
        } catch (Exception e) {
            pesan = "Gagal Login, Query Error";
        }
        return pesan;
    }
    public void Logout(String userID)
    {
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE user_id=? ORDER BY id DESC LIMIT 1";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.setString(1, userID);
            psmt.executeUpdate();
            psmt.close();
            // memutus koneksi database 
            koneksi.close();
            // hapus Session 
            Session.setUserId(null);
            Session.setNama(null); 
            Session.setStatusLogin(null);
        } catch (Exception e) { }
    }
}