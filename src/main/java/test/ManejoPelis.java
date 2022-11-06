/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.Conexion;
import datos.PelisDAOJDBC;
import domain.PelisDTO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ManejoPelis {
    


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
            
            PelisDAOJDBC PelisJdbc = new PelisDAOJDBC();
            List<PelisDTO> log = PelisJdbc.Select();
            
            System.out.println("nombre" + log.toString());
            
//            PelisDTO cambioPeli = new PelisDTO();
//            cambioPeli.setId_peli(112);
//            cambioPeli.setPelicula("Riddick");
//            cambioPeli.setGenero("Ciencia Ficcion");
//            cambioPeli.setDuracion("1h 51m");
//            PelisJdbc.Delete(cambioPeli);


//            


    
            PelisDTO pelisdto = new PelisDTO();
     PelisDTO peliculasdtonew = new PelisDTO();
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
