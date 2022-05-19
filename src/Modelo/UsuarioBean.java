package Modelo;
public class UsuarioBean {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String estadocivil;
    private int telefono;
    private String horaentrada;
    private String horasalida;
    private String usuario;
    private String tipo;
    private String clave;

    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEstadocivil() {
        return estadocivil;
    }
    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getHoraentrada() {
        return horaentrada;
    }
    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }
    public String getHorasalida() {
        return horasalida;
    }
    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
}