package LujanBarberShop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {

    @Value("${app.nombre:Barber Shop}")
    private String nombreBarberia;

    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("nombre", nombreBarberia);
        return config;
    }
}