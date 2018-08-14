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
    private int num_venta;
    private String nombre;
    private String descripcion;
    private String categoria;
    private int cantidad;
    private double precioC;
    private double precioV;
    private String proveedor;
    
    private int codigov;
    private int num_ventav;
    private String nombrev;
    private String descripcionv;
    private int cantidadv;
    private double precioVv;
    private double total;

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

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
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

    public int getCodigov() {
        return codigov;
    }

    public void setCodigov(int codigov) {
        this.codigov = codigov;
    }

    public int getNum_ventav() {
        return num_ventav;
    }

    public void setNum_ventav(int num_ventav) {
        this.num_ventav = num_ventav;
    }

    public String getNombrev() {
        return nombrev;
    }

    public void setNombrev(String nombrev) {
        this.nombrev = nombrev;
    }

    public String getDescripcionv() {
        return descripcionv;
    }

    public void setDescripcionv(String descripcionv) {
        this.descripcionv = descripcionv;
    }

    public int getCantidadv() {
        return cantidadv;
    }

    public void setCantidadv(int cantidadv) {
        this.cantidadv = cantidadv;
    }

    public double getPrecioVv() {
        return precioVv;
    }

    public void setPrecioVv(double precioVv) {
        this.precioVv = precioVv;
    }
    
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    

    public int buscarProducto(String cod) {

        int ban = 0;

        consulta = "SELECT * FROM Producto WHERE codigo=" + cod;

        if (conn.siExiste(consulta)) {
            consulta = "SELECT nombre, descripcion, categoria, cantidad, precioC, "
                    + "precioV, proveedor" + " FROM Producto WHERE codigo=" + cod;
            rs = conn.busqueda(consulta);

            try {
                while (rs.next()) {
                    this.setNombre(rs.getString(1));
                    this.setDescripcion(rs.getString(2));
                    this.setCategoria(rs.getString(3));
                    this.setCantidad(rs.getInt(4));
                    this.setPrecioC(rs.getDouble(5));
                    this.setPrecioV(rs.getDouble(6));
                    this.setProveedor(rs.getString(7));
                }
                ban = 1;
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return ban;
    }
    

    public int guardarproducto(){
    int res=0;
    consulta="INSERT INTO producto (codigo, nombre, descripcion, categoria, "
            + "cantidad, precioC, precioV, proveedor) "
            +"VALUES('"
            +getCodigo()+"','"
            +getNombre() +"','"
            +getDescripcion() +"',"
            +getCategoria()+","
            +getCantidad()+","
            +getPrecioC()+ ","
            +getPrecioV()+ ","
            +getProveedor()+ ")";
res=conn.Insertar(consulta);

return res;
}
    
        public int guardarproductoVenta(){
    int res=0;
    consulta="INSERT INTO venta (codigo, nombre, descripcion, cantidad, precioV, total) "
            +"VALUES('"
            +getCodigov()+"','"
            +getNombrev() +"','"
            +getDescripcionv() +"',"
            +getCantidadv() +","
            +getPrecioVv() +","
            +getTotal()+ ")";
        res=conn.Insertar(consulta);

            return res;
        }
        
  
      public int modificarproducto(){
    int res=0;
            consulta="UPDATE producto SET nombre='"+getNombre()+"',descripcion='"+getDescripcion()
        +"',categoria='"+getCategoria()+"',cantidad='"+getCantidad()+"',precioC='"+getPrecioC()+"',precioV='"
                +getPrecioV()+"',proveedor='"+getProveedor()+"'WHERE codigo="+getCodigo();
        res=conn.Insertar(consulta);

        return res;
        }


    
    }



