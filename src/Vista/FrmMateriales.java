package Vista;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import Modelo.*;
import Controlador.*;
public class FrmMateriales extends JFrame implements ActionListener, MouseListener{
    JLabel lblcodigo, lbltipo, lblcaracteristica, lblcantidad, lblcosto, lblfecha;
    public JTextField txtcodigo, txtcaracteristica, txtcantidad, txtcosto, txtfecha;
    public JComboBox cbotipo;
    JButton btnagregar, btnmodificar, btneliminar;
    JMenuBar barra2;
    JMenu buscar;
    JMenuItem buscarxcod, buscarxtipo, buscarxcan, buscarxcosto;
    public JTable tabla;
    public DefaultTableModel modelo;
    public JScrollPane scroll;
    MaterialesBean objMaterialesBean;
    MaterialesControlador objMaterialesControlador;
    public FrmMateriales(){
        initComponents();
        objMaterialesControlador=new MaterialesControlador(this);
        Listar();
    }
    public void initComponents(){
        String columna[]={"Código", "Tipo", "Característica", "Cantidad", "Costo", "Fecha"};
        try {
            getContentPane().setLayout(null);
            
            barra2=new JMenuBar();
            
            buscar=new JMenu();
            buscarxcod=new JMenuItem();
            buscarxtipo=new JMenuItem();
            buscarxcan=new JMenuItem();
            buscarxcosto=new JMenuItem();
            
            buscar.setText(" Buscar ");
            buscarxcod.setText("BuscarXcódigo");
            buscarxtipo.setText("BuscarXtipo");
            buscarxcan.setText("BuscarXcantidad");
            buscarxcosto.setText("BuscarXcosto");
            buscarxcod.addActionListener(this);
            buscarxtipo.addActionListener(this);
            buscarxcan.addActionListener(this);
            buscarxcosto.addActionListener(this);
            buscar.add(buscarxcod);
            buscar.add(buscarxtipo);
            buscar.add(buscarxcan);
            buscar.add(buscarxcosto);
            
            barra2.add(buscar);
            setJMenuBar(barra2);
        
            lblcodigo=new JLabel();
            getContentPane().add(lblcodigo);
            lblcodigo.setText("Código:");
            lblcodigo.setBounds(300, 20, 100, 30);
            txtcodigo=new JTextField();
            getContentPane().add(txtcodigo);
            txtcodigo.setBounds(400, 20, 100, 30);
        
            lbltipo=new JLabel();
            getContentPane().add(lbltipo);
            lbltipo.setText("Tipo:");
            lbltipo.setBounds(300, 60, 100, 30);
            cbotipo=new JComboBox();
            getContentPane().add(cbotipo);
            cbotipo.addItem("----------");
            cbotipo.addItem("Tela");
            cbotipo.addItem("Pintura");
            cbotipo.addItem("Hilo");
            cbotipo.addItem("Diseño");
            cbotipo.addItem("Otros");
            cbotipo.setBounds(400, 60, 100, 30);
        
            lblcaracteristica=new JLabel();
            getContentPane().add(lblcaracteristica);
            lblcaracteristica.setText("Caracteristica:");
            lblcaracteristica.setBounds(300, 100, 100, 30);
            txtcaracteristica=new JTextField();
            getContentPane().add(txtcaracteristica);
            txtcaracteristica.setBounds(400, 100, 100, 30);
        
            lblcantidad=new JLabel();
            getContentPane().add(lblcantidad);
            lblcantidad.setText("Cantidad:");
            lblcantidad.setBounds(300, 140, 100, 30);
            txtcantidad=new JTextField();
            getContentPane().add(txtcantidad);
            txtcantidad.setBounds(400, 140, 100, 30);
        
            lblcosto=new JLabel();
            getContentPane().add(lblcosto);
            lblcosto.setText("Costo:");
            lblcosto.setBounds(300, 180, 100, 30);
            txtcosto=new JTextField();
            getContentPane().add(txtcosto);
            txtcosto.setBounds(400, 180, 100, 30);
        
            lblfecha=new JLabel();
            getContentPane().add(lblfecha);
            lblfecha.setText("Fecha:");
            lblfecha.setBounds(300, 220, 100, 30);
            txtfecha=new JTextField();
            getContentPane().add(txtfecha);
            txtfecha.setBounds(400, 220, 100, 30);
        
            btnagregar=new JButton();
            getContentPane().add(btnagregar);
            btnagregar.setText("Agregar");
            btnagregar.setBounds(520, 20, 100, 30);
            btnagregar.addActionListener(this);
        
            btnmodificar=new JButton();
            getContentPane().add(btnmodificar);
            btnmodificar.setText("Modificar");
            btnmodificar.setBounds(520, 60, 100, 30);
            btnmodificar.addActionListener(this);
        
            btneliminar=new JButton();
            getContentPane().add(btneliminar);
            btneliminar.setText("Eliminar");
            btneliminar.setBounds(520, 100, 100, 30);
            btneliminar.addActionListener(this);
        
            scroll=new JScrollPane();
            getContentPane().add(scroll);
            scroll.setBounds(10, 330, 765, 200);
            modelo=new DefaultTableModel(null, columna){
                public boolean isCellEditable(int row, int column){return false;}
            };
            tabla=new JTable();
            scroll.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(modelo);
            
            this.setSize(800, 600);
            this.setTitle("Registro de compra materiales");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        FrmMateriales ventana=new FrmMateriales();
                      ventana.setLocationRelativeTo(null);
                      ventana.setVisible(true);
    }
    public void Listar(){
        objMaterialesControlador.ListarMaterial();
    }
    public void Limpiar(){
        objMaterialesControlador.Limpiar();
    }
    public void Registrar(){
        objMaterialesBean=null;
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objMaterialesBean.setTipo(cbotipo.getSelectedItem().toString());
        objMaterialesBean.setCaracteristica(txtcaracteristica.getText());
        objMaterialesBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objMaterialesBean.setCosto(Double.parseDouble(txtcosto.getText()));
        objMaterialesBean.setFecha(txtfecha.getText());
        objMaterialesControlador.InsertarMaterial(objMaterialesBean);
        Limpiar();
    }
    public void Seleccionar(){
        try {
            txtcodigo.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            cbotipo.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtcaracteristica.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            txtcantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            txtcosto.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            txtfecha.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
            btnagregar.setEnabled(false);
        } catch (Exception e) {
        }
    }
    public void Modificar(){
        objMaterialesBean=null;
        if(txtcodigo.getText().length()!=0){
        objMaterialesBean=new MaterialesBean(); 
        objMaterialesBean.setTipo(cbotipo.getSelectedItem().toString());
        objMaterialesBean.setCaracteristica(txtcaracteristica.getText());
        objMaterialesBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objMaterialesBean.setCosto(Double.parseDouble(txtcosto.getText()));
        objMaterialesBean.setFecha(txtfecha.getText());
        objMaterialesBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objMaterialesControlador.ModificarMaterial(objMaterialesBean);}
        else{JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");}
        Limpiar();
        btnagregar.setEnabled(true);
    }
    public void Eliminar(){
        objMaterialesBean=null;
        if(txtcodigo.getText().length()!=0){
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objMaterialesControlador.EliminarMaterial(objMaterialesBean);}
        else{JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");}
        Limpiar();
        btnagregar.setEnabled(true);
    }
    public void BuscarXcodigo(){
        int codigo;
        codigo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese código a buscar"));
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setCodigo(codigo);
        objMaterialesControlador.Buscarcod(objMaterialesBean);
    }
    public void BuscarXtipo(){
        String tipo;
        tipo=JOptionPane.showInputDialog("Ingrese tipo a buscar");
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setTipo(tipo);
        objMaterialesControlador.Buscartipo(objMaterialesBean);
    }
    public void BuscarXcantidad(){
        int cantidad;
        cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad a buscar"));
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setCantidad(cantidad);
        objMaterialesControlador.Buscarcan(objMaterialesBean);
    }
    public void BuscarXcosto(){
        double precio;
        precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio a buscar"));
        objMaterialesBean=new MaterialesBean();
        objMaterialesBean.setCosto(precio);
        objMaterialesControlador.Buscarcos(objMaterialesBean);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnagregar){Registrar(); Listar();}
        if(ae.getSource()==btnmodificar){Modificar(); Listar();}
        if(ae.getSource()==btneliminar){Eliminar(); Listar();}
        if(ae.getSource()==buscarxcod){BuscarXcodigo();}
        if(ae.getSource()==buscarxtipo){BuscarXtipo();}
        if(ae.getSource()==buscarxcan){BuscarXcantidad();}
        if(ae.getSource()==buscarxcosto){BuscarXcosto();}
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tabla){Seleccionar();}
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}