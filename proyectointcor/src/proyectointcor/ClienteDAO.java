/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointcor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author  XIME AVILA
 */
public class ClienteDAO {
  
    public void insertarCliente(String nombre, String direccion, String correo, String telefono) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, direccion, correo, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseUtils.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, direccion);
            pstmt.setString(3, correo);
            pstmt.setString(4, telefono);
            pstmt.executeUpdate();
        }
    }

    /**
     * Consulta todos los clientes de la base de datos.
     *
     * @throws SQLException si ocurre un error al consultar.
     */
    public void consultarClientes() throws SQLException {
        String sql = "SELECT * FROM cliente";
        try (Connection con = DatabaseUtils.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_cliente") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Dirección: " + rs.getString("direccion") +
                                   ", Email: " + rs.getString("correo") +
                                   ", Teléfono: " + rs.getString("telefono"));
            }
        }
    }

    
    public void actualizarCliente(int id, String nombre, String direccion, String correo, String telefono) throws SQLException {
        String sql = "UPDATE cliente SET nombre = ?, direccion = ?, correo = ?, telefono = ? WHERE id_cliente = ?";
        try (Connection con = DatabaseUtils.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, direccion);
            pstmt.setString(3, correo);
            pstmt.setString(4, telefono);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        }
    }

    
    public void eliminarCliente(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try (Connection con = DatabaseUtils.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}   
