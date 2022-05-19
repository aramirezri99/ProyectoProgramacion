package Modelo;
import Util.*;
import java.sql.*;
import java.util.*;
public class ProduccionDAO {
    ArrayList<ProduccionBean> lista=null;
    ProduccionBean objPBean=null;
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    public int InsertarProduccion(ProduccionBean objPB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO produccion(codigo, tipo, producto, modelo, marca, equipo,cantidad, fechap, fechae)VALUES(?,?,?,?,?,?,?,?,?);");
            pt.setInt(1,objPB.getCodigo());
            pt.setString(2, objPB.getTipo());
            pt.setString(3, objPB.getProducto());
            pt.setString(4, objPB.getModelo());
            pt.setString(5, objPB.getMarca());
            pt.setString(6, objPB.getEquipo());
            pt.setInt(7, objPB.getCantidad());
            pt.setString(8, objPB.getFechap());
            pt.setString(9, objPB.getFechae());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public ArrayList<ProduccionBean> ListarProduccion(){
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("SELECT * FROM produccion;");
            rs=pt.executeQuery();
            lista=new ArrayList<ProduccionBean>();
            while(rs.next()){
                objPBean=new ProduccionBean();
                objPBean.setCodigo(rs.getInt("codigo"));
                objPBean.setTipo(rs.getString("tipo"));
                objPBean.setProducto(rs.getString("producto"));
                objPBean.setModelo(rs.getString("modelo"));
                objPBean.setMarca(rs.getString("marca"));
                objPBean.setEquipo(rs.getString("equipo"));
                objPBean.setCantidad(rs.getInt("cantidad"));
                objPBean.setFechap(rs.getString("fechap"));
                objPBean.setFechae(rs.getString("fechae"));
                lista.add(objPBean);
            }
            pt.close();
            rs.close();
            cn.close();
        } catch (Exception e) {
        }
        return lista;
    }
    public int ModificarProduccion(ProduccionBean objPB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE produccion SET tipo=?, producto=?, modelo=? , marca=?, equipo=?, cantidad=?, fechap=?, fechae=? WHERE codigo=?;");
            pt.setString(1, objPB.getTipo());
            pt.setString(2, objPB.getProducto());
            pt.setString(3, objPB.getModelo());
            pt.setString(4, objPB.getMarca());
            pt.setString(5, objPB.getEquipo());
            pt.setInt(6, objPB.getCantidad());
            pt.setString(7, objPB.getFechap());
            pt.setString(8, objPB.getFechae());
            pt.setInt(9, objPB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
    public int EliminarProduccion(ProduccionBean objPB){
        int i=0;
        try {
            cn=ConexionRegistrosBD.getConexionBD();
            pt=cn.prepareStatement("DELETE FROM produccion WHERE codigo=?;");
            pt.setInt(1, objPB.getCodigo());
            i=pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
        return i;
    }
}