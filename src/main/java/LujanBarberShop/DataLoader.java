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

        if (barberoRepository.count() == 0) {

            // Crear barberos
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

            // Crear servicios básicos
            Servicio corte = new Servicio();
            corte.setNombre("Corte");
            corte.setPrecio(12000.0);
            corte.setActivo(true);
            servicioRepository.save(corte);

            Servicio corteCejas = new Servicio();
            corteCejas.setNombre("Corte + Cejas");
            corteCejas.setPrecio(13000.0);
            corteCejas.setActivo(true);
            servicioRepository.save(corteCejas);

            System.out.println("✅ Datos iniciales creados correctamente");
        }
    }
}