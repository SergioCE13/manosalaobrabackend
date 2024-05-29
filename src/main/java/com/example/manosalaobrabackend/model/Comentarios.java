package com.example.manosalaobrabackend.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Comentarios {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/manosalaobrabackend";
        String user = "root";
        String password = "Salono8899890!";

        String createTableSQL = "CREATE TABLE Comentario ("
                + "id_comentario INT NOT NULL AUTO_INCREMENT, "
                + "cant_like INT, "
                + "fecha_hora DATETIME, "
                + "cuerpo VARCHAR(350), "
                + "estrellas INT(1), "
                + "cliente_correo VARCHAR(45), "
                + "PRIMARY KEY (id_comentario), "
                + "FOREIGN KEY (cliente_correo) REFERENCES Cliente(correo)"
                + ") ENGINE=InnoDB";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'Comentario' created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
