/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoClientes;
/**
 *
 * @author visitante
 */
public class clsClientes {
    private int IdClientes;
    private String NombreClientes;
    private String NitClientes;

    public int getIdClientes() {
        return IdClientes;
    }

    public void setIdClientes(int IdClientes) {
        this.IdClientes = IdClientes;
    }

    public String getNombreClientes() {
        return NombreClientes;
    }

    public void setNombreClientes(String NombreClientes) {
        this.NombreClientes = NombreClientes;
    }

    public String getNitClientes() {
        return NitClientes;
    }

    public void setNitClientes(String NitClientes) {
        this.NitClientes = NitClientes;
    }

    public clsClientes(int IdClientes, String NombreClientes) {
        this.IdClientes = IdClientes;
        this.NombreClientes = NombreClientes;
    }

    public clsClientes(int IdClientes, String NombreClientes, String NitClientes) {
        this.IdClientes = IdClientes;
        this.NombreClientes = NombreClientes;
        this.NitClientes = NitClientes;
    }

    public clsClientes(int IdClientes) {
        this.IdClientes = IdClientes;
    }

    public clsClientes() {
    }

    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionClientesPorNombre(clsClientes Clientes)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.consultaClientesPorNombre(Clientes);
    }
    public clsClientes getBuscarInformacionClientesPorId(clsClientes Clientes)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.consultaClientesPorId(Clientes);
    }
    public List<clsClientes> getListadoClientes()
    {
        daoClientes daoclientes = new daoClientes();
        List<clsClientes> listadoClientes = daoclientes.consultaClientes();
        return listadoClientes;
    }
    public int setBorrarClientes(clsClientes Clientes)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.borrarClientes(Clientes);
    }
    public int setIngresarClientes(clsClientes Clientes)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.ingresaClientes(Clientes);
    }              
    public int setModificarClientes(clsClientes Clientes)
    {
        daoClientes daoclientes = new daoClientes();
        return daoclientes.actualizaClientes(Clientes);
    }

    public void add(List<clsClientes> Clientes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
