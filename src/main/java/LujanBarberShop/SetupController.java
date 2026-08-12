package LujanBarberShop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/setup")
public class SetupController {

    private final BarberoRepository barberoRepository;
    private final ServicioRepository servicioRepository;

    public SetupController(BarberoRepository barberoRepository, ServicioRepository servicioRepository) {
        this.barberoRepository = barberoRepository;
        this.servicioRepository = servicioRepository;
    }

    @GetMapping("/inicializar")
    public Map<String, Object> inicializar() {

        Map<String, Object> respuesta = new HashMap<>();
        int barberosCreados = 0;
        int serviciosCreados = 0;

        // Crear barberos si no existen
        if (barberoRepository.count() == 0) {

            String[] nombres = {"Leo", "Tomas", "Nico", "Jere", "Dani"};
            boolean[] jefes = {false, false, false, true, true};
            double[] porcentajes = {0.50, 0.40, 0.40, 1.00, 1.00};

            for (int i = 0; i < nombres.length; i++) {
                Barbero b = new Barbero();
                b.setNombre(nombres[i]);
                b.setActivo(true);
                b.setEsJefe(jefes[i]);
                b.setPorcentajeComision(porcentajes[i]);
                barberoRepository.save(b);
                barberosCreados++;
            }
        }

        // Crear servicios si no existen
        if (servicioRepository.count() == 0) {

            Servicio s1 = new Servicio();
            s1.setNombre("Corte");
            s1.setPrecio(12000.0);
            s1.setActivo(true);
            servicioRepository.save(s1);
            serviciosCreados++;

            Servicio s2 = new Servicio();
            s2.setNombre("Corte + Cejas");
            s2.setPrecio(13000.0);
            s2.setActivo(true);
            servicioRepository.save(s2);
            serviciosCreados++;
        }

        respuesta.put("mensaje", "Setup completado");
        respuesta.put("barberosCreados", barberosCreados);
        respuesta.put("serviciosCreados", serviciosCreados);
        respuesta.put("totalBarberos", barberoRepository.count());
        respuesta.put("totalServicios", servicioRepository.count());

        return respuesta;
    }
}