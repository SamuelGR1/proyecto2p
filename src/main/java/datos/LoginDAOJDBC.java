/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.LoginDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public  class LoginDAOJDBC implements LoginDAO {

   private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM Login";
    private static final String SQL_INSERT = "INSERT INTO Login(usuario, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Login SET usuario=?, password=? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM Login WHERE id_usuario=?";

    public LoginDAOJDBC() {

    }


    public LoginDAOJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }


    public List<LoginDTO> Select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginDTO Login = null;
        List<LoginDTO> Logines = new ArrayList<LoginDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
              

                Login = new LoginDTO();
                Login.setId_usuario(id_usuario);
                Login.setUsuario(usuario);
                Login.setPassword(password);
              

                Logines.add(Login);
            }
        } catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
      
        } catch (Exception ex) {
            Logger.getLogger(LoginDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Logines;

    }



    public int Insert(LoginDTO Login) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Login.getUsuario());
            stmt.setString(2, Login.getPassword());
          

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch(SQLException ex){
            System.out.println("Hay un error en Insert "+ex);
      
        } catch (Exception ex) {
            Logger.getLogger(LoginDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }



    public int update(LoginDTO Login) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, Login.getUsuario());
            stmt.setString(2, Login.getPassword());
            stmt.setInt(3, Login.getId_usuario());
       
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        }  catch(SQLException ex){
            System.out.println("Hay un erro en Update "+ex);
        } catch (Exception ex) {
            Logger.getLogger(ActoresDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;  
    }

    public int Delete(LoginDTO Login) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Login.getId_usuario());

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
