package projects.patinajeids.models;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "participaciones")
public class Participacion {
    @EmbeddedId
    private ParticipacionId id;

    @NotNull(message = "La posición no puede estar vacía!")
    private Integer posicion;

    @NotNull(message = "Los puntos no pueden estar vacíos!")
    private Integer puntos;

    @NotNull(message = "El tiempo no puede estar vacío!")
    @Temporal(TemporalType.TIME)
    private Date tiempo;

    @NotNull(message = "La fecha no puede estar vacía!")
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
