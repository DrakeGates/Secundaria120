package Clases;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AvisosDAO
{
    public List<Avisos> DesplegarAvisos() throws SQLException {
        final String query = "SELECT Asunto,Contenido,Fecha from Avisos;";
        try (final Connection con = DB.getConnection()) {
            final PreparedStatement ps = con.prepareStatement(query);
            final ResultSet rs = ps.executeQuery();
            final List<Avisos> list = new ArrayList<Avisos>();
            final List<Avisos> list2 = new ArrayList<Avisos>();
            while (rs.next()) {
                list.add(this.crearDTOAviso(rs));
            }
            try {
                for (int i = list.size() - 1; i > list.size() - 7; --i) {
                    list2.add(list.get(i));
                }
                return list2;
            }
            catch (Exception e) {
                return list;
            }
        }
    }
    
    private Avisos crearDTOAviso(final ResultSet rs) throws SQLException {
        final Avisos p = new Avisos();
        p.setAsunto(rs.getString("Asunto"));
        p.setFecha(rs.getString("Fecha"));
        p.setContenido(rs.getString("Contenido"));
        return p;
    }
    
    public void SubirAviso(final String Asunto, final String Contenido) throws SQLException {
        final String query = "call SubirAviso(?,?);";
        try (final Connection con = DB.getConnection()) {
            final PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Asunto);
            ps.setString(2, Contenido);
            ps.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}