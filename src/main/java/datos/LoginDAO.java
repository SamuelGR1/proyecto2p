/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;
import domain.LoginDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface LoginDAO {

  
    public List<LoginDTO> Select() throws SQLException;

    public int Insert(LoginDTO Login) throws SQLException;

    public int update(LoginDTO Login) throws SQLException;

    public int Delete(LoginDTO Login) throws SQLException;

  
    
}
