package Vista;
import Controlador.*;
import Imagenes.*;
import java.awt.event.*;
import javax.swing.*;
public class FrmVendedor extends JFrame implements ActionListener{
    JMenuBar barra;
    JMenu archivo, perfil;
    JMenuItem ventas, cerrar;
    UsuarioControlador objUsuarioControlador;
    public FrmVendedor(){
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
        ventas=new JMenuItem();
        archivo.setText(" Archivo ");
        ventas.setText("Registro de ventas");
        ventas.addActionListener(this);
        archivo.add(ventas);
        
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
        FrmVendedor ventanav=new FrmVendedor();
                    ventanav.setVisible(true);
    }
    public void Ventas(){
        FrmVentas ventanaV=new FrmVentas();
                  ventanaV.setLocationRelativeTo(null);
                  ventanaV.setVisible(true);
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
        if(e.getSource()==ventas){Ventas();}
        if(e.getSource()==cerrar){cerrar();}
    }
}
