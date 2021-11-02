package co.usa.recursosh.recursosh.web;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.recursosh.recursosh.model.Mensajes;
import co.usa.recursosh.recursosh.service.MensajesServicio;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class MensajesControlador {
    @Autowired
    private MensajesServicio mensajesServicio;

    @GetMapping("/all")
    public List<Mensajes>getMensajes(){
        return mensajesServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensajes>getMensajes(@PathVariable("id") int id){
        return ((MensajesServicio) mensajesServicio).getMensajes(id);        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes save(@RequestBody Mensajes men){
        return mensajesServicio.save(men);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes update(@RequestBody Mensajes men) {
        return mensajesServicio.update(men);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int mensajeId) {
        return mensajesServicio.deleteMessage(mensajeId);
        
    }
        
    
}
   

