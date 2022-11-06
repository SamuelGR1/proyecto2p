/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.ActoresDAOJDBC;
import datos.Conexion;
import domain.ActoresDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ManejoActores {
    


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
            
            ActoresDAOJDBC AutorJdbc = new ActoresDAOJDBC();
            List<ActoresDTO> log = AutorJdbc.Select();
            
            System.out.println("nombre" + log.toString());
//            
            ActoresDTO cambioUsuario = new ActoresDTO();
            cambioUsuario.setId_actor(5);
            cambioUsuario.setNombre("Ruldin");
            cambioUsuario.setNacionalidad("guatemalteco");
            AutorJdbc.Delete(cambioUsuario);


//            


    
            ActoresDTO autordto = new ActoresDTO();
     ActoresDTO autoresdtonew = new ActoresDTO();
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
