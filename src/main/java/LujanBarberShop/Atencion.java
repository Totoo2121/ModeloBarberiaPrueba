package LujanBarberShop;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "atenciones")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Integer idAtencion;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_barbero")
    private Barbero barbero;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "hora_llegada", nullable = false)
    private LocalTime horaLlegada;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nombre_transferencia")
    private String nombreTransferencia;

    @Column(name = "forma_pago", nullable = false)
    private String formaPago = "EFECTIVO";

    @Column(name = "descripcion", nullable = false)
    private String descripcion = "";

    public Atencion() {
    }

    public Integer getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreTransferencia() {
        return nombreTransferencia;
    }

    public void setNombreTransferencia(String nombreTransferencia) {
        this.nombreTransferencia = nombreTransferencia;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}