package Controlador;
import Modelo.*;
import Vista.*;
import javax.swing.*;
import java.util.*;
public class UsuarioControlador {
    FrmLoginAcces objFrmLogin;
    FrmGerente objFrmA;
    FrmAdministrador objFrmG;
    FrmVendedor objFrmv;
    FrmUsuarios objFrmu;
    UsuarioDAO objUsuarioDAO;
    UsuarioBean objUsuarioBean;
    ArrayList<UsuarioBean> listau;
    public UsuarioControlador(FrmLoginAcces objFrmLogin){
        this.objFrmLogin=objFrmLogin;
        objUsuarioDAO=new UsuarioDAO();
    }
    public UsuarioControlador(FrmGerente objFrmA){
        this.objFrmA=objFrmA;
        objUsuarioDAO=new UsuarioDAO();
    }
    public UsuarioControlador(FrmAdministrador objFrmG){
        this.objFrmG=objFrmG;
        objUsuarioDAO=new UsuarioDAO();
    }
    public UsuarioControlador(FrmVendedor objFrmv){
        this.objFrmv=objFrmv;
        objUsuarioDAO=new UsuarioDAO();
    }
    public UsuarioControlador(FrmUsuarios objFrmu){
        this.objFrmu=objFrmu;
        objUsuarioDAO=new UsuarioDAO();
    }
    public void ValidarUsuarioControlador(){
        boolean estado;
        String usu,cla,tipo;
        objUsuarioBean=new UsuarioBean();
        objUsuarioBean.setUsuario(objFrmLogin.txtUsuario.getText());
        objUsuarioBean.setTipo(objFrmLogin.cboTipo.getSelectedItem().toString());
        objUsuarioBean.setClave(objFrmLogin.txtClave.getText());
        usu=objFrmLogin.txtUsuario.getText();
        tipo=objFrmLogin.cboTipo.getSelectedItem().toString();
        cla=objFrmLogin.txtClave.getText();
        if(usu.length()==0 && cla.length()==0 && tipo.equals("----------")){JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        objFrmLogin.txtUsuario.requestFocus();
        }else if(usu.length()==0){JOptionPane.showMessageDialog(null, "Ingrese Usuario");
        objFrmLogin.txtUsuario.requestFocus();
        }else if(tipo.equals("----------")){JOptionPane.showMessageDialog(null, "Seleccione tipo de Usuario");
        objFrmLogin.txtClave.requestFocus();
        }else if(cla.length()==0){JOptionPane.showMessageDialog(null, "Ingrese Contraseña");
        objFrmLogin.txtClave.requestFocus();
        }else{estado=objUsuarioDAO.ValidarUsuario(objUsuarioBean);
        if(estado==true){
        if(tipo.equals("Gerente")){FrmGerente ventanaG=new FrmGerente();
                                              ventanaG.setVisible(true);
                                                          objFrmLogin.dispose();
        }else if(tipo.equals("Administrador")){FrmAdministrador ventanaA=new FrmAdministrador();
                                                                ventanaA.setVisible(true);
                                                                objFrmLogin.dispose();
        }else if(tipo.equals("Vendedor")){FrmVendedor ventanav=new FrmVendedor();
                                                      ventanav.setVisible(true);
                                                      objFrmLogin.dispose();
        }else{JOptionPane.showMessageDialog(null, "Tipo incorrecto");}
        }else{JOptionPane.showMessageDialog(null, "Campos incorrectos");
        objFrmLogin.txtUsuario.setText("");
        objFrmLogin.txtClave.setText("");
        objFrmLogin.cboTipo.setSelectedIndex(0);
        objFrmLogin.txtUsuario.requestFocus();}}
    }
    public void ValidarCambioControlador(){
        boolean estado;
        String cla;
        objUsuarioBean=new UsuarioBean();
        cla=JOptionPane.showInputDialog("Ingrese su contraseña");
        objUsuarioBean.setClave(cla);
        if(cla.length()==0){JOptionPane.showMessageDialog(null, "No ingresó clave");
        }else{estado=objUsuarioDAO.ValidarCambio(objUsuarioBean);
        if(estado==true){CambiarClaveControlador();
        }else{JOptionPane.showMessageDialog(null, "Contraseña incorrecta");}}
    }
    public void CambiarClaveControlador(){
        int i;
        String cla;
        int dni;
        objUsuarioBean=new UsuarioBean();
        cla=JOptionPane.showInputDialog("Introdusca su nueva contraseña");
        dni=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su DNI", 0));
        objUsuarioBean.setClave(cla);
        objUsuarioBean.setDni(dni);
        if(cla.length()==0){JOptionPane.showMessageDialog(null, "No ingreso nueva contraseña");
        }else{if(dni==0){JOptionPane.showMessageDialog(null, "No igreso su DNI");
        }else{i=objUsuarioDAO.CambiarClave(objUsuarioBean);
        switch(i){
            case 1:{JOptionPane.showMessageDialog(null, "Se modificó");break;}
            default:{JOptionPane.showMessageDialog(null, "No se modificó");}}}}
    }
    public void ListaInformación(){
        int i=0;
        try {
            listau=objUsuarioDAO.Informacion();
            objFrmu.model.setNumRows(listau.size());
            for(UsuarioBean obj:listau){
                objFrmu.model.setValueAt(obj.getDni(), i, 0);
                objFrmu.model.setValueAt(obj.getNombre(), i, 1);
                objFrmu.model.setValueAt(obj.getApellido(), i, 2);
                objFrmu.model.setValueAt(obj.getEdad(), i, 3);
                objFrmu.model.setValueAt(obj.getEstadocivil(), i, 4);
                objFrmu.model.setValueAt(obj.getTelefono(), i, 5);
                objFrmu.model.setValueAt(obj.getHoraentrada(), i, 6);
                objFrmu.model.setValueAt(obj.getHorasalida(), i, 7);
                objFrmu.model.setValueAt(obj.getUsuario(), i, 8);
                objFrmu.model.setValueAt(obj.getTipo(), i, 9);
                objFrmu.model.setValueAt(obj.getClave(), i, 10);
                i++;}
            objFrmu.table.setModel(objFrmu.model);
        } catch (Exception e) {
        }
    }
}