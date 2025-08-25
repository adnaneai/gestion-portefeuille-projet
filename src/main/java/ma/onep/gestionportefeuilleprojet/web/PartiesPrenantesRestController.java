package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/parties-prenantes")
public interface PartiesPrenantesRestController {

    @GetMapping
    List<PartiesPrenantesDTO> getAllPartiesPrenantes();

    @GetMapping("/id/{id}")
    PartiesPrenantesDTO getPartiesPrenantesById(@PathVariable Long id) throws PartiesPrenantesNotFoundException;

    @GetMapping("/moa/{moa}")
    List<PartiesPrenantesDTO> getPartiesPrenantesByMOA(@PathVariable String moa) throws PartiesPrenantesNotFoundException;

    @GetMapping("/moe/{moe}")
    List<PartiesPrenantesDTO> getPartiesPrenantesByMOE(@PathVariable String moe) throws PartiesPrenantesNotFoundException;

    @GetMapping("/amo/{amo}")
    List<PartiesPrenantesDTO> getPartiesPrenantesByAMO(@PathVariable String amo) throws PartiesPrenantesNotFoundException;

    @PostMapping
    PartiesPrenantesDTO createPartiesPrenantes(@RequestBody PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException;

    @PutMapping("/id/{id}")
    PartiesPrenantesDTO updatePartiesPrenantes(@PathVariable Long id,@RequestBody PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException;

    @DeleteMapping("/id/{id}")
    void deletePartiesPrenantes(@PathVariable Long id) throws PartiesPrenantesNotFoundException;
}