package Vista;
import Controlador.*;
import Modelo.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class FrmProduccion extends JFrame implements ActionListener, MouseListener{
    JLabel lblcodigo, lbltipo, lblproducto, lblmodelo, lblmarca, lblequipo, lblcantidad, lblfechap, lblfechae;
    public JTextField txtcodigo, txtequipo,txtcantidad, txtfechap, txtfechae;
    public JComboBox cbotipo, cboproducto, cbomodelo, cbomarca;
    JButton btnagregar, btnmodificar, btneliminar;
    JMenuBar barra2;
    JMenu buscar;
    JMenuItem buscarxcod, buscarxtipo, buscarxcan, buscarxcosto;
    public JTable tabla;
    public DefaultTableModel modelo;
    public JScrollPane scroll;
    ProduccionBean objProduccionBean;
    ProduccionControlador objProduccionControlador;
    public FrmProduccion(){
        initComponents();
        objProduccionControlador=new ProduccionControlador(this);
        Listar();
    }
    public void initComponents(){
        String columna[]={"Código", "T.Produccion", "Producto", "Modelo", "Marca", "Equipo", "Cantidad", "Fecha P.", "Fecha E."};
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
            lbltipo.setText("T.Producción:");
            lbltipo.setBounds(300, 60, 100, 30);
            cbotipo=new JComboBox();
            getContentPane().add(cbotipo);
            cbotipo.addItem("----------");
            cbotipo.addItem("Pedido");
            cbotipo.addItem("Propio");
            cbotipo.setBounds(400, 60, 100, 30);
        
            lblproducto=new JLabel();
            getContentPane().add(lblproducto);
            lblproducto.setText("Producto:");
            lblproducto.setBounds(300, 100, 100, 30);
            cboproducto=new JComboBox();
            getContentPane().add(cboproducto);
            cboproducto.addItem("----------");
            cboproducto.addItem("Polo normal");
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
        
            lblfechap=new JLabel();
            getContentPane().add(lblfechap);
            lblfechap.setText("Fecha P.:");
            lblfechap.setBounds(300, 300, 100, 30);
            txtfechap=new JTextField();
            getContentPane().add(txtfechap);
            txtfechap.setBounds(400, 300, 100, 30);
        
            lblfechae=new JLabel();
            getContentPane().add(lblfechae);
            lblfechae.setText("Fecha E.:");
            lblfechae.setBounds(300, 340, 100, 30);
            txtfechae=new JTextField();
            getContentPane().add(txtfechae);
            txtfechae.setBounds(400, 340, 100, 30);
        
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
            this.setTitle("Registro de produccion");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) {
        FrmProduccion ventanaPr=new FrmProduccion();
                      ventanaPr.setLocationRelativeTo(null);
                      ventanaPr.setVisible(true);
    }
    public void Listar(){
        objProduccionControlador.ListarProduccion();
    }
    public void Limpiar(){
        objProduccionControlador.Limpiar();
    }
    public void Registrar(){
        objProduccionBean=null;
        objProduccionBean=new ProduccionBean();
        objProduccionBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objProduccionBean.setTipo(cbotipo.getSelectedItem().toString());
        objProduccionBean.setProducto(cboproducto.getSelectedItem().toString());
        objProduccionBean.setModelo(cbomodelo.getSelectedItem().toString());
        objProduccionBean.setMarca(cbomarca.getSelectedItem().toString());
        objProduccionBean.setEquipo(txtequipo.getText());
        objProduccionBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objProduccionBean.setFechap(txtfechap.getText());
        objProduccionBean.setFechae(txtfechae.getText());
        objProduccionControlador.InsertarProduccion(objProduccionBean);
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
            txtfechap.setText(tabla.getValueAt(tabla.getSelectedRow(), 7).toString());
            txtfechae.setText(tabla.getValueAt(tabla.getSelectedRow(), 8).toString());
            btnagregar.setEnabled(false);
        } catch (Exception e) {
        }
    }
    public void Modificar(){
        objProduccionBean=null;
        if(txtcodigo.getText().length()!=0){
        objProduccionBean=new ProduccionBean(); 
        objProduccionBean.setTipo(cbotipo.getSelectedItem().toString());
        objProduccionBean.setProducto(cboproducto.getSelectedItem().toString());
        objProduccionBean.setModelo(cbomodelo.getSelectedItem().toString());
        objProduccionBean.setMarca(cbomarca.getSelectedItem().toString());
        objProduccionBean.setEquipo(txtequipo.getText());
        objProduccionBean.setCantidad(Integer.parseInt(txtcantidad.getText()));
        objProduccionBean.setFechap(txtfechap.getText());
        objProduccionBean.setFechae(txtfechae.getText());
        objProduccionBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objProduccionControlador.ModificarProduccion(objProduccionBean);}
        else{JOptionPane.showMessageDialog(null, "Seleccione un registro para modificar");}
        Limpiar();
        btnagregar.setEnabled(true);
    }
    public void Eliminar(){
        objProduccionBean=null;
        if(txtcodigo.getText().length()!=0){
        objProduccionBean=new ProduccionBean();
        objProduccionBean.setCodigo(Integer.parseInt(txtcodigo.getText()));
        objProduccionControlador.EliminarProduccion(objProduccionBean);}
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