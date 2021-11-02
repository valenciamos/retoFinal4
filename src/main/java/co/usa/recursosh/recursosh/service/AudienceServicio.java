package co.usa.recursosh.recursosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursosh.recursosh.model.Audience;
import co.usa.recursosh.recursosh.repository.AudienceRepositorio;

@Service
public class AudienceServicio {

    @Autowired
    private AudienceRepositorio audienceRepositorio;

    public List<Audience>getAll(){
        return audienceRepositorio.getAll();      
    }

    public Optional<Audience>getAudience(int id){
        return audienceRepositorio.getAudience(id);
    }

    public Audience save(Audience audience){
        if (audience.getId()==null) {
            return audienceRepositorio.save(audience);

        } else{
            Optional<Audience> consulta=audienceRepositorio.getAudience(audience.getId());
            if (consulta.isEmpty()) {
                return audienceRepositorio.save(audience);
                

            } else {
                return audience;
            }
            
        }

    }

    public Audience update(Audience aud){
        if (aud.getId()!=null){
            Optional<Audience> consulta=audienceRepositorio.getAudience(aud.getId());
            if(!consulta.isEmpty()) {
                if(aud.getName()!= null){
                    consulta.get().setName(aud.getName());
                }
                if(aud.getOwner()!=null) {
                    consulta.get().setOwner(aud.getOwner());

                if (aud.getCapacity()!=null){
                    consulta.get().setCapacity(aud.getCapacity());

                }
                if (aud.getDescription()!=null){
                    consulta.get().setDescription(aud.getDescription());
                }
                                    
                }
                return audienceRepositorio.save(consulta.get());
            
            }

            
        }
        return aud;
    } 

      
    public boolean deleteAudience(int audienceId){
        Boolean auBoolean=getAudience(audienceId).map(audience -> {
           audienceRepositorio.delete(audience);
           return true;
        }).orElse(false);
        return auBoolean;
    }

   
}
