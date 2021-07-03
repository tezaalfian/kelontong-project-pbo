package app;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMysql {
    private Connection connect; 
    private String driverName = "com.mysql.jdbc.Driver";  
    private String jdbc = "jdbc:mysql://"; 
    private String host = "localhost:"; 
    private String port = "3306"; 
    private String database = "/db_kelontong"; 
    private String url = jdbc + host + port + database; 
    private String username = "root"; 
    private String password = ""; 
    public Connection getKoneksi() throws SQLException{ 
        if(connect == null){ 
            try{ 
                Class.forName(driverName); 
                System.out.println("Class Driver Ditemukan"); 
                try { 
                 connect = (Connection) DriverManager.getConnection(url, username, password);
                 System.out.println("Koneksi Database Sukses"); 
                }catch(SQLException se){ 
                    System.out.println("Koneksi Database Gagal : "+se); 
                    System.exit(0); 
                } 
            }catch (ClassNotFoundException cnfe){ 
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada :"+cnfe); 
                System.exit(0); 
            } 
        } 
        return connect; 
    }
}
