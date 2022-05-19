package Vista;
import Modelo.*;
import Controlador.*;
import javax.swing.*;
import javax.swing.table.*;

public class FrmUsuarios extends JFrame{
    public JTable table;
    public DefaultTableModel model;
    public JScrollPane scroll;
    UsuarioBean objUBean;
    UsuarioControlador objUsuarioControlador;
    String colum[]={"DNI","Nombre","Apellido","Edad","Estado Civil","Teléfono","Hora Entrada","Hora Salida","Usuario","Tipo","Clave"};
    public FrmUsuarios(){
        initComponents();
        this.setLocationRelativeTo(null);
        objUsuarioControlador=new UsuarioControlador(this);
        Listar();
    }
    public void initComponents(){
        setSize(1030,350);
        setTitle("Lista de Usuarios");
        setLayout(null);
        
        table=new JTable();
        model=new DefaultTableModel(null, colum){
            public boolean isCellEditable(int row, int column){return false;}
        };
        scroll=new JScrollPane();
        table.setModel(model);
        scroll.setViewportView(table);
        scroll.setBounds(10, 10, 1000, 300);
        getContentPane().add(scroll);
    }
    public static void main(String[] args) {
        FrmUsuarios ventanaI=new FrmUsuarios();
                    ventanaI.setVisible(true);
    }
    public void Listar(){
        objUsuarioControlador.ListaInformación();
    }
}