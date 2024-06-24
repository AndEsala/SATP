package projects.patinajeids.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCategoria;

    @NotBlank(message = "El nombre no puede estar vacío!")
    private String nombre;

    @NotNull(message = "La Edad Mínima no puede estar vacía")
    @Min(value = 3, message = "La edad mínima debe ser mayor o igual que 3")
    private Integer edadMin;

    @NotNull(message = "La Edad Máxima no puede estar vacía")
    private Integer edadMax;

    @NotBlank(message = "El tipo de patín no puede estar vacío!")
    @Column(name = "tipo_patin")
    private String tipoPatin;

    /* Getters & Setters */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(Integer edadMin) {
        this.edadMin = edadMin;
    }

    public Integer getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(Integer edadMax) {
        this.edadMax = edadMax;
    }

    public String getTipoPatin() {
        return tipoPatin;
    }

    public void setTipoPatin(String tipoPatin) {
        this.tipoPatin = tipoPatin;
    }   
}
