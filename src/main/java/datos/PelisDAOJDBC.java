/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.PelisDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class PelisDAOJDBC implements PelisDAO{
    
private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_peli, pelicula, genero, duracion FROM Catalogo";
    private static final String SQL_INSERT = "INSERT INTO Catalogo(pelicula, genero, duracion) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Catalogo SET pelicula=?, genero=?, duracion=? WHERE id_peli = ?";
    private static final String SQL_DELETE = "DELETE FROM Catalogo WHERE id_peli=?";

    public PelisDAOJDBC() {

    }

    public PelisDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }


    public List<PelisDTO> Select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PelisDTO Catalogo = null;
        List<PelisDTO> repelis = new ArrayList<PelisDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_peli = rs.getInt("id_peli");
                String pelicula = rs.getString("pelicula");
                String genero = rs.getString("genero");
                String duracion = rs.getString("duracion");

                Catalogo = new PelisDTO();
                Catalogo.setId_peli(id_peli);
                Catalogo.setPelicula(pelicula);
                Catalogo.setGenero(genero);
                Catalogo.setDuracion(duracion);

                repelis.add(Catalogo);
            }
        } catch(SQLException ex) {
            System.out.println("Hay un error en Select "+ex);
        } catch (Exception ex) {
            Logger.getLogger(PelisDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repelis; 

    }



    public int Insert(PelisDTO Catalogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Catalogo.getPelicula());
            stmt.setString(2, Catalogo.getGenero());
            stmt.setString(3, Catalogo.getDuracion());
            

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
      
        } catch (Exception ex) {
            Logger.getLogger(PelisDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }



    public int update(PelisDTO Catalogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, Catalogo.getPelicula());
            stmt.setString(2, Catalogo.getGenero());
            stmt.setString(3, Catalogo.getDuracion());
            stmt.setInt(4, Catalogo.getId_peli());


            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        }  catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        } catch (Exception ex) {
            Logger.getLogger(PelisDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;  
    }

    public int Delete(PelisDTO Catalogo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Catalogo.getId_peli());
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
