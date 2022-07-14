/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Actor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulp
 */
public class ActorServicio implements IActorServicio {

    private static List<Actor> actorList = new ArrayList<>();

    @Override
    public Actor crear(Actor actor) {
        
        var actorBuscando = this.buscar(actor.getCodigo());
        if(actorBuscando==null){
            this.actorList.add(actor);
        }else{
            throw new RuntimeException("El Codigo inngresado ya se encu entra "+
                                       "asignado al actor : "+actorBuscando.getNombre());
        }
        return actor;
    }

    @Override
    public List<Actor> listar() {
        return this.actorList;
    }

    @Override
    public Actor modificarAct(Actor actors) {
        for (int i = 0; i < actorList.size(); i++) {
            Actor ac = actorList.get(i);
            if (ac.getCodigo() == actors.getCodigo()) {
                actorList.set(i, actors);
                break;
            }
        }
        return null;
    }

    @Override
    public Actor buscar(int codigo) {
        Actor actor=null;
        for (Actor act : this.listar()) {
            if (codigo == act.getCodigo()) {
                actor =act;
                break;
            }
        }
        return actor;
    }
}
