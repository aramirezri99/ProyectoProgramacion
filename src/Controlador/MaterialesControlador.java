package Controlador;
import Modelo.*;
import Vista.*;
import java.util.*;
import javax.swing.*;
public class MaterialesControlador {
    ArrayList<MaterialesBean> lista;
    FrmMateriales objFrm;
    MaterialesDAO objMaterialesDAO;
    public MaterialesControlador(FrmMateriales objFrm){
        this.objFrm=objFrm;
        objMaterialesDAO=new MaterialesDAO();
    }
    public void InsertarMaterial(MaterialesBean objMB){
        int i;
        i=objMaterialesDAO.InsertarMaterial(objMB);
    }
    public void ListarMaterial(){
        int i=0;
        try {
            lista=objMaterialesDAO.ListarMaterial();
            objFrm.modelo.setNumRows(lista.size());
            for(MaterialesBean obj:lista){
                objFrm.modelo.setValueAt(obj.getCodigo(), i, 0);
                objFrm.modelo.setValueAt(obj.getTipo(), i, 1);
                objFrm.modelo.setValueAt(obj.getCaracteristica(), i, 2);
                objFrm.modelo.setValueAt(obj.getCantidad(), i, 3);
                objFrm.modelo.setValueAt(obj.getCosto(), i, 4);
                objFrm.modelo.setValueAt(obj.getFecha(), i, 5);
                i++;}
            objFrm.tabla.setModel(objFrm.modelo);
        } catch (Exception e) {
            
        }
    }
    public void ModificarMaterial(MaterialesBean objMB){
        int i;
        i=objMaterialesDAO.ModificarMaterial(objMB);
    }
    public void EliminarMaterial(MaterialesBean objMB){
        int i;
        i=objMaterialesDAO.EliminarMaterial(objMB);
    }
    public void Limpiar(){
        objFrm.txtcodigo.setText("");
        objFrm.cbotipo.setSelectedIndex(0);
        objFrm.txtcaracteristica.setText("");
        objFrm.txtcantidad.setText("");
        objFrm.txtcosto.setText("");
        objFrm.txtfecha.setText("");
    }
    public void Buscarcod(MaterialesBean objPB){
        boolean Estado=false;
        for(int i=0;i<lista.size();i++){MaterialesBean objPBean=lista.get(i);
        if(objPBean.getCodigo()==objPB.getCodigo()){Estado=true;break;}else{Estado=false;}
        }if(Estado==true){JOptionPane.showMessageDialog(null, "Código encontrado");
        }else{JOptionPane.showMessageDialog(null, "Código no encontrado");}
    }
    public void Buscartipo(MaterialesBean objPB){
        boolean Estado=false;
        for(int i=0;i<lista.size();i++){MaterialesBean objPBean=lista.get(i);
        if(objPBean.getTipo().equals(objPB.getTipo())){Estado=true;break;}else{Estado=false;}
        }if(Estado==true){JOptionPane.showMessageDialog(null, "Tipo encontrado");
        }else{JOptionPane.showMessageDialog(null, "Tipo no encontrado");}
    }
    public void Buscarcan(MaterialesBean objPB){
        boolean Estado=false;
        for(int i=0;i<lista.size();i++){MaterialesBean objPBean=lista.get(i);
        if(objPBean.getCantidad()==objPB.getCantidad()){Estado=true;break;}else{Estado=false;}
        }if(Estado==true){JOptionPane.showMessageDialog(null, "Cantidad encontrada");
        }else{JOptionPane.showMessageDialog(null, "Cantidad no encontrada");}
    }
    public void Buscarcos(MaterialesBean objPB){
        boolean Estado=false;
        for(int i=0;i<lista.size();i++){MaterialesBean objPBean=lista.get(i);
        if(objPBean.getCosto()==objPB.getCosto()){Estado=true;break;}else{Estado=false;}
        }if(Estado==true){JOptionPane.showMessageDialog(null, "Costo encontrado");
        }else{JOptionPane.showMessageDialog(null, "Costo no encontrado");}
    }
}