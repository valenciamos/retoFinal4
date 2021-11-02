package co.usa.recursosh.recursosh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservation")
public class Reservas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
     

    @ManyToOne
    @JoinColumn(name= "id")
    @JsonIgnoreProperties("reservations")
    private Audience audience;

    @ManyToOne
    @JoinColumn(name= "clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Clientes client;
    private String score;
    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Audience getAudience() {
        return audience;
    }
    public void setAudience(Audience audience) {
        this.audience = audience;
    }
    public Clientes getClient() {
        return client;
    }
    public void setClient(Clientes client) {
        this.client = client;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public Object getNombreReservas() {
        return null;
    }
    public void setNombreReserva(Object nombreReservas) {
    }
    public Object getFechaCreacionDate() {
        return null;
    }
    public void setFechaCreacionDate(Object fechaCreacionDate) {
    }

}

    