package projects.patinajeids.models;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @EmbeddedId
    private InscripcionId id;

    private Integer numero;
    private Date fechaInscripcion;
    private Integer pago;

    /* Getters & Setters */
    public InscripcionId getId() {
        return id;
    }

    public void setId(InscripcionId id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getPago() {
        return pago;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }
}
