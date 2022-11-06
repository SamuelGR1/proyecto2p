/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author DELL
 */
public class LoginDTO {
    

    private int id_usuario;
    private String usuario;
    private String password;

     public LoginDTO() {
    }

     public LoginDTO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public LoginDTO(int id_usuario, String usuario, String password) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
    }
    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

@Override
    public String toString() {
        return "LoginDTO{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + '}';
    }


}
