/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;
/**
 *
 * @author rical
 */
public class Conexion {
    Connection con;
    Statement smt;
    ResultSet rs;

    public Connection ConectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/TechSolution","root","");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Error En La Conexion: " + error);
        }
        return con;
    }

    public void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/TechSolution","root","");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Error En La Conexion: " + error);
        }
    }

    public void Desconectar() {
        try {
            con.close();
        } catch (SQLException error) {
            System.out.println("Error Al Desconectar La Base De Datos:" + error.getMessage());
        }
    }

    public ResultSet busqueda(String consulta) {
        Conectar();

        try {
            smt = con.createStatement();
            rs = smt.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println("Error En La Consulta: " + e.getMessage());
        }
        return rs;
    }

    public int Insertar(String consulta) {
        int resultado = 0;

        Conectar();

        try {
            smt = con.createStatement();
            resultado = smt.executeUpdate(consulta);
        } catch (SQLException e) {
            System.out.println("Error En La Consulta:" + e.getMessage());
        }
        Desconectar();
        return resultado;
    }

    public boolean siExiste(String consulta) {
        boolean existeRegistro = false;
        Conectar();
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    existeRegistro = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error En La Consulta: " + e.getMessage());
        }
        return existeRegistro;
    }

}
