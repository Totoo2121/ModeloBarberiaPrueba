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
        System.out.println("==========================================");
        System.out.println(">>> DataLoader ejecutándose...");
        System.out.println(">>> Barberos existentes: " + barberoRepository.count());
        System.out.println(">>> Servicios existentes: " + servicioRepository.count());

        if (barberoRepository.count() == 0) {
            // Barbero Luciano - 50%
            Barbero b1 = new Barbero();
            b1.setNombre("Luciano");
            b1.setActivo(true);
            b1.setEsJefe(false);
            b1.setPorcentajeComision(0.50);
            barberoRepository.save(b1);

            // Jefe Gabi - 100%
            Barbero b2 = new Barbero();
            b2.setNombre("Gabi");
            b2.setActivo(true);
            b2.setEsJefe(true);
            b2.setPorcentajeComision(1.00);
            barberoRepository.save(b2);

            // Jefe Diego - 100%
            Barbero b3 = new Barbero();
            b3.setNombre("Diego");
            b3.setActivo(true);
            b3.setEsJefe(true);
            b3.setPorcentajeComision(1.00);
            barberoRepository.save(b3);

            System.out.println(">>> ✅ 3 barberos creados: Luciano (50%), Gabi (100%), Diego (100%)");
        }

        if (servicioRepository.count() == 0) {
            Servicio s1 = new Servicio();
            s1.setNombre("Corte de pelo");
            s1.setPrecio(12000.0);
            s1.setActivo(true);
            servicioRepository.save(s1);

            Servicio s2 = new Servicio();
            s2.setNombre("Corte y Barba");
            s2.setPrecio(14000.0);
            s2.setActivo(true);
            servicioRepository.save(s2);

            Servicio s3 = new Servicio();
            s3.setNombre("Barba");
            s3.setPrecio(5000.0);
            s3.setActivo(true);
            servicioRepository.save(s3);

            Servicio s4 = new Servicio();
            s4.setNombre("Claritos");
            s4.setPrecio(40000.0);
            s4.setActivo(true);
            servicioRepository.save(s4);

            Servicio s5 = new Servicio();
            s5.setNombre("Global");
            s5.setPrecio(45000.0);
            s5.setActivo(true);
            servicioRepository.save(s5);

            Servicio s6 = new Servicio();
            s6.setNombre("Ondulaciones");
            s6.setPrecio(40000.0);
            s6.setActivo(true);
            servicioRepository.save(s6);

            Servicio s7 = new Servicio();
            s7.setNombre("Rapado y Barba");
            s7.setPrecio(6000.0);
            s7.setActivo(true);
            servicioRepository.save(s7);

            System.out.println(">>> ✅ 7 servicios creados");
        }

        System.out.println(">>> TOTAL: " + barberoRepository.count() + " barberos, " + servicioRepository.count() + " servicios");
        System.out.println("==========================================");
    }
}
