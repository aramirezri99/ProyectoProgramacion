package Modelo;
import Util.*;
import Modelo.*;
import java.sql.*;
import java.util.*;
public class UsuarioDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ArrayList<UsuarioBean> listau=null;
    UsuarioBean objUsuarioBean=null;
    public boolean ValidarUsuario(UsuarioBean objUB){
        boolean estado=false;
        try {
            ConexionLoginBD objCLBD=new ConexionLoginBD();
            cn=objCLBD.getConexionLoginBD();
            pt=cn.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND tipo=? AND clave=?;");
            pt.setString(1, objUB.getUsuario());
            pt.setString(2, objUB.getTipo());
            pt.setString(3, objUB.getClave());
            rs=pt.executeQuery();
            if(rs.next()){estado=true;}
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    public boolean ValidarCambio(UsuarioBean objUB){
        boolean estado=false;
        try {
            ConexionLoginBD objCL=new ConexionLoginBD();
            cn=objCL.getConexionLoginBD();
            pt=cn.prepareStatement("SELECT * FROM usuarios WHERE clave=?;");
            pt.setString(1, objUB.getClave());
            rs=pt.executeQuery();
            if(rs.next()){estado=true;}
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return estado;
    }
    public int CambiarClave(UsuarioBean objUB){
        int i=0;
        try {
            ConexionLoginBD objBDCL=new ConexionLoginBD();
            cn=objBDCL.getConexionLoginBD();
            pt=cn.prepareStatement("UPDATE usuarios SET clave=? WHERE dni=?;");
            pt.setString(1, objUB.getClave());
            pt.setInt(2, objUB.getDni());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public ArrayList<UsuarioBean> Informacion(){
        try {
            ConexionLoginBD objBD=new ConexionLoginBD();
            cn=objBD.getConexionLoginBD();
            pt=cn.prepareStatement("SELECT * FROM usuarios");
            rs=pt.executeQuery();
            listau=new ArrayList<UsuarioBean>();
            while(rs.next()){
                objUsuarioBean=new UsuarioBean();
                objUsuarioBean.setDni(rs.getInt("dni"));
                objUsuarioBean.setNombre(rs.getString("nombre"));
                objUsuarioBean.setApellido(rs.getString("apellido"));
                objUsuarioBean.setEdad(rs.getInt("edad"));
                objUsuarioBean.setEstadocivil(rs.getString("estadocivil"));
                objUsuarioBean.setTelefono(rs.getInt("telefono"));
                objUsuarioBean.setHoraentrada(rs.getString("horaentrada"));
                objUsuarioBean.setHorasalida(rs.getString("horasalida"));
                objUsuarioBean.setUsuario(rs.getString("usuario"));
                objUsuarioBean.setTipo(rs.getString("tipo"));
                objUsuarioBean.setClave(rs.getString("clave"));
            listau.add(objUsuarioBean);}
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return listau;
    }
}