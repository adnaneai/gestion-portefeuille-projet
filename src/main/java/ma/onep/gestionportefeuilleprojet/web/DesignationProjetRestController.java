package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DesignationProjetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/designations-projet")
public interface DesignationProjetRestController {

    @GetMapping
    List<DesignationProjetDTO> getAllDesignationsProjet();

    @GetMapping("/id/{id}")
    DesignationProjetDTO getDesignationProjetById(@PathVariable Long id) throws DesignationProjetNotFoundException;

    @GetMapping("/nom/{nomDesignationProjet}")
    DesignationProjetDTO getDesignationProjetByNom(@PathVariable String nomDesignationProjet) throws DesignationProjetNotFoundException;

    @PostMapping
    DesignationProjetDTO createDesignationProjet(@RequestBody DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException;

    @PutMapping("/id/{id}")
    DesignationProjetDTO updateDesignationProjet(@PathVariable Long id, @RequestBody DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteDesignationProjet(@PathVariable Long id) throws DesignationProjetNotFoundException;
}