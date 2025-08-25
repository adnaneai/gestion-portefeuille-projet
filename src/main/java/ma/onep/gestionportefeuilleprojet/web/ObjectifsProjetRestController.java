package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.ObjectifsProjetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/objectifs-projet")
public interface ObjectifsProjetRestController {

    @GetMapping
    List<ObjectifsProjetDTO> getAllObjectifsProjet();

    @GetMapping("/id/{id}")
    ObjectifsProjetDTO getObjectifsProjetById(@PathVariable Long id) throws ObjectifsProjetNotFoundException;

    @GetMapping("/nom/{nomObjectifsProjet}")
    List<ObjectifsProjetDTO> getObjectifsProjetByNom(@PathVariable String nomObjectifsProjet) throws ObjectifsProjetNotFoundException;

    @PostMapping
    ObjectifsProjetDTO createObjectifsProjet(@RequestBody ObjectifsProjetDTO objectifsProjetDTO);

    @PutMapping("/id/{id}")
    ObjectifsProjetDTO updateObjectifsProjet(@PathVariable Long id, @RequestBody ObjectifsProjetDTO objectifsProjetDTO) throws ObjectifsProjetNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteObjectifsProjet(@PathVariable Long id) throws ObjectifsProjetNotFoundException;
}