package LujanBarberShop;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return barberoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Barbero crearBarbero(@RequestBody Barbero barbero) {
        return barberoRepository.save(barbero);
    }

    @PutMapping("/{id}")
    public Barbero actualizarBarbero(@PathVariable Integer id, @RequestBody Barbero barbero) {
        if (!barberoRepository.existsById(id)) return null;
        barbero.setIdBarbero(id);
        return barberoRepository.save(barbero);
    }

    @DeleteMapping("/{id}")
    public void eliminarBarbero(@PathVariable Integer id) {
        barberoRepository.deleteById(id);
    }
}