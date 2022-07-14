/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Actor;
import Modelo.Personaje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulp
 */
public class PersonajeServicio implements IPersonajeServicio {

    private static List<Personaje> personajeList = new ArrayList<>();

    @Override
    public Personaje crear(Personaje personaje) {
            this.personajeList.add(personaje);
        return personaje;
    }

    @Override
    public List<Personaje> listar() {
        return this.personajeList;
    }

    @Override
    public Personaje eliminar(int codigo) {
        for (int i = 0; i < this.personajeList.size(); i++) {
            Personaje ac = this.personajeList.get(i);
            if (codigo == ac.getCodigo()) {
                this.personajeList.remove(i);
                break;
            }
        }
        return null;
    }

    @Override
    public Personaje modificarPer(Personaje personaje) {
        for (int i = 0; i < this.personajeList.size(); i++) {
            Personaje pr = this.personajeList.get(i);
            if (pr.getCodigo() == personaje.getCodigo()) {
                this.personajeList.set(i, personaje);
                break;
            }
        }
        return null;
    }
    
    @Override
    public Personaje buscar(String actor, String pelicula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
