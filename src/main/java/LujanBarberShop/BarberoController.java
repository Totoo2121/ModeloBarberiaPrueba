package LujanBarberShop;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barberos")
public class BarberoController {

    private final BarberoRepository barberoRepository;

    public BarberoController(BarberoRepository barberoRepository) {
        this.barberoRepository = barberoRepository;
    }

    @GetMapping
    public List<Barbero> listarBarberos() {
        return barberoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Barbero obtenerBarbero(@PathVariable Integer id) {
        return barberoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barbero no encontrado"));
    }
}