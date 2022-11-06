/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.Conexion;
import datos.LoginDAOJDBC;
import domain.LoginDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ManejoLogin {

 public static void main(String[] args) throws Exception {
        Connection conexion = null;
        
        System.out.println("Hola");
        
         try {
            
              conexion= Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("conexion exitosa");
            }else{
                System.out.println("Conexion fallida");
            }
            
            LoginDAOJDBC LoginJdbc = new LoginDAOJDBC();
            List<LoginDTO> log = LoginJdbc.Select();
            
            System.out.println("usuario" + log.toString());
            
//            LoginDTO cambioUsuario = new LoginDTO();
//            cambioUsuario.setId_usuario(1);
//            cambioUsuario.setUsuario("Karla");
//            cambioUsuario.setPassword("333");
//            LoginJdbc.update(cambioUsuario);

//            LoginDTO cambioUsuario = new LoginDTO();
//            cambioUsuario.setId_usuario(5);
//            cambioUsuario.setUsuario("Ruldin");
//            cambioUsuario.setPassword("55555");
//            LoginJdbc.Insert(cambioUsuario);

            LoginDTO cambioUsuario = new LoginDTO();
            cambioUsuario.setId_usuario(2);
            LoginJdbc.Delete(cambioUsuario);
          
            LoginDTO logindto = new LoginDTO();
     LoginDTO loginsdtonew = new LoginDTO();
       conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
         } catch (SQLException ex) {
               ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
             try {
                  conexion.rollback();
             } catch (Exception ex1) {
                  ex1.printStackTrace(System.out);
             }
             
         }
     }
}
