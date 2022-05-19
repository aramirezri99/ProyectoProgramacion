package Vista;

import Controlador.*;
import Modelo.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class FrmVentas extends JFrame implements ActionListener, MouseListener{
    JLabel lblcodigo, lbltipo, lblproducto, lblmodelo, lblmarca, lblequipo,lblcantidad, lblprecio, lblfecha;
    public JTextField txtcodigo, txtequipo,txtcantidad, txtprecio, txtfecha;
    public JComboBox cbotipo, cboproducto, cbomodelo, cbomarca;
    JButton btnagregar, btnmodificar, btneliminar;
    JMenuBar barra2;
    JMenu buscar;
    JMenuItem buscarxcod, buscarxtipo, buscarxcan, buscarxcosto;
    public JTable tabla;
    public DefaultTableModel modelo;
    public JScrollPane scroll;
    VentasBean objVentasBean;
    VentasControlador objVentasControlador;
    public FrmVentas(){
        initComponents();
        objVentasControlador=new VentasControlador(this);
        Listar();
    }
    public void initComponents(){
        String columna[]={"Código", "T.Venta", "Producto", "Modelo", "Marca", "Equipo", "Cantidad", "Precio", "Fecha de Venta"};
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
        
            //barra2.add(buscar);
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
            lbltipo.setText("T.Venta:");
            lbltipo.setBounds(300, 60, 100, 30);
            cbotipo=new JComboBox();
            getContentPane().add(cbotipo);
            cbotipo.addItem("----------");
            cbotipo.addItem("Pedido");
            cbotipo.addItem("Tienda");
            cbotipo.setBounds(400, 60, 100, 30);
        
            lblproducto=new JLabel();
            getContentPane().add(lblproducto);
            lblproducto.setText("Producto:");
            lblproducto.setBounds(300, 100, 100, 30);
            cboproducto=new JComboBox();
            getContentPane().add(cboproducto);
            cboproducto.addItem("----------");
            cboproducto.addItem("Polo clásico");
            cboproducto.addItem("Polo camisero");
            cboproducto.setBounds(400, 100, 100, 30);
            
            lblmodelo=new JLabel();
            getContentPane().add(lblmodelo);
            lblmodelo.setText("Modelo:");
            lblmodelo.setBounds(300, 140, 100, 30);
            cbomodelo=new JComboBox();
            getContentPane().add(cbomodelo);
            cbomodelo.addItem("----------");
            cbomodelo.addItem("Manga corta");
            cbomodelo.addItem("Manga larga");
            cbomodelo.setBounds(400, 140, 100, 30);
            
            lblmarca=new JLabel();
            getContentPane().add(lblmarca);
            lblmarca.setText("Marca:");
            lblmarca.setBounds(300, 180, 100, 30);
            cbomarca=new JComboBox();
            getContentPane().add(cbomarca);
            cbomarca.addItem("----------");
            cbomarca.addItem("Adidas");
            cbomarca.addItem("Nike");
            cbomarca.addItem("Puma");
            cbomarca.addItem("Umbro");
            cbomarca.setBounds(400, 180, 100, 30);
            
            lblequipo=new JLabel();
            getContentPane().add(lblequipo);
            lblequipo.setText("Equipo:");
            lblequipo.setBounds(300, 220, 100, 30);
            txtequipo=new JTextField();
            getContentPane().add(txtequipo);
            txtequipo.setBounds(400, 220, 100, 30);
        
            lblcantidad=new JLabel();
            getContentPane().add(lblcantidad);
            lblcantidad.setText("Cantidad:");
            lblcantidad.setBounds(300, 260, 100, 30);
            txtcantidad=new JTextField();
            getContentPane().add(txtcantidad);
            txtcantidad.setBounds(400, 260, 100, 30);
        
            lblprecio=new JLabel();
            getContentPane().add(lblprecio);
            lblprecio.setText("Precio:");
            lblprecio.setBounds(300, 300, 100, 30);
            txtprecio=new JTextField();
            getContentPane().add(txtprecio);
            txtprecio.setBounds(400, 300, 100, 30);
        
            lblfecha=new JLabel();
            getContentPane().add(lblfecha);
            lblfecha.setText("Fecha de venta:");
            lblfecha.setBounds(300, 340, 100, 30);
            txtfecha=new JTextField();
            getContentPane().add(txtfecha);
            txtfecha.setBounds(400, 340, 100, 30);
        
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
            scroll.setBounds(10, 390, 765, 200);
            modelo=new DefaultTableModel(null, columna){
            public boolean isCellEditable(int row, int column){return false;}
            };
            tabla=new JTable();
            scroll.setViewportView(tabla);
            tabla.addMouseListener(this);
            tabla.setModel(modelo);
            
            this.setSize(800, 660);
            this.setTitle("Registro de ventas");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        FrmVentas ventanaV=new FrmVentas();
                  ventanaV.setLocationRelativeTo(null);
                  ventanaV.setVisible(true);
    }
    public void Listar(){
            objVentasControlador.ListarVenta();
    }
    public void Limpiar(){
        objVentasControlador.Limpiar();
    }
    public void Registrar(){
        objVentasBean=null;
        objVentasBean=new VentasBean();
        objVentasBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objVentasBean.setTipo(cbotipo.getSelectedItem().toString());
        objVentasBean.setProducto(cboproducto.getSelectedItem().toString());
        objVentasBean.setModelo(cbomodelo.getSelectedItem().toString());
        objVentasBean.setMarca(cbomarca.getSelectedItem().toString());
        objVentasBean.setEquipo(txtequipo.getText());
        objVentasBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objVentasBean.setPrecio(Double.parseDouble(txtprecio.getText()));
        objVentasBean.setFecha(txtfecha.getText());
        objVentasControlador.InsertarVenta(objVentasBean);
        Limpiar();
    }
    public void Seleccionar(){
        try {
            txtcodigo.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            cbotipo.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            cboproducto.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            cbomodelo.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            cbomarca.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            txtequipo.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
            txtcantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 6).toString());
            txtprecio.setText(tabla.getValueAt(tabla.getSelectedRow(), 7).toString());
            txtfecha.setText(tabla.getValueAt(tabla.getSelectedRow(), 8).toString());
            btnagregar.setEnabled(false);
        } catch (Exception e) {
        }
    }
    public void Modificar(){
        objVentasBean=null;
        if(txtcodigo.getText().length()!=0){
        objVentasBean=new VentasBean(); 
        objVentasBean.setTipo(cbotipo.getSelectedItem().toString());
        objVentasBean.setProducto(cboproducto.getSelectedItem().toString());
        objVentasBean.setModelo(cbomodelo.getSelectedItem().toString());
        objVentasBean.setMarca(cbomarca.getSelectedItem().toString());
        objVentasBean.setEquipo(txtequipo.getText());
        objVentasBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objVentasBean.setPrecio(Double.parseDouble(txtprecio.getText()));
        objVentasBean.setFecha(txtfecha.getText());
        objVentasBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objVentasControlador.ModificarVenta(objVentasBean);}
        else{JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");}
        Limpiar();
        btnagregar.setEnabled(true);
    }
    public void Eliminar(){
        objVentasBean=null;
        if(txtcodigo.getText().length()!=0){
        objVentasBean=new VentasBean();
        objVentasBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objVentasControlador.EliminarVenta(objVentasBean);}
        else{JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");}
        Limpiar();
        btnagregar.setEnabled(true);
    }
    public void BuscarXcodigo(){
        //int codigo;
        //codigo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese código a buscar"));
        //objMaterialesBean=new MaterialesBean();
        //objMaterialesBean.setCodigo(codigo);
        //objMaterialesControlador.Buscarcod(objMaterialesBean);
    }
    public void BuscarXtipo(){
        //String tipo;
        //tipo=JOptionPane.showInputDialog("Ingrese tipo a buscar");
        //objMaterialesBean=new MaterialesBean();
        //objMaterialesBean.setTipo(tipo);
        //objMaterialesControlador.Buscartipo(objMaterialesBean);
    }
    public void BuscarXcantidad(){
        //int cantidad;
        //cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad a buscar"));
        //objMaterialesBean=new MaterialesBean();
        //objMaterialesBean.setCantidad(cantidad);
        //objMaterialesControlador.Buscarcan(objMaterialesBean);
    }
    public void BuscarXcosto(){
        //double precio;
        //precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio a buscar"));
        //objMaterialesBean=new MaterialesBean();
        //objMaterialesBean.setCosto(precio);
        //objMaterialesControlador.Buscarcos(objMaterialesBean);
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