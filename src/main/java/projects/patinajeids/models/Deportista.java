package projects.patinajeids.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "deportistas")
public class Deportista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idDeportista;

    @NotBlank
    @Column(name = "doc_identidad")
    private String docIdentidad;

    @NotBlank(message = "El nombre no puede estar vacío!")
    private String nombre;

    @NotBlank(message = "El primer apellido no puede estar vacío!")
    private String pApellido;

    @NotBlank(message = "El segundo apellido no puede estar vacío!")
    private String sApellido;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía!")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @NotNull(message = "La edad no puede estar vacía!")
    private Integer edad;
    
    @NotBlank(message = "El sexo no puede estar vacío!")
    private String sexo;

    @NotNull(message = "Debe seleccionar un Club a representar!")
    @OneToOne
    @JoinColumn(name = "id_club")
    private Club club;
    
    @NotNull(message = "Debe seleccionar una categoría!")
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany
    @JoinColumn(name = "id_deportista", nullable = true)
    private List<Participacion> participaciones;

    /* Getters & Setters */
    public Integer getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(Integer idDeportista) {
        this.idDeportista = idDeportista;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
}