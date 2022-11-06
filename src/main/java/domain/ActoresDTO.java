/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author DELL
 */
public class ActoresDTO {
    

  
    private int id_actor;
    private String nombre;
    private String nacionalidad;


 public ActoresDTO() {
    }

     public ActoresDTO(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public ActoresDTO(int id_actor, String nombre, String nacionalidad) {
        this.id_actor = id_actor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;

    }

    /**
     * @return the id_actor
     */
    public int getId_actor() {
        return id_actor;
    }

    /**
     * @param id_actor the id_actor to set
     */
    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


@Override
    public String toString() {
        return "ActoresDTO{" + "id_actor=" + id_actor + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }




}