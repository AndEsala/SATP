package projects.patinajeids.models;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "participaiones")
public class Participacion {
    @EmbeddedId
    private ParticipacionId id;

    private Integer posicion;
    private Integer puntos;

    @Temporal(TemporalType.TIME)
    private Date tiempo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    /* Getters & Setters */
    public ParticipacionId getId() {
        return id;
    }

    public void setId(ParticipacionId id) {
        this.id = id;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
