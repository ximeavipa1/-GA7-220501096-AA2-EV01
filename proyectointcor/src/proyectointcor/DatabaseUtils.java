/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectointcor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author XIME AVILA
 */
public class DatabaseUtils {
      // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/INTCOR";
    private static final String USER = "root"; // Cambia esto según tu configuración
    private static final String PASSWORD = "amoryamista"; // Cambia esto según tu configuración

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Connection objeto de conexión a la base de datos.
     * @throws SQLException si ocurre un error al conectar.
     */
    public static Connection getConnection() throws SQLException {
        // Cargar el controlador JDBC (opcional si está en el classpath)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC no encontrado", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
