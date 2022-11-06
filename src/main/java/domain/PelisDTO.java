/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author DELL
 */
public class PelisDTO {
    
    private int id_peli;
    private String pelicula;
    private String genero;
    private String duracion;


     public PelisDTO() {
    }

     public PelisDTO(String pelicula, String genero,String duracion) {
        this.pelicula = pelicula;
        this.genero = genero;
        this.duracion = duracion;
    }
    
    public PelisDTO(int id_peli, String pelicula, String genero, String duracion) {
        this.id_peli = id_peli;
        this.pelicula = pelicula;
        this.genero = genero;
        this.duracion = duracion;
    }

    /**
     * @return the id_peli
     */
    public int getId_peli() {
        return id_peli;
    }

    /**
     * @param id_peli the id_peli to set
     */
    public void setId_peli(int id_peli) {
        this.id_peli = id_peli;
    }

    /**
     * @return the pelicula
     */
    public String getPelicula() {
        return pelicula;
    }

    /**
     * @param pelicula the pelicula to set
     */
    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
@Override
    public String toString() {
        return "PelisDTO{" + "id_peli=" + id_peli + ", pelicula=" + pelicula + ", genero=" + genero + ", duracion=" + duracion + '}';
    }

}
