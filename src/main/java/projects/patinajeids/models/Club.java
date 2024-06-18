package projects.patinajeids.models;

import java.util.ArrayList;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "clubes")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idClub;

    @NotBlank(message = "El nombre no puede estar vacío!")
    private String nombre;

    @Email(message = "Email no válido!")
    private String email;

    @NotBlank(message = "El teléfono del entrenador no puede estar vacío!")
    private String telefono;

    @NotBlank(message = "La ciudad no puede estar vacía!")
    private String ciudad;

    @OneToMany
    @JoinTable(
        name = "entrenadores_clubes",
        joinColumns = @JoinColumn(name = "id_club"),
        inverseJoinColumns = @JoinColumn(name = "id_entrenador")
    )
    private List<Entrenador> entrenadores;

    /* Constructor */
    public Club() {
        this.entrenadores = new ArrayList<>();
    }

    /* Getters & Setters */
    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
}
