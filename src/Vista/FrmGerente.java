package Vista;
import Controlador.*;
import Imagenes.*;
import java.awt.event.*;
import javax.swing.*;
public class FrmGerente extends JFrame implements ActionListener{
    JMenuBar barra;
    JMenu archivo, perfil;
    JMenuItem materiales, produccion, ventas, usuarios,cambiarclave, cerrar;
    UsuarioControlador objUsuarioControlador;
    public FrmGerente(){
        add(new imagen());
        setSize(706,393);
        setVisible(true);
        initComponents();
        this.setLocationRelativeTo(null);
        objUsuarioControlador=new UsuarioControlador(this);
    }
    public void initComponents(){
        setTitle("Página Principal");
        setLayout(null);
        
        barra=new JMenuBar();
        
        archivo=new JMenu();
        materiales=new JMenuItem();
        produccion=new JMenuItem();
        ventas=new JMenuItem();
        archivo.setText(" Archivo ");
        materiales.setText("Registro de compra materiales");
        produccion.setText("Registro de producción");
        ventas.setText("Registro de ventas");
        materiales.addActionListener(this);
        produccion.addActionListener(this);
        ventas.addActionListener(this);
        archivo.add(materiales);
        archivo.add(produccion);
        archivo.add(ventas);
        
        perfil=new JMenu();
        usuarios=new JMenuItem();
        cambiarclave=new JMenuItem();
        cerrar=new JMenuItem();
        perfil.setText(" Perfil ");
        usuarios.setText("Lista de Usuarios");
        usuarios.addActionListener(this);
        cambiarclave.setText("Cambiar Contraseña");
        cambiarclave.addActionListener(this);
        cerrar.setText("Cerrar Usuario");
        cerrar.addActionListener(this);
        perfil.add(usuarios);
        perfil.add(cambiarclave);
        perfil.add(cerrar);
        
        barra.add(archivo);
        barra.add(perfil);
        setJMenuBar(barra);
        
    }
    public static void main(String[] args) {
        FrmGerente ventanaG=new FrmGerente();
                   ventanaG.setVisible(true);
    }
    public void Materiales(){
        FrmMateriales ventanaM=new FrmMateriales();
                      ventanaM.setLocationRelativeTo(null);
                      ventanaM.setVisible(true);
    }
    public void Produccion(){
        FrmProduccion ventanaPr=new FrmProduccion();
                      ventanaPr.setLocationRelativeTo(null);
                      ventanaPr.setVisible(true);
    }
    public void Ventas(){
        FrmVentas ventanaV=new FrmVentas();
                  ventanaV.setLocationRelativeTo(null);
                  ventanaV.setVisible(true);
    }
    public void Usuarios(){
        FrmUsuarios objventanaU=new FrmUsuarios();
                    objventanaU.setVisible(true);
    }
    public void cambiarcontraseña(){
        objUsuarioControlador.ValidarCambioControlador();
    }
    public void cerrar(){
        JOptionPane.showMessageDialog(null, "Usuario cerrado");
        this.dispose();
        FrmLoginAcces ventanaL=new FrmLoginAcces();
                      ventanaL.setLocationRelativeTo(null);
                      ventanaL.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==materiales){Materiales();}
        if(e.getSource()==produccion){Produccion();}
        if(e.getSource()==ventas){Ventas();}
        if(e.getSource()==usuarios){Usuarios();}
        if(e.getSource()==cambiarclave){cambiarcontraseña();}
        if(e.getSource()==cerrar){cerrar();}
    }
}