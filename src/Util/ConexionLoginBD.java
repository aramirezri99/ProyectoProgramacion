package Util;
import java.sql.*;
public class ConexionLoginBD {
    public Connection getConexionLoginBD(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/usuariobd","root","");
            System.out.println("Se conectó a la base de datos Login");
        } catch (Exception e) {
            System.out.println("No se conectó a la base de datos Login");
        }
        return cn;
    }
    public static void main(String[] args) {
        ConexionLoginBD objConexionLoginBD=new ConexionLoginBD();
                        objConexionLoginBD.getConexionLoginBD();
    }
    
}
