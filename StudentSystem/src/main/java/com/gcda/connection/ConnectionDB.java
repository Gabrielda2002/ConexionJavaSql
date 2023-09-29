package main.java.com.gcda.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    public  static Connection getConnectionDB(){
        //objeto para crear la conexion
        Connection connection = null;
        //variables de la base de datos
        String dataBase = "sena_data";
        String url = "jdbc:mysql://localhost:3307/"+ dataBase;
        String name  = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Ocurrio un error en la conexion " + ex.getMessage());
        }


        return  connection;


    }

    public static void main(String[] args) {
        Connection connection2 = ConnectionDB.getConnectionDB();
        if(connection2 != null){
            System.out.println("Conexion exitosa " + connection2);
        }else{
            System.out.println("Paila pa");
        }
    }
}
