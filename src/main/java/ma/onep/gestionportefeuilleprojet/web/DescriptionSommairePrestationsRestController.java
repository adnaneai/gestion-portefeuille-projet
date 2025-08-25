package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DescriptionSommairePrestationsDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DescriptionSommairePrestationsNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/description-sommaire-prestations")
public interface DescriptionSommairePrestationsRestController {

    @GetMapping
    List<DescriptionSommairePrestationsDTO> getAllDescriptionSommairePrestations();

    @GetMapping("/id/{id}")
    DescriptionSommairePrestationsDTO getDescriptionSommairePrestationsById(@PathVariable Long id) throws DescriptionSommairePrestationsNotFoundException;

    @PostMapping
    DescriptionSommairePrestationsDTO createDescriptionSommairePrestations(@RequestBody DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO);

    @PutMapping("/id/{id}")
    DescriptionSommairePrestationsDTO updateDescriptionSommairePrestations(@PathVariable Long id, @RequestBody DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO) throws DescriptionSommairePrestationsNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteDescriptionSommairePrestations(@PathVariable Long id) throws DescriptionSommairePrestationsNotFoundException;
}