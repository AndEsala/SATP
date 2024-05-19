package projects.patinajeids.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nombre;

    @Column(name = "idade_min")
    private Integer edadMin;

    @Column(name = "idade_max")
    private Integer edadMax;

    @Column(name = "tipo_patin")
    private String tipoPatin;

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
