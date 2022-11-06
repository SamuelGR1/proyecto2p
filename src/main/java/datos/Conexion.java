  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;



/**
 *
 * @author DELL
 */
public class Conexion {
    
private static final String JDBC_URL = "jdbc:sqlite:C:\\SQLITE\\SQLiteStudio\\Proyecto2P2";
public static Connection getConnection() throws Exception{

return DriverManager.getConnection(JDBC_URL);
}

}





