/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseapp;

/**
 *
 * @author claeo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class createEmbeddedDB 
{
    /**
     * If you try to connect the database on the server, you must start the
     * server first. Meanwhile, you need to import 'derbyclient.jar' to the
     * libraries.
     */
    //    private static final String URL = "jdbc:derby://localhost:1527/BookStoreDB";
    /**
     * If you try to connect the database embedded in the project, you must stop
     * the server first. Meanwhile, you need to import 'derby.jar' to the
     * libraries.
     */
    
    private static final String USER_NAME = "pdc"; 
    private static final String PASSWORD = "pdc"; 
    private static final String URL = "jdbc:derby:StudentDB; create=true";  

    Connection conn;

    public createEmbeddedDB() 
    {
        establishConnection();
    }

    public static void main(String[] args) 
    {
        createEmbeddedDB dbManager = new createEmbeddedDB();
        System.out.println(dbManager.getConnection());
    }

    public Connection getConnection() 
    {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() 
    {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() 
    {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}

