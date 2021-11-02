package co.usa.recursosh.recursosh.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.recursosh.recursosh.model.Audience;
import co.usa.recursosh.recursosh.service.AudienceServicio;

@RestController
@RequestMapping("/api/Audience")
public class AudienceControlador {
    @Autowired
    private AudienceServicio audienceServicio;

    @GetMapping("/all")
    public List<Audience>getAudiences(){
        return audienceServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Audience>getAudience(@PathVariable("id") int id) {
        return audienceServicio.getAudience(id);        
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
        public Audience save(@RequestBody Audience audience) {
        return audienceServicio.save(audience);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience aud) {
        return audienceServicio.update(aud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int audienceId) {
        return audienceServicio.deleteAudience(audienceId);      
    }



    
    

    
}
