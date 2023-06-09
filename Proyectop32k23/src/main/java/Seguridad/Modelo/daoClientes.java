/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsClientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {

    private static final String SQL_SELECT = "SELECT idClientes, Nombre, Nit FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(Nombre, Nit) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET Nombre=?, Nit=? WHERE idClientes = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE idClientes=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT idClientes, Nombre, Nit FROM clientes WHERE Nombre = ?";
    private static final String SQL_SELECT_ID = "SELECT idClientes, Nombre, Nit FROM clientes WHERE idClientes = ?";    

    public List<clsClientes> consultaClientes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsClientes> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String nit = rs.getString("Nit");
                
                clsClientes Clientes = new clsClientes();
                
                Clientes.setIdClientes(id);
                Clientes.setNombreClientes(nombre);
                Clientes.setNitClientes(nit);
                
                clientes.add(Clientes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public int ingresaClientes(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, clientes.getNombreClientes());
            stmt.setString(2, clientes.getNitClientes());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaClientes(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, clientes.getNombreClientes());
            stmt.setString(2, clientes.getNitClientes());
            stmt.setInt(3, clientes.getIdClientes());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarClientes(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, clientes.getIdClientes());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsClientes consultaClientesPorNombre(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + clientes);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, clientes.getNombreClientes());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String nit = rs.getString("Nit");

                //aplicacion = new clsAplicacion();
                clientes.setIdClientes(id);
                clientes.setNombreClientes(nombre);
                clientes.setNitClientes(nit);
                System.out.println(" registro consultado: " + clientes);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return clientes;
    }
    public clsClientes consultaClientesPorId(clsClientes clientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + clientes);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, clientes.getIdClientes());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idClientes");
                String nombre = rs.getString("Nombre");
                String nit = rs.getString("Nit");

                //aplicacion = new clsAplicacion();
                clientes.setIdClientes(id);
                clientes.setNombreClientes(nombre);
                clientes.setNitClientes(nit);
                System.out.println(" registro consultado: " + clientes);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return clientes;
    }    
}
