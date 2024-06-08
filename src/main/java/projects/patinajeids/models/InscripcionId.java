package projects.patinajeids.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InscripcionId {
    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "id_club")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "id_deportista")
    private Deportista deportista;
}
