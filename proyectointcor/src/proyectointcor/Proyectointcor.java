/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectointcor;

import java.sql.SQLException;  // Importar si es necesario para manejo de excepciones

/**
 *
 * @author XIME AVILA
 */
public class Proyectointcor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        
        try {
// Insertar un cliente
            dao.insertarCliente("lucas", "Calle 123", "lucz@example.com", "567890");
            // Consultar clientes
            dao.consultarClientes();

            // Actualizar un cliente
            dao.actualizarCliente(28, "fredy", "arbusto", "fredy123@example.com", "54321");

            // Eliminar un cliente
            dao.eliminarCliente(0);  // Solo se necesita el ID para eliminar
        } catch (SQLException e) {  // Manejo más específico de excepciones SQL
            System.err.println("Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}