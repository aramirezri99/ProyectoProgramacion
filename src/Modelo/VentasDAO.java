package Modelo;
import Util.*;
import java.sql.*;
import java.util.*;
public class VentasDAO {
    ArrayList<VentasBean> lista=null;
    VentasBean objVBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    public int InsertarVentas(VentasBean objVB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO ventas(codigo, tipo, producto, modelo, marca, equipo, cantidad, precio, fecha)VALUES(?,?,?,?,?,?,?,?,?);");
            pt.setInt(1,objVB.getCodigo());
            pt.setString(2, objVB.getTipo());
            pt.setString(3, objVB.getProducto());
            pt.setString(4, objVB.getModelo());
            pt.setString(5, objVB.getMarca());
            pt.setString(6, objVB.getEquipo());
            pt.setInt(7, objVB.getCantidad());
            pt.setDouble(8, objVB.getPrecio());
            pt.setString(9, objVB.getFecha());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public ArrayList<VentasBean> ListarVentas(){
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("SELECT * FROM ventas;");
            rs=pt.executeQuery();
            lista=new ArrayList<VentasBean>();
            while(rs.next()){
                objVBean=new VentasBean();
                objVBean.setCodigo(rs.getInt("codigo"));
                objVBean.setTipo(rs.getString("tipo"));
                objVBean.setProducto(rs.getString("producto"));
                objVBean.setModelo(rs.getString("modelo"));
                objVBean.setMarca(rs.getString("marca"));
                objVBean.setEquipo(rs.getString("equipo"));
                objVBean.setCantidad(rs.getInt("cantidad"));
                objVBean.setPrecio(rs.getDouble("precio"));
                objVBean.setFecha(rs.getString("fecha"));
                lista.add(objVBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    }
    public int ModificarVentas(VentasBean objVB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE ventas SET tipo=?, producto=?, modelo=? , marca=?, equipo=?, cantidad=?, precio=?, fecha=? WHERE codigo=?;");
            pt.setString(1, objVB.getTipo());
            pt.setString(2, objVB.getProducto());
            pt.setString(3, objVB.getModelo());
            pt.setString(4, objVB.getMarca());
            pt.setString(5, objVB.getEquipo());
            pt.setInt(6, objVB.getCantidad());
            pt.setDouble(7, objVB.getPrecio());
            pt.setString(8, objVB.getFecha());
            pt.setInt(9, objVB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public int EliminarVentas(VentasBean objVB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("DELETE FROM ventas WHERE codigo=?;");
            pt.setInt(1, objVB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
}