package co.usa.recursosh.recursosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursosh.recursosh.model.Reservas;
import co.usa.recursosh.recursosh.repository.ReservasRepositorio;

@Service
public class ReservasServicio {
    @Autowired
    ReservasRepositorio reservasRepositorio;

    public List<Reservas>getAll(){
        return reservasRepositorio.getAll();                
    }

    public Optional<Reservas>getReservas(int id){
        return reservasRepositorio.getReservas(id);                
    }

    public Reservas save(Reservas res){
        // verificar si el id es nulo

        if (res.getIdReservation()==null){
            return reservasRepositorio.save(res);
        }else{// verifico si existe o no el id en la base de datos
            Optional<Reservas> consulta=reservasRepositorio.getReservas(res.getIdReservation());

            if(consulta.isEmpty()){
                return reservasRepositorio.save(res);
            
            }else{
                return res;
            }
        }
    }

    public Reservas update(Reservas res){
        if (res.getIdReservation()!=null){
            Optional<Reservas> consulta=reservasRepositorio.getReservas(res.getIdReservation());
            if(!consulta.isEmpty()) {
                if(res.getNombreReservas()!= null){
                    consulta.get().setNombreReserva(res.getNombreReservas());
                }
                if(res.getFechaCreacionDate()!=null) {
                    consulta.get().setFechaCreacionDate(res.getFechaCreacionDate());
                    
                }
                return reservasRepositorio.save(consulta.get());
            
            }


        }return res;

    }

    public boolean deleteReservation(int reservaId) {
        Boolean auBoolean = getReservas(reservaId).map(reservas -> {
            reservasRepositorio.delete(reservas);
            return true;
        }).orElse(false);
        return auBoolean;
    }



    
}