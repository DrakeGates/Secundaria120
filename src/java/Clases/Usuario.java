package Clases;

public class Usuario
{
    private String nombre;
    private String paterno;
    private String materno;
    private String usuario;
    private String pass;
    private String tipo;
    private String id;
    private String sexo;
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getPaterno() {
        return this.paterno;
    }
    
    public void setPaterno(final String paterno) {
        this.paterno = paterno;
    }
    
    public String getMaterno() {
        return this.materno;
    }
    
    public void setMaterno(final String materno) {
        this.materno = materno;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }
    
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(final String pass) {
        this.pass = pass;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(final String sexo) {
        this.sexo = sexo;
    }
    
    public String capitalizar(final String palabra) {
        if (palabra.length() == 0) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
}