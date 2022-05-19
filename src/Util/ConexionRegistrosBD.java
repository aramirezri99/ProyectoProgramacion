package Util;
import java.sql.*;
public class ConexionRegistrosBD {
    public static Connection getConexionBD(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/registrobd","root","");
            System.out.println("Se ha conectado satisfactoriamente a la Base de Datos de los registros :v");
        } catch (Exception e) {
            System.out.println("Error en la conexión :'v");
        }
        return cn;
    }
    public static void main(String[] args){
        getConexionBD();
    }
}