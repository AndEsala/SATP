package projects.patinajeids.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "baterias_deportistas")
public class DeportistasHasBaterias {
    @EmbeddedId
    private DeportistasHasBateriasId dHasBateriasId;

    /* Getters & Setters */
    public DeportistasHasBateriasId getdHasBateriasId() {
        return dHasBateriasId;
    }

    public void setdHasBateriasId(DeportistasHasBateriasId dHasBateriasId) {
        this.dHasBateriasId = dHasBateriasId;
    }
}
