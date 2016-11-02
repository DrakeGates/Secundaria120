package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Funciones
{
    String query;
    DB DB = new DB();
    ResultSet resultados;
    
    public String VerFecha(String idPersona){
        query = "call VerFecha("+idPersona+");";
        String fecha = "";
        try{
            DB.conectar();
            resultados = DB.consulta(query);
            if (resultados.next()) {
                fecha = resultados.getString("Fecha");
            }
            DB.cierraConexion();
        }catch(SQLException e){
            System.out.println(e);
        }
        return fecha;
    }
    
    public void ActualizarFecha(String idPersona,String fechaNueva) throws SQLException{
        query = "call ActualizarFecha("+idPersona+",'"+fechaNueva+"');";
        try{
            DB.consulta(query);
            DB.cierraConexion();
        }catch(SQLException e){
            System.out.println(e);
            int i = 9;
        }
        
    }
    
    public ArrayList<String> VerDatos(final String idPersona) throws SQLException {
        query = "call VerDatos(" + idPersona + ");";
        ArrayList<String> Datos = new ArrayList<>();
        DB.conectar();
        resultados = DB.consulta(query);
        if (resultados.next()) {
            Datos.add(resultados.getString("Nombre"));
            Datos.add(resultados.getString("Apaterno"));
            Datos.add(resultados.getString("Amaterno"));
            Datos.add(resultados.getString("Nacimiento"));
            Datos.add(resultados.getString("Curp"));
            Datos.add(resultados.getString("Email"));
            Datos.add(resultados.getString("Celular"));
            Datos.add(resultados.getString("Telefono"));
        }
        DB.cierraConexion();
        return Datos;
    }
    
    public ArrayList<String> VerPersonas(final String Tipo) throws SQLException {
        query = "call VerTodos" + Tipo + "();";
        final ArrayList<String> Personas = new ArrayList<>();
        DB.conectar();
        resultados = DB.consulta(query);
        while (resultados.next()) {
            Personas.add(resultados.getString("Nombre"));
            Personas.add(resultados.getString("Apaterno"));
            Personas.add(resultados.getString("Amaterno"));
            Personas.add(resultados.getString("idPersona"));
        }
        DB.cierraConexion();
        return Personas;
    }
    
    public ArrayList<String> VerGrupo(final String ano, final String grupo) throws SQLException {
        query = "call VerAlumnosGrupo(" + ano + ",'" + grupo + "');";
        ArrayList<String> Alumnos = new ArrayList<>();
        try{
            DB.conectar();
            resultados = DB.consulta(query);
            while (this.resultados.next()) {
                Alumnos.add(this.resultados.getString("Nombre"));
                Alumnos.add(this.resultados.getString("Apaterno"));
                Alumnos.add(this.resultados.getString("Amaterno"));
                Alumnos.add(this.resultados.getString("idPersona"));
            }
            DB.cierraConexion();
        }catch(Exception e){
            
        }
        return Alumnos;
    }
    
    public ArrayList<String> VerSituaciones(final String idPersona) throws SQLException {
        query = "call VerSituaciones(" + idPersona + ");";
        ArrayList<String> Situaciones = new ArrayList<>();
        DB.conectar();
        resultados = DB.consulta(query);
        while (resultados.next()) {
            Situaciones.add(resultados.getString("Situacion"));
            Situaciones.add(resultados.getString("Fecha"));
            Situaciones.add(resultados.getString("idSituacion"));
        }
        DB.cierraConexion();
        return Situaciones;
    }
}