/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.ActoresDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ActoresDAO {
    

public List<ActoresDTO> Select() throws SQLException;

    public int Insert(ActoresDTO Actor) throws SQLException;

    public int update(ActoresDTO Actor) throws SQLException;

    public int Delete(ActoresDTO Actor) throws SQLException;



}
