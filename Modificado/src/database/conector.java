package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conector {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda" ;
    private static final String USER = "root";
    private static final String PASSWWORD= "";
    private Connection connection;
    public conector () {
        try {
            this.connection = DriverManager.getConnection(URL,USER,PASSWWORD) ;
            System.out.println("Conexion exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar base de datos"+e.getMessage());
        }
    }
    public Connection getConnection () {return this.connection; }
}

