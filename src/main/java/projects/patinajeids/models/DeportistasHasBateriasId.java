package projects.patinajeids.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DeportistasHasBateriasId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_deportista")
    private Deportista deportista;

    @ManyToOne
    @JoinColumn(name = "id_bateria")
    private Bateria bateria;

    /* Constructor */
    public DeportistasHasBateriasId() {}

    public DeportistasHasBateriasId(Deportista deportista, Bateria bateria) {
        this.deportista = deportista;
        this.bateria = bateria;
    }

    /* Getters & Setters */
    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
}