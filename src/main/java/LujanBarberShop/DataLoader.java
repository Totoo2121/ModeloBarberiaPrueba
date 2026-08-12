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
            Barbero leo = new Barbero();
            leo.setNombre("Leo");
            leo.setActivo(true);
            leo.setEsJefe(false);
            leo.setPorcentajeComision(0.50);
            barberoRepository.save(leo);

            Barbero tomas = new Barbero();
            tomas.setNombre("Tomas");
            tomas.setActivo(true);
            tomas.setEsJefe(false);
            tomas.setPorcentajeComision(0.40);
            barberoRepository.save(tomas);

            Barbero nico = new Barbero();
            nico.setNombre("Nico");
            nico.setActivo(true);
            nico.setEsJefe(false);
            nico.setPorcentajeComision(0.40);
            barberoRepository.save(nico);

            Barbero jere = new Barbero();
            jere.setNombre("Jere");
            jere.setActivo(true);
            jere.setEsJefe(true);
            jere.setPorcentajeComision(1.00);
            barberoRepository.save(jere);

            Barbero dani = new Barbero();
            dani.setNombre("Dani");
            dani.setActivo(true);
            dani.setEsJefe(true);
            dani.setPorcentajeComision(1.00);
            barberoRepository.save(dani);

            System.out.println(">>> ✅ 5 barberos creados");
        }

        if (servicioRepository.count() == 0) {
            Servicio s1 = new Servicio();
            s1.setNombre("Corte");
            s1.setPrecio(12000.0);
            s1.setActivo(true);
            servicioRepository.save(s1);

            Servicio s2 = new Servicio();
            s2.setNombre("Corte + Cejas");
            s2.setPrecio(13000.0);
            s2.setActivo(true);
            servicioRepository.save(s2);

            System.out.println(">>> ✅ 2 servicios creados");
        }

        System.out.println(">>> TOTAL: " + barberoRepository.count() + " barberos, " + servicioRepository.count() + " servicios");
        System.out.println("==========================================");
    }
}