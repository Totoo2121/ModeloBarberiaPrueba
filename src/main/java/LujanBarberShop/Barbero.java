package LujanBarberShop;

import jakarta.persistence.*;

@Entity
@Table(name = "barberos")
public class Barbero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barbero")
    private Integer idBarbero;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "es_jefe", nullable = false)
    private Boolean esJefe = false;

    public Barbero() {
    }

    public Integer getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(Integer idBarbero) {
        this.idBarbero = idBarbero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getEsJefe() {
        return esJefe;
    }

    public void setEsJefe(Boolean esJefe) {
        this.esJefe = esJefe;
    }

@Column(name = "porcentaje_comision", nullable = false)
private Double porcentajeComision = 0.40;

public Double getPorcentajeComision() {
    return porcentajeComision;
}

public void setPorcentajeComision(Double porcentajeComision) {
    this.porcentajeComision = porcentajeComision;
}
}