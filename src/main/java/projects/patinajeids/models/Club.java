package projects.patinajeids.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clubes")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nombre;

    @Column(name = "cidade")
    private String ciudad;

    @Column(name = "treinador")
    private String entrenador;

    @Column(name = "cpf_treinador")
    private String ccEntrenador;

    @Column(name = "telefone")
    private String telefono;

    @OneToMany
    @JoinTable(
        name = "treinadores_clubes",
        joinColumns = @JoinColumn(name = "id_treinador"),
        inverseJoinColumns = @JoinColumn(name = "id_club")
    )
    private List<Entrenador> entrenadores;

    /* Getters & Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getCcEntrenador() {
        return ccEntrenador;
    }

    public void setCcEntrenador(String ccEntrenador) {
        this.ccEntrenador = ccEntrenador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
}
