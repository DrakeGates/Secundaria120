package Clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Funciones
{
    private final DB DB;
    private ResultSet resultados;
    
    public Funciones() {
        this.DB = new DB();
    }
    
    public String VerFecha(String idPersona) {
        final String query = "call VerFecha("+idPersona+");";
        String fecha = "";
        try {
            final DB db = this.DB;
            try (final Connection con = Clases.DB.getConnection()) {
                final Statement sentencia = con.createStatement();
                this.resultados = sentencia.executeQuery(query);
                if (this.resultados.next()) {
                    fecha = this.resultados.getString("Fecha");
                }
                con.close();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return fecha;
    }
    
    public void ActualizarFecha(String idPersona,String fechaNueva) throws SQLException{
        final String query = "call ActualizarFecha("+idPersona+",'"+fechaNueva+"');";
        try (final Connection con = Clases.DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            sentencia.executeQuery(query);
            con.close();
        }
    }
    
    public ArrayList<String> VerDatos(final String idPersona) {
        final String query = "call VerDatos(" + idPersona + ");";
        final ArrayList<String> Datos = new ArrayList<String>();
        try {
            final DB db = this.DB;
            try (final Connection con = Clases.DB.getConnection()) {
                final Statement sentencia = con.createStatement();
                this.resultados = sentencia.executeQuery(query);
                if (this.resultados.next()) {
                    Datos.add(this.resultados.getString("Nombre"));
                    Datos.add(this.resultados.getString("Apaterno"));
                    Datos.add(this.resultados.getString("Amaterno"));
                    Datos.add(this.resultados.getString("Nacimiento"));
                    Datos.add(this.resultados.getString("Curp"));
                    Datos.add(this.resultados.getString("Email"));
                    Datos.add(this.resultados.getString("Celular"));
                    Datos.add(this.resultados.getString("Telefono"));
                }
                con.close();
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return Datos;
    }
    
    public ArrayList<String> VerPersonas(final String Tipo) {
        final String query = "call VerTodos" + Tipo + "();";
        final ArrayList<String> Personas = new ArrayList<String>();
        try {
            final DB db = this.DB;
            try (final Connection con = Clases.DB.getConnection()) {
                final Statement sentencia = con.createStatement();
                this.resultados = sentencia.executeQuery(query);
                while (this.resultados.next()) {
                    Personas.add(this.resultados.getString("Nombre"));
                    Personas.add(this.resultados.getString("Apaterno"));
                    Personas.add(this.resultados.getString("Amaterno"));
                    Personas.add(this.resultados.getString("idPersona"));
                }
                con.close();
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return Personas;
    }
    
    public ArrayList<String> VerGrupo(final String ano, final String grupo) {
        final String query = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
        final ArrayList<String> Alumnos = new ArrayList<String>();
        try {
            final DB db = this.DB;
            try (final Connection con = Clases.DB.getConnection()) {
                final Statement sentencia = con.createStatement();
                this.resultados = sentencia.executeQuery(query);
                while (this.resultados.next()) {
                    Alumnos.add(this.resultados.getString("Nombre"));
                    Alumnos.add(this.resultados.getString("Apaterno"));
                    Alumnos.add(this.resultados.getString("Amaterno"));
                    Alumnos.add(this.resultados.getString("idPersona"));
                }
                con.close();
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return Alumnos;
    }
    
    public ArrayList<String> VerSituaciones(final String idPersona) throws SQLException {
        final String query = "call VerSituaciones(" + idPersona + ");";
        final ArrayList<String> Situaciones = new ArrayList<String>();
        final DB db = this.DB;
        try (final Connection con = Clases.DB.getConnection()) {
            final Statement sentencia = con.createStatement();
            this.resultados = sentencia.executeQuery(query);
            while (this.resultados.next()) {
                Situaciones.add(this.resultados.getString("Situacion"));
                Situaciones.add(this.resultados.getString("Fecha"));
                Situaciones.add(this.resultados.getString("idSituacion"));
            }
            con.close();
        }
        return Situaciones;
    }
}