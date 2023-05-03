package model;

import java.sql.*;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3307/sistemagestion";
    private static final String USER = "smoothshop";
    private static final String PASSWORD = "//Skrillex95";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            // Cargar el driver de MySQL
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
        }
    }

    /**
     * Obtiene una conexión a la base de datos MySQL.
     *
     * @return la conexión a la base de datos.
     * @throws SQLException si ocurre un error al conectarse a la base de datos.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

