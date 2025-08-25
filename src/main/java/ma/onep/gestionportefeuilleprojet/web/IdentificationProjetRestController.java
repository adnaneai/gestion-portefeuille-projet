package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.IdentificationProjetDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.IdentificationProjetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/identification-projets")
public interface IdentificationProjetRestController {

    @GetMapping
    List<IdentificationProjetDTO> getAllIdentificationProjets();

    @GetMapping("/{id}")
    IdentificationProjetDTO getIdentificationProjetById(@PathVariable Long id) throws IdentificationProjetNotFoundException;

    @GetMapping("/code/{code}")
    IdentificationProjetDTO getIdentificationProjetByCode(@PathVariable String code) throws IdentificationProjetNotFoundException;

    @GetMapping("/id-projet/{idProjet}")
    IdentificationProjetDTO getIdentificationProjetByIdProjet(@PathVariable String idProjet) throws IdentificationProjetNotFoundException;

    @GetMapping("/intitule/{intitule}")
    IdentificationProjetDTO getIdentificationProjetByIntitule(@PathVariable String intitule) throws IdentificationProjetNotFoundException;

    @PostMapping
    IdentificationProjetDTO createIdentificationProjet(@RequestBody IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException;

    @PutMapping("/id/{id}")
    IdentificationProjetDTO updateIdentificationProjetById(@PathVariable Long id, @RequestBody IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException;

    @PutMapping("/code/{code}")
    IdentificationProjetDTO updateIdentificationProjetByCode(@PathVariable String code, @RequestBody IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException;

    @PutMapping("/id-projet/{idProjet}")
    IdentificationProjetDTO updateIdentificationProjetByIdProjet(@PathVariable String idProjet, @RequestBody IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException;

    @PutMapping("/intitule/{intitule}")
    IdentificationProjetDTO updateIdentificationProjetByIntitule(@PathVariable String intitule, @RequestBody IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteIdentificationProjetById(@PathVariable Long id) throws IdentificationProjetNotFoundException;

    @DeleteMapping("/code/{code}")
    void deleteIdentificationProjetByCode(@PathVariable String code) throws IdentificationProjetNotFoundException;

    @DeleteMapping("/id-projet/{idProjet}")
    void deleteIdentificationProjetByIdProjet(@PathVariable String idProjet) throws IdentificationProjetNotFoundException;

    @DeleteMapping("/intitule/{intitule}")
    void deleteIdentificationProjetByIntitule(@PathVariable String intitule) throws IdentificationProjetNotFoundException;
}