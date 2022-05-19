package Modelo;
import Util.*;
import java.sql.*;
import java.util.*;
public class MaterialesDAO {
    ArrayList<MaterialesBean> lista=null;
    MaterialesBean objMBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    public int InsertarMaterial(MaterialesBean objMB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO materiales(codigo, tipo, caracteristica, cantidad, costo, fecha)VALUES(?,?,?,?,?,?);");
            pt.setInt(1,objMB.getCodigo());
            pt.setString(2, objMB.getTipo());
            pt.setString(3, objMB.getCaracteristica());
            pt.setInt(4, objMB.getCantidad());
            pt.setDouble(5, objMB.getCosto());
            pt.setString(6, objMB.getFecha());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public ArrayList<MaterialesBean> ListarMaterial(){
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("SELECT * FROM materiales;");
            rs=pt.executeQuery();
            lista=new ArrayList<MaterialesBean>();
            while(rs.next()){
                objMBean=new MaterialesBean();
                objMBean.setCodigo(rs.getInt("codigo"));
                objMBean.setTipo(rs.getString("tipo"));
                objMBean.setCaracteristica(rs.getString("caracteristica"));
                objMBean.setCantidad(rs.getInt("cantidad"));
                objMBean.setCosto(rs.getDouble("costo"));
                objMBean.setFecha(rs.getString("fecha"));
                lista.add(objMBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    }
    public int ModificarMaterial(MaterialesBean objMB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE materiales SET tipo=?, caracteristica=?, cantidad=? , costo=?, fecha=? WHERE codigo=?;");
            pt.setString(1, objMB.getTipo());
            pt.setString(2, objMB.getCaracteristica());
            pt.setInt(3, objMB.getCantidad());
            pt.setDouble(4, objMB.getCosto());
            pt.setString(5, objMB.getFecha());
            pt.setInt(6, objMB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public int EliminarMaterial(MaterialesBean objMB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("DELETE FROM materiales WHERE codigo=?;");
            pt.setInt(1, objMB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
}