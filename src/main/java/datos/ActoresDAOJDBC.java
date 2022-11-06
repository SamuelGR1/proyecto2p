/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.ActoresDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ActoresDAOJDBC implements ActoresDAO {

 
 private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_actor, nombre, nacionalidad FROM Actor";
    private static final String SQL_INSERT = "INSERT INTO Actor(nombre, nacionalidad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Actor SET nombre=?, nacionalidad=? WHERE id_actor = ?";
    private static final String SQL_DELETE = "DELETE FROM Actor WHERE id_actor=?";

    public ActoresDAOJDBC() {

    }

    public ActoresDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }


    public List<ActoresDTO> Select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActoresDTO Actor = null;
        List<ActoresDTO> actores = new ArrayList<ActoresDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_actor = rs.getInt("id_actor");
                String nombre = rs.getString("nombre");
                String nacionalidad = rs.getString("nacionalidad");
              

                Actor = new ActoresDTO();
                Actor.setId_actor(id_actor);
                Actor.setNombre(nombre);
                Actor.setNacionalidad(nacionalidad);
              

                actores.add(Actor);
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ActoresDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actores; 

    }



    public int Insert(ActoresDTO Actor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Actor.getNombre());
            stmt.setString(2, Actor.getNacionalidad());
          

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
      
        } catch (Exception ex) {
            Logger.getLogger(ActoresDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }



    public int update(ActoresDTO Actor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, Actor.getNombre());
            stmt.setString(2, Actor.getNacionalidad());
            stmt.setInt(3, Actor.getId_actor());
       
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        }  catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ActoresDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;  
    }

    public int Delete(ActoresDTO Actor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Actor.getId_actor());


            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un erro en Delete "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ActoresDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
}