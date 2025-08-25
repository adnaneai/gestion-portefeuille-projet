package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.AutreNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/autres")
public interface AutreRestController {

    @GetMapping
    List<AutreDTO> getAllAutres();

    @GetMapping("/id/{id}")
    AutreDTO getAutreById(@PathVariable Long id) throws AutreNotFoundException;

    @PostMapping
    AutreDTO createAutre(@RequestBody AutreDTO autreDTO) throws AutreNotFoundException;

    @PutMapping("/id/{id}")
    AutreDTO updateAutre(@PathVariable Long id, @RequestBody AutreDTO autreDTO) throws AutreNotFoundException;
    @DeleteMapping("/id/{id}")
    void deleteAutre(@PathVariable Long id) throws AutreNotFoundException;
}