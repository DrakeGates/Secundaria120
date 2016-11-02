package Clases;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class UsuarioDAO
{
    public Usuario BuscarPorUsuario(final String usuario) throws SQLException {
        String query = "call BuscarUsuario(?)";
        try (final Connection con = DB.getConnection()) {
            final PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            final ResultSet rs = ps.executeQuery();
            Usuario p = null;
            if (rs.next()) {
                p = this.crearDTO(rs);
            }
            con.close();
            return p;
        }
    }
    
    public void RegistrarAlumno(final String nombre, final String Apaterno, final String Amaterno, final String ano, final String grupo, final String sexo, final String nacimiento, final String curp, final String email, final String celular, final String telefono, final String calle, final String num, final String colonia, final String delegacion, final String estado, final String cp, final String comentarioDir, final String usuario, final String pass, final String peso, final String estatura, final String lentes, final String zapatos, final String auditivo, final String comentarioAlu, final String nombreT, final String ApaternoT, final String AmaternoT, final String sexoT, final String nacimientoT, final String curpT, final String emailT, final String celularT, final String telefonoT, final String parentesco, final String afiliacion, final String vive) throws SQLException {
        final String query = "call RegistrarAlumno('" + nombre + "','" + Apaterno + "','" + Amaterno + "','" + ano + "','" + grupo + "','" + sexo + "','" + nacimiento + "','" + curp + "','" + email + "', '" + celular + "', '" + telefono + "','" + calle + "',  '" + num + "',  '" + colonia + "',  '" + delegacion + "',  '" + estado + "',  '" + cp + "',  '" + comentarioDir + "','" + usuario + "', '" + pass + "','" + peso + "','" + estatura + "','" + lentes + "','" + zapatos + "','" + auditivo + "','" + comentarioAlu + "','" + nombreT + "','" + ApaternoT + "','" + AmaternoT + "','" + sexoT + "','" + nacimientoT + "','" + curpT + "','" + emailT + "','" + celularT + "','" + telefonoT + "','" + parentesco + "','" + afiliacion + "','" + vive + "');";
        try (final Connection con = DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            sentencia.executeQuery(query);
        }
    }
    
    public void guardaImagen(final String usuario, final String nomFoto, final InputStream foto) throws SQLException, FileNotFoundException {
        try (final Connection con = DB.getConnection()) {
            final PreparedStatement ps = con.prepareStatement("call AgregarFoto(?,?,?);");
            ps.setString(1, usuario);
            ps.setString(2, nomFoto);
            ps.setBinaryStream(3, foto);
            ps.executeUpdate();
            ps.close();
        }
    }
    
    public void ModificarAlumno(final String nombre, final String Apaterno, final String Amaterno, final String ano, final String grupo, final String sexo, final String nacimiento, final String curp, final String email, final String celular, final String telefono, final String calle, final String num, final String colonia, final String delegacion, final String estado, final String cp, final String comentarioDir, final String usuario, final String pass, final String peso, final String estatura, final String lentes, final String zapatos, final String auditivo, final String comentarioAlu, final String nombreT, final String ApaternoT, final String AmaternoT, final String sexoT, final String nacimientoT, final String curpT, final String emailT, final String celularT, final String telefonoT, final String parentesco, final String idAlumno, final String afiliacion, final String vive, final String folio) throws SQLException {
        final String query = "call ModificarAlumno('" + nombre + "','" + Apaterno + "','" + Amaterno + "','" + ano + "','" + grupo + "','" + sexo + "','" + nacimiento + "','" + curp + "','" + email + "', '" + celular + "', '" + telefono + "','" + calle + "',  '" + num + "',  '" + colonia + "',  '" + delegacion + "',  '" + estado + "',  '" + cp + "',  '" + comentarioDir + "','" + usuario + "', '" + pass + "','" + peso + "','" + estatura + "','" + lentes + "','" + zapatos + "','" + auditivo + "','" + comentarioAlu + "','" + nombreT + "','" + ApaternoT + "','" + AmaternoT + "','" + sexoT + "','" + nacimientoT + "','" + curpT + "','" + emailT + "','" + celularT + "','" + telefonoT + "','" + parentesco + "'," + idAlumno + ",'" + afiliacion + "','" + vive + "','" + folio + "');";
        try (final Connection con = DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            sentencia.executeQuery(query);
            con.close();
        }
    }
    
    public void ModificarUsuario(final String nombre, final String Apaterno, final String Amaterno, final String sexo, final String nacimiento, final String curp, final String email, final String celular, final String telefono, final String calle, final String num, final String colonia, final String delegacion, final String estado, final String cp, final String comentarioDir, final String usuario, final String pass, final String idPersona, final String idModificador) throws SQLException {
        final String query = "call ModificarUsuario('" + nombre + "','" + Apaterno + "','" + Amaterno + "','" + sexo + "','" + nacimiento + "','" + curp + "','" + email + "', '" + celular + "', '" + telefono + "','" + calle + "',  '" + num + "',  '" + colonia + "',  '" + delegacion + "',  '" + estado + "',  '" + cp + "',  '" + comentarioDir + "','" + usuario + "', '" + pass + "'," + idPersona + "," + idModificador + ");";
        try (final Connection con = DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            sentencia.executeQuery(query);
            con.close();
        }
    }
    
    private Usuario crearDTO(final ResultSet rs) throws SQLException {
        final Usuario p = new Usuario();
        p.setUsuario(rs.getString("Usuario"));
        p.setPass(rs.getString("Pass"));
        p.setNombre(rs.getString("Nombre"));
        p.setPaterno(rs.getString("Apaterno"));
        p.setMaterno(rs.getString("Amaterno"));
        p.setId(rs.getString("idPersona"));
        p.setSexo(rs.getString("sexo"));
        final String string = rs.getString("idTipo");
        switch (string) {
            case "1": {
                p.setTipo("Alumno");
                break;
            }
            case "2": {
                p.setTipo("Docente");
                break;
            }
            case "3": {
                p.setTipo("Apoyo");
                break;
            }
            case "4": {
                p.setTipo("Doctor");
                break;
            }
            case "5": {
                p.setTipo("Administrativo");
                break;
            }
            case "6": {
                p.setTipo("Director");
                break;
            }
            case "7": {
                p.setTipo("Dios");
                break;
            }
            case "8": {
                p.setTipo("Registro");
                break;
            }
            case "9": {
                p.setTipo("Designer");
                break;
            }
        }
        return p;
    }
}