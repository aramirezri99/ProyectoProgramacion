package Vista;
import Controlador.*;
import Imagenes.*;
import java.awt.event.*;
import javax.swing.*;
public class FrmAdministrador extends JFrame implements ActionListener{
    JMenuBar barra;
    JMenu archivo, perfil;
    JMenuItem materiales, produccion, cerrar;
    UsuarioControlador objUsuarioControlador;
    public FrmAdministrador(){
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
        archivo.setText(" Archivo ");
        materiales.setText("Registro de compra materiales");
        produccion.setText("Registro de producción");
        materiales.addActionListener(this);
        produccion.addActionListener(this);
        archivo.add(materiales);
        archivo.add(produccion);
        
        perfil=new JMenu();
        cerrar=new JMenuItem();
        perfil.setText(" Perfil ");
        cerrar.setText("Cerrar Usuario");
        cerrar.addActionListener(this);
        perfil.add(cerrar);
        
        barra.add(archivo);
        barra.add(perfil);
        setJMenuBar(barra);
        
    }
    public static void main(String[] args) {
        FrmAdministrador ventanaA=new FrmAdministrador();
                         ventanaA.setVisible(true);
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
        if(e.getSource()==cerrar){cerrar();}
    }
}
