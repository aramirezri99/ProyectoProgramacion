package Controlador;
import Modelo.*;
import Vista.*;
import java.util.*;
import javax.swing.*;
public class VentasControlador {
    ArrayList<VentasBean> lista;
    FrmVentas objFrm;
    VentasDAO objVentasDAO;
    public VentasControlador(FrmVentas objFrm){
        this.objFrm=objFrm;
        objVentasDAO=new VentasDAO();
    }
    public void InsertarVenta(VentasBean objVB){
        int i;
        i=objVentasDAO.InsertarVentas(objVB);
    }
    public void ListarVenta(){
        int i=0;
        try {
            lista=objVentasDAO.ListarVentas();
            objFrm.modelo.setNumRows(lista.size());
            for(VentasBean obj:lista){
                objFrm.modelo.setValueAt(obj.getCodigo(), i, 0);
                objFrm.modelo.setValueAt(obj.getTipo(), i, 1);
                objFrm.modelo.setValueAt(obj.getProducto(), i, 2);
                objFrm.modelo.setValueAt(obj.getModelo(), i, 3);
                objFrm.modelo.setValueAt(obj.getMarca(), i, 4);
                objFrm.modelo.setValueAt(obj.getEquipo(), i, 5);
                objFrm.modelo.setValueAt(obj.getCantidad(), i, 6);
                objFrm.modelo.setValueAt(obj.getPrecio(), i, 7);
                objFrm.modelo.setValueAt(obj.getFecha(), i, 8);
                i++;}
            objFrm.tabla.setModel(objFrm.modelo);
        } catch (Exception e) {
            
        }
    }
    public void ModificarVenta(VentasBean objVB){
        int i;
        i=objVentasDAO.ModificarVentas(objVB);
    }
    public void EliminarVenta(VentasBean objVB){
        int i;
        i=objVentasDAO.EliminarVentas(objVB);
    }
    public void Limpiar(){
        objFrm.txtcodigo.setText("");
        objFrm.cbotipo.setSelectedIndex(0);
        objFrm.cboproducto.setSelectedIndex(0);
        objFrm.cbomodelo.setSelectedIndex(0);
        objFrm.cbomarca.setSelectedIndex(0);
        objFrm.txtequipo.setText("");
        objFrm.txtcantidad.setText("");
        objFrm.txtprecio.setText("");
        objFrm.txtfecha.setText("");
    }
}