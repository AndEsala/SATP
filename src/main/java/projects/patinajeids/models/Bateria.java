package projects.patinajeids.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "baterias")
public class Bateria {
    @Id
    @Column(name = "id")
    private Integer idBateria;

    @ManyToMany
    @JoinTable(
        name = "baterias_deportistas",
        joinColumns = @JoinColumn(name = "id_bateria"),
        inverseJoinColumns = @JoinColumn(name = "id_deportista")
    )
    private List<Deportista> deportistas;

    /* Getters & Setters */
    public Integer getIdBateria() {
        return idBateria;
    }

    public void setIdBateria(Integer idBateria) {
        this.idBateria = idBateria;
    }

    public List<Deportista> getDeportistas() {
        return deportistas;
    }

    public void setDeportistas(List<Deportista> deportistas) {
        this.deportistas = deportistas;
    }
}
