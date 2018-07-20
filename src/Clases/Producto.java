package Clases;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricalv
 */
public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private String categoria;
    private int cantidad;
    private double precioC;
    private double precioV;
    private int proveedor;

    private ResultSet rs;
    private String consulta;

    Conexion conn = new Conexion();

    //ESTE ES EL CONSTRUCTOR
    public Producto() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }
    

    

    public int buscarProducto(String cod) {

        int ban = 0;

        consulta = "SELECT 1 FROM Producto WHERE codigo=" + cod;

        if (conn.siExiste(consulta)) {
            consulta = "SELECT nombre, descripcion, categoria, cantidad, precioC, "
                    + "precioV, proveedor " + " FROM Producto WHERE codigo=" + cod;
            rs = conn.busqueda(consulta);

            try {
                while (rs.next()) {
                    this.setNombre(rs.getString(1));
                    this.setDescripcion(rs.getString(2));
                    this.setCategoria(rs.getString(3));
                    this.setCantidad(rs.getInt(4));
                    this.setPrecioC(rs.getDouble(5));
                    this.setPrecioV(rs.getDouble(6));
                    this.setProveedor(rs.getInt(7));
                }
                ban = 1;
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return ban;
    }
}


