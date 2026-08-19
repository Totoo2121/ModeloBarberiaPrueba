package LujanBarberShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BarberoRepository barberoRepository;
    private final ServicioRepository servicioRepository;

    public DataLoader(BarberoRepository barberoRepository, ServicioRepository servicioRepository) {
        this.barberoRepository = barberoRepository;
        this.servicioRepository = servicioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> Barberos: " + barberoRepository.count());
        System.out.println(">>> Servicios: " + servicioRepository.count());

        if (barberoRepository.count() == 0) {
            Barbero b1 = new Barbero(); b1.setNombre("Barbero 1"); b1.setActivo(true); b1.setEsJefe(false); b1.setPorcentajeComision(0.50); barberoRepository.save(b1);
            Barbero b2 = new Barbero(); b2.setNombre("Barbero 2"); b2.setActivo(true); b2.setEsJefe(false); b2.setPorcentajeComision(0.40); barberoRepository.save(b2);
            Barbero b3 = new Barbero(); b3.setNombre("Dueño"); b3.setActivo(true); b3.setEsJefe(true); b3.setPorcentajeComision(1.00); barberoRepository.save(b3);
            System.out.println(">>> ✅ 3 barberos creados");
        }

        if (servicioRepository.count() == 0) {
            Servicio s1 = new Servicio(); s1.setNombre("Corte"); s1.setPrecio(10000.0); s1.setActivo(true); servicioRepository.save(s1);
            Servicio s2 = new Servicio(); s2.setNombre("Corte + Barba"); s2.setPrecio(12000.0); s2.setActivo(true); servicioRepository.save(s2);
            Servicio s3 = new Servicio(); s3.setNombre("Barba"); s3.setPrecio(6000.0); s3.setActivo(true); servicioRepository.save(s3);
            System.out.println(">>> ✅ 3 servicios creados");
        }
    }
}