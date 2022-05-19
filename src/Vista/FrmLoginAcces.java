package Vista;

import java.awt.event.*;
import Controlador.*;
import Modelo.*;
import javax.swing.*;

public class FrmLoginAcces extends JFrame implements ActionListener{
    JLabel lblUsuario, lblTipo, lblClave;
    public JTextField txtUsuario;
    public JComboBox cboTipo;
    public JPasswordField txtClave;
    JButton btnEntrar, btnSalir;
    UsuarioControlador objUsuarioControlador;
    UsuarioBean objUsuarioBean;
    public FrmLoginAcces(){
        initComponents();
        this.setLocationRelativeTo(null);
        objUsuarioControlador=new UsuarioControlador(this);
    }
    public void initComponents(){
        setSize(280, 280);
        setTitle("Ventana de Acceso");
        setLayout(null);
        lblUsuario=new JLabel();
        lblUsuario.setText("Usuario:");
        lblUsuario.setBounds(20,50,150,30);
        getContentPane().add(lblUsuario);
        txtUsuario=new JTextField();
        txtUsuario.setBounds(100,50,150,30);
        getContentPane().add(txtUsuario);
        
        lblTipo=new JLabel();
        lblTipo.setText("Tipo:");
        lblTipo.setBounds(20, 90, 150, 30);
        getContentPane().add(lblTipo);
        cboTipo=new JComboBox();
        cboTipo.addItem("----------");
        cboTipo.addItem("Gerente");
        cboTipo.addItem("Administrador");
        cboTipo.addItem("Vendedor");
        cboTipo.setBounds(100, 90, 150, 30);
        getContentPane().add(cboTipo);
        
        lblClave=new JLabel();
        lblClave.setText("Contraseña:");
        lblClave.setBounds(20,130,150,30);
        getContentPane().add(lblClave);
        txtClave=new JPasswordField();
        txtClave.setBounds(100,130,150,30);
        getContentPane().add(txtClave);
        
        btnEntrar=new JButton();
        btnEntrar.setText("Entrar");
        btnEntrar.setBounds(30, 190, 100, 30);
        btnEntrar.addActionListener(this);
        getContentPane().add(btnEntrar);
        
        btnSalir=new JButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(140, 190, 100, 30);
        btnSalir.addActionListener(this);
        getContentPane().add(btnSalir);
    }
    public static void main(String[] args) {
        FrmLoginAcces ventana=new FrmLoginAcces();
                      ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnEntrar){Entrar();}
        if(ae.getSource()==btnSalir){Salir();}
    }
    public void Entrar(){
        objUsuarioControlador.ValidarUsuarioControlador();
    }
    public void Salir(){
        this.dispose();
    }
}