/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Pelicula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulp
 */
public class PeliculaServicio implements IPeliculaServicio {

    private static List<Pelicula> peliculaList = new ArrayList<>();

    @Override
    public Pelicula crear(Pelicula pelicula) {
        var peliculaBuscando = this.buscar(pelicula.getCodigo());
        if(peliculaBuscando==null){
            this.peliculaList.add(pelicula);
        }else{
            throw new RuntimeException("El Codigo inngresado ya se encuentra "+
                                       "asignado a la Pelicula: "+peliculaBuscando.getNombre());
        }
        
        return pelicula;
    }

    @Override
    public List<Pelicula> listar() {
        return this.peliculaList;
    }

    @Override
    public Pelicula buscar(int codigo) {
        Pelicula pelicula = null;
        for (Pelicula pel : this.listar()) {
            if (codigo == pel.getCodigo()) {
                pelicula = pel;
                break;
            }
        }
        return pelicula;
    }

}
