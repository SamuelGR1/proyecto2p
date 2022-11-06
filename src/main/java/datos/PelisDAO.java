/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.PelisDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PelisDAO {

    public List<PelisDTO> Select() throws SQLException;

    public int Insert(PelisDTO Catalogo) throws SQLException;

    public int update(PelisDTO Catalogo) throws SQLException;

    public int Delete(PelisDTO Catalogo) throws SQLException;

}
