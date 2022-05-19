package Controlador;
import Modelo.*;
import Vista.*;
import java.util.*;
import javax.swing.*;
public class ProduccionControlador {
    ArrayList<ProduccionBean> lista;
    FrmProduccion objFrm;
    ProduccionDAO objProduccionDAO;
    public ProduccionControlador(FrmProduccion objFrm){
        this.objFrm=objFrm;
        objProduccionDAO=new ProduccionDAO();
    }
    public void InsertarProduccion(ProduccionBean objPB){
        int i;
        i=objProduccionDAO.InsertarProduccion(objPB);
    }
    public void ListarProduccion(){
        int i=0;
        try {
            lista=objProduccionDAO.ListarProduccion();
            objFrm.modelo.setNumRows(lista.size());
            for(ProduccionBean obj:lista){
                objFrm.modelo.setValueAt(obj.getCodigo(), i, 0);
                objFrm.modelo.setValueAt(obj.getTipo(), i, 1);
                objFrm.modelo.setValueAt(obj.getProducto(), i, 2);
                objFrm.modelo.setValueAt(obj.getModelo(), i, 3);
                objFrm.modelo.setValueAt(obj.getMarca(), i, 4);
                objFrm.modelo.setValueAt(obj.getEquipo(), i, 5);
                objFrm.modelo.setValueAt(obj.getCantidad(), i, 6);
                objFrm.modelo.setValueAt(obj.getFechap(), i, 7);
                objFrm.modelo.setValueAt(obj.getFechae(), i, 8);
                i++;}
            objFrm.tabla.setModel(objFrm.modelo);
        } catch (Exception e) {
            
        }
    }
    public void ModificarProduccion(ProduccionBean objPB){
        int i;
        i=objProduccionDAO.ModificarProduccion(objPB);
    }
    public void EliminarProduccion(ProduccionBean objPB){
        int i;
        i=objProduccionDAO.EliminarProduccion(objPB);
    }
    public void Limpiar(){
        objFrm.txtcodigo.setText("");
        objFrm.cbotipo.setSelectedIndex(0);
        objFrm.cboproducto.setSelectedIndex(0);
        objFrm.cbomodelo.setSelectedIndex(0);
        objFrm.cbomarca.setSelectedIndex(0);
        objFrm.txtequipo.setText("");
        objFrm.txtcantidad.setText("");
        objFrm.txtfechap.setText("");
        objFrm.txtfechae.setText("");
    }
}