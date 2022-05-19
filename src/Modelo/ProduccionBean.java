package Modelo;
public class ProduccionBean {
    private int codigo;
    private String tipo;
    private String producto;
    private String modelo;
    private String marca;
    private String equipo;
    private int cantidad;
    private String fechap;
    private String fechae;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getEquipo(){
        return equipo;
    }
    public void setEquipo(String equipo){
        this.equipo=equipo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFechap() {
        return fechap;
    }
    public void setFechap(String fechap) {
        this.fechap = fechap;
    }
    public String getFechae() {
        return fechae;
    }
    public void setFechae(String fechae) {
        this.fechae = fechae;
    }
}