package LujanBarberShop;

import java.time.LocalDateTime;
import java.util.List;
import java.time.ZoneId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atenciones")
public class AtencionController {

    private final AtencionRepository atencionRepository;
    private final ServicioRepository servicioRepository;
    private final BarberoRepository barberoRepository;

    public AtencionController(
            AtencionRepository atencionRepository,
            ServicioRepository servicioRepository,
            BarberoRepository barberoRepository) {

        this.atencionRepository = atencionRepository;
        this.servicioRepository = servicioRepository;
        this.barberoRepository = barberoRepository;
    }

    // ==========================================
    // LISTAR TODAS LAS ATENCIONES
    // ==========================================

    @GetMapping
    public List<Atencion> listarAtenciones() {
        return atencionRepository.findAll();
    }

    // ==========================================
    // REGISTRAR UN CORTE
    // ==========================================

    @PostMapping
    public Atencion crearAtencion(@RequestBody AtencionRequest request) {

        Servicio servicio = servicioRepository
                .findById(request.getIdServicio())
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));

        Barbero barbero = barberoRepository
                .findById(request.getIdBarbero())
                .orElseThrow(() ->
                        new RuntimeException("Barbero no encontrado"));

        Atencion atencion = new Atencion();

        java.time.ZoneId zonaArg = java.time.ZoneId.of("America/Argentina/Buenos_Aires");
        LocalDateTime ahora = LocalDateTime.now(zonaArg);
        atencion.setBarbero(barbero);
        atencion.setServicio(servicio);

        atencion.setFechaHora(ahora);
        atencion.setFecha(ahora);
        atencion.setHoraLlegada(ahora.toLocalTime());

        atencion.setPrecio(servicio.getPrecio());

        atencion.setEstado("FINALIZADO");

        atencion.setDescripcion(
                request.getDescripcion() == null
                        ? ""
                        : request.getDescripcion()
        );

        atencion.setFormaPago(
                request.getFormaPago() == null
                        ? "EFECTIVO"
                        : request.getFormaPago()
        );

        atencion.setNombreTransferencia(
                request.getNombreTransferencia()
        );

        return atencionRepository.save(atencion);
    }

    // ==========================================
    // ELIMINAR UN CORTE
    // ==========================================

    @DeleteMapping("/{id}")
    public void eliminarAtencion(@PathVariable Integer id) {

        if (!atencionRepository.existsById(id)) {
            throw new RuntimeException(
                    "El corte con ID " + id + " no existe"
            );
        }

        atencionRepository.deleteById(id);
    }

    // ==========================================
    // DATOS RECIBIDOS DESDE LA PÁGINA
    // ==========================================

    public static class AtencionRequest {

        private Integer idServicio;
        private Integer idBarbero;

        private String descripcion;
        private String formaPago;
        private String nombreTransferencia;

        public Integer getIdServicio() {
            return idServicio;
        }

        public void setIdServicio(Integer idServicio) {
            this.idServicio = idServicio;
        }

        public Integer getIdBarbero() {
            return idBarbero;
        }

        public void setIdBarbero(Integer idBarbero) {
            this.idBarbero = idBarbero;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getFormaPago() {
            return formaPago;
        }

        public void setFormaPago(String formaPago) {
            this.formaPago = formaPago;
        }

        public String getNombreTransferencia() {
            return nombreTransferencia;
        }

        public void setNombreTransferencia(String nombreTransferencia) {
            this.nombreTransferencia = nombreTransferencia;
        }
    }
}