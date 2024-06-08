package projects.patinajeids.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ParticipacionId {
    @ManyToOne
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "id_deportista")
    private Deportista deportista;

    /* Getters & Setters */
    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }

    
}
